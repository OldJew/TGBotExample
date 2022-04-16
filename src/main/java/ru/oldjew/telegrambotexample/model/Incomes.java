package ru.oldjew.telegrambotexample.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Table(name = "INCOMES", schema = "public")
@Data
public class Incomes {

    public Incomes() {
    }

    public Incomes(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CHAT_ID")
    private Long chatId;

    @Column(name = "INCOME")
    private BigDecimal income;

    @Column(name = "DATE")
    private LocalDate date;
}
