package ru.oldjew.telegrambotexample.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="ACTIVE_CHAT", schema = "public")
public class ActiveChat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="CHAT_ID")
    private long chatId;
}
