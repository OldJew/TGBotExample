package ru.oldjew.telegrambotexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableScheduling
@SpringBootApplication
public class TelegramBotExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(TelegramBotExampleApplication.class, args);
    }

}
