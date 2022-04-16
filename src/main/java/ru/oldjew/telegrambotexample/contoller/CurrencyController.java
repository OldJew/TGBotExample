package ru.oldjew.telegrambotexample.contoller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.oldjew.telegrambotexample.dto.CentralRussianBankService;
import ru.oldjew.telegrambotexample.dto.ValuteCursOnDate;
import ru.oldjew.telegrambotexample.model.StatsData;
import ru.oldjew.telegrambotexample.service.StatsService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CurrencyController {

    private final CentralRussianBankService centralRussianBankService;
    private final StatsService statsService;

    @GetMapping("/getCurrencies")
    public List<ValuteCursOnDate> getValuteCursOnDate() throws Exception {
        return centralRussianBankService.getCurrenciesFromCbr();
    }

    @GetMapping("/getStats")
    @ApiOperation(value = "получение количества пополнений, которые превышают определенную сумму")
    public int getStatsAboutIncomesThanGreater(@RequestParam(value = "amount") BigDecimal amount){
        return statsService.getCountOfIncomesThatGreaterThan(amount);
    }

    @GetMapping("/getStatsBetweenDates")
    public List<StatsData> getStatsBetweenDates(@RequestParam(value = "from") String from, @RequestParam(value = "to") String to){
        return statsService.getStatsBetweenDates(from, to);
    }
}
