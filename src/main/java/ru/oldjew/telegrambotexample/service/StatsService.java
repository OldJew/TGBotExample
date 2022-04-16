package ru.oldjew.telegrambotexample.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.oldjew.telegrambotexample.model.StatsData;
import ru.oldjew.telegrambotexample.repository.StatsRepository;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatsService {

    private final StatsRepository statsRepository;

    public int getCountOfIncomesThatGreaterThan(BigDecimal amount){
        return statsRepository.getCountOfIncomesThatGreaterThan(amount);
    }

    public List<StatsData> getStatsBetweenDates(String from, String to){
        List<StatsData> statsData = statsRepository.getStatsBetweenDates(from, to);
        statsData.sort(new Comparator<StatsData>() {
            @Override
            public int compare(StatsData o1, StatsData o2) {
                return o1.getDate().compareTo(o2.getDate());
            }
        });
        return statsData;
    }
}
