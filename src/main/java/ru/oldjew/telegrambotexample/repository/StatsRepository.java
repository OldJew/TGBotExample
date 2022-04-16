package ru.oldjew.telegrambotexample.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.oldjew.telegrambotexample.model.StatsData;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class StatsRepository {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private static final String INCOME_OPERATION ="Доходы:";
    private static final String SPENDS_OPERATION ="Расходы:";

    public int getCountOfIncomesThatGreaterThan(BigDecimal amount){
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("amount", amount);
        return namedParameterJdbcTemplate.queryForObject("SELECT count(*) from INCOMES WHERE income > :amount",
                parameters, new StatsRowMapper());
    }

    private static final class StatsRowMapper implements RowMapper<Integer>{
        @Override
        public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
            return rs.getInt("COUNT");
        }
    }

    public List<StatsData> getStatsBetweenDates(String fromString, String toString){
        Map<String, LocalDate> parameters = new HashMap<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate from = LocalDate.parse(fromString, formatter);
        LocalDate to = LocalDate.parse(toString, formatter);
        parameters.put("from", from);
        parameters.put("to", to);
        List<StatsData> statsDataList = namedParameterJdbcTemplate.query("SELECT incomes.date, incomes.income" +
                " FROM incomes WHERE incomes.date BETWEEN :from AND :to",
                parameters, new StatsBetweenDatesRawMapper(INCOME_OPERATION));
        statsDataList.addAll(namedParameterJdbcTemplate.query("select spends.date, spends.spend from spends" +
                " WHERE spends.date BETWEEN :from AND :to", parameters, new StatsBetweenDatesRawMapper(SPENDS_OPERATION)));
        return statsDataList;
    }

    private static final class StatsBetweenDatesRawMapper implements RowMapper<StatsData>{
        String operation;

        public StatsBetweenDatesRawMapper(String operation) {
            this.operation = operation;
        }

        @Override
        public StatsData mapRow(ResultSet rs, int rowNum) throws SQLException {
            StatsData statsData = new StatsData(operation);
            //column 1 - date, column 2 - value
            statsData.setDate(rs.getDate(1).toLocalDate());
            statsData.setValue(rs.getInt(2));
            return statsData;
        }
    }


}
