package ru.oldjew.telegrambotexample.service;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import ru.oldjew.telegrambotexample.dao.IncomesRepository;
import ru.oldjew.telegrambotexample.dao.SpendsRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FinanceServiceTest {

    @InjectMocks
    private FinanceService financeService;

    @Mock
    private SpendsRepository spendsRepository;

    @Mock
    private IncomesRepository incomesRepository;

    @BeforeAll
    public void beforeAll(){
        System.out.println(System.currentTimeMillis());
    }

    @AfterAll
    public void afterAll(){
        System.out.println(System.currentTimeMillis());
    }
    @DisplayName("ADD_INCOME_test")
    @Test
    public void whenAddIncomeShouldAddIncome(){
        String price = "200";

        String message = financeService.addFinanceOperation("/addincome", price, 100L);
        Assertions.assertEquals("Доход в размере " + price + " был успешно добавлен", message);
    }

    @DisplayName("ADD_SPEND_test")
    @Test
    public void whenAddSpendShouldAddSpend(){
        String price = "200";

        String message = financeService.addFinanceOperation("/addspend", price, 100L);
        Assertions.assertEquals("Расход в размере " + price + " был успешно добавлен", message);
    }
}