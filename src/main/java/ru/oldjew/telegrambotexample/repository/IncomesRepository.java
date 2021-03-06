package ru.oldjew.telegrambotexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.oldjew.telegrambotexample.model.Incomes;

@Repository
public interface IncomesRepository extends JpaRepository<Incomes, Long> {

}
