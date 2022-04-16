package ru.oldjew.telegrambotexample.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.oldjew.telegrambotexample.model.ActiveChat;
import ru.oldjew.telegrambotexample.repository.ActiveChatRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ActiveChatRepositoryTest {

    @Autowired
    private ActiveChatRepository activeChatRepository;

    @Test
    void findActiveChatByChatIdShouldReturnOK() {
        final ActiveChat activeChat = new ActiveChat();
        activeChat.setChatId(1234L);
        activeChatRepository.save(activeChat);

        Optional<ActiveChat> result = activeChatRepository.findActiveChatByChatId(1234L);
        assertTrue(result.isPresent());
    }

    @Test
    void findActiveChatByChatIdShouldReturnFalse(){

        final ActiveChat activeChat = new ActiveChat();
        activeChat.setChatId(1234L);
        activeChatRepository.save(activeChat);

        Optional<ActiveChat> result = activeChatRepository.findActiveChatByChatId(5555L);
        assertFalse(result.isPresent());
    }
}