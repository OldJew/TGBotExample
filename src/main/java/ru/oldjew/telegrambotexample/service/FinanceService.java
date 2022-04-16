package ru.oldjew.telegrambotexample.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import ru.oldjew.telegrambotexample.repository.IncomesRepository;
import ru.oldjew.telegrambotexample.repository.SpendsRepository;
import ru.oldjew.telegrambotexample.model.Incomes;
import ru.oldjew.telegrambotexample.model.Spends;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class FinanceService {
    private static final String ADD_INCOME = "/addincome";

    private final IncomesRepository incomesRepository;
    private final SpendsRepository spendsRepository;

    public String addFinanceOperation(String operationType, String price, Long chatId) {
        String message;
        if (ADD_INCOME.equalsIgnoreCase(operationType)) {
            Incomes income = new Incomes();
            income.setChatId(chatId);
            income.setIncome(new BigDecimal(price));
            income.setDate(LocalDate.now());
            incomesRepository.save(income);
            message = "Доход в размере " + price + " был успешно добавлен";
        } else {
            Spends spend = new Spends();
            spend.setChatId(chatId);
            spend.setSpend(new BigDecimal(price));
            spend.setDate(LocalDate.now());
            spendsRepository.save(spend);
            message = "Расход в размере " + price + " был успешно добавлен";
        }
        return message;
    }

    public String getStatsBetweenDates(@RequestParam(value = "from") String from, @RequestParam(value = "to") String to) {
        String message= null;

        return message;
    }

}
