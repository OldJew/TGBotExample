package ru.oldjew.telegrambotexample.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.oldjew.telegrambotexample.model.Spends;

@Repository
public interface SpendsRepository extends JpaRepository<Spends, Long> {
}
