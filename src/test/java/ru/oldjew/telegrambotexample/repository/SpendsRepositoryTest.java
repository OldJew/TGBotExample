package ru.oldjew.telegrambotexample.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.oldjew.telegrambotexample.model.Spends;
import ru.oldjew.telegrambotexample.repository.SpendsRepository;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class SpendsRepositoryTest {

    @Autowired
    private SpendsRepository spendsRepository;

    @Test
    void ifAddSpendShouldAddSpend(){
        final Spends spend = new Spends();
        spend.setChatId(111l);

        spendsRepository.save(spend);

        Spends result = spendsRepository.getOne(1l);
        assertEquals(111L, result.getChatId());

    }
}