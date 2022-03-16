package ru.oldjew.telegrambotexample.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.oldjew.telegrambotexample.dao.IncomesRepository;
import ru.oldjew.telegrambotexample.dao.SpendsRepository;
import ru.oldjew.telegrambotexample.model.Incomes;
import ru.oldjew.telegrambotexample.model.Spends;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class FinanceService {
    private static final String ADD_INCOME = "/addincome";

    private final IncomesRepository incomesRepository;
    private final SpendsRepository spendsRepository;

    public String addFinanceOperation(String operationType, String price, Long chatId){
        String message;
        if (ADD_INCOME.equalsIgnoreCase(operationType)){
            Incomes income = new Incomes();
            income.setChatId(chatId);
            income.setIncome(new BigDecimal(price));
            incomesRepository.save(income);
            message = "Доход в размере " + price + " был успешно добавлен";
        } else {
            Spends spend = new Spends();
            spend.setChatId(chatId);
            spend.setSpend(new BigDecimal(price));
            spendsRepository.save(spend);
            message = "Расход в размере " + price + " был успешно добавлен";
        }
        return message;
    }
}
