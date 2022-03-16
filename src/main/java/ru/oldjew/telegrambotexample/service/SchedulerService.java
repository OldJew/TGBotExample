package ru.oldjew.telegrambotexample.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.oldjew.telegrambotexample.dao.ActiveChatRepository;
import ru.oldjew.telegrambotexample.dto.CentralRussianBankService;
import ru.oldjew.telegrambotexample.dto.ValuteCursOnDate;
import ru.oldjew.telegrambotexample.model.ActiveChat;

import javax.xml.datatype.DatatypeConfigurationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SchedulerService {

    private final ActiveChatRepository activeChatRepository;
    private final CentralRussianBankService centralRussianBankService;
    private final BotService botService;
    private final List<ValuteCursOnDate> previousRates = new ArrayList<>();

    public void notifyAboutChangesInCurrencyRate(){
        try {
            List<ValuteCursOnDate> currentRates = centralRussianBankService.getCurrenciesFromCbr();
            Set<Long> activeChatIds = activeChatRepository.findAll().stream().map(ActiveChat::getChatId).collect(Collectors.toSet());
            if (!previousRates.isEmpty()){
                for (int index = 0; index < currentRates.size(); index++){
                    if (currentRates.get(index).getCourse() - previousRates.get(index).getCourse() >= 10){
                        botService.sendNotificationToAllActiveChats("Курс " + currentRates.get(index).getName() +
                                " увеличился на 10 руб", activeChatIds);
                    }if (currentRates.get(index).getCourse() - previousRates.get(index).getCourse() <= 10){
                        botService.sendNotificationToAllActiveChats("Курс " + currentRates.get(index).getName() +
                                " уменьшился на 10 руб", activeChatIds);
                    }
                }
            } else {
                previousRates.addAll(currentRates);
            }
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
    }
}
