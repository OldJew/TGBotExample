package ru.oldjew.telegrambotexample.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.oldjew.telegrambotexample.model.Incomes;
import ru.oldjew.telegrambotexample.repository.StatsRepository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


//@SpringBootTest
//class StatsServiceTest {
//
//    @InjectMocks
//    StatsRepository statsRepository;
//    @Mock
//    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
//
//    @Test
//    void getCountOfIncomesThatGreaterThan() {
//        Incomes income = new Incomes();
//        income.setChatId(123L);
//        income.setId(1l);
//        income.setIncome(new BigDecimal(100));
//        Optional<Integer> result = Optional.of(statsRepository.getCountOfIncomesThatGreaterThan(new BigDecimal(90)));
//        assertTrue(result.isPresent());
//        assertEquals(1,result.get());
//    }
//
//    @Test
//    void getStatsBetweenDates() {
//    }
//
//}