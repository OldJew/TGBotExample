package ru.oldjew.telegrambotexample.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StatsData {


    private String operation;

    private int value;

    private LocalDate date;

    public StatsData(String operation) {
        this.operation = operation;
    }

    public StatsData() {
    }
}
