package ru.oldjew.telegrambotexample.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "SPENDS", schema = "public")
@Data
public class Spends {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CHAT_ID")
    private Long chatId;

    @Column(name = "SPEND")
    private BigDecimal spend;

    @Column(name = "DATE")
    private LocalDate date;
}
