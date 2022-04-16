package ru.oldjew.telegrambotexample.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import ru.oldjew.telegrambotexample.model.Incomes;
import ru.oldjew.telegrambotexample.repository.IncomesRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class IncomesRepositoryTest {


    @Autowired
    private IncomesRepository incomesRepository;

    @Test
    @DisplayName("INCOMES_REPOSITORY_TEST")
    public void testRepository() {
        for (int i = 0; i < 10; i++) {
            incomesRepository.save(new Incomes());
        }

        final List<Incomes> incomes = incomesRepository.findAll();
        assertEquals(10, incomes.size());
    }

}