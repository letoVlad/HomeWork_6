package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Incubating;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MessageImplTest {
    private MessageImpl messageService;
    private Message testMessage;
    private User testUser;

    @BeforeEach
    void setUp() {
        UserImpl mockUserImpl = Mockito.mock(UserImpl.class);
        messageService = new MessageImpl(mockUserImpl);
        testUser = new User(1, "name", "password", "email", new ArrayList<>());
        testMessage = new Message(1, "Test Message", testUser);

        Mockito.when(mockUserImpl.getUser(1)).thenReturn(testUser);

    }


    @Test
    void testNewMessage() {
        //Проверяем, что нет сообщений
        Message result = messageService.newMessage(testMessage);
        assertNull(result);

        // Проверяем, что сообщение добавилось в карту
        assertEquals(testMessage, messageService.messagesMap.get(testMessage.getId()));

        // Добавляем сообщение с тем же ID, проверяем возврат предыдущего значения
        Message newTestMessage = new Message(1, "Updated Message", testUser);
        Message previousMessage = messageService.newMessage(newTestMessage);
        assertEquals(testMessage, previousMessage);

        // Проверяем, что новое сообщение обновилось
        assertEquals(newTestMessage, messageService.messagesMap.get(newTestMessage.getId()));
    }


    @Test
    void testGetMessage() {
        messageService.sendMessage(testMessage, testUser);


        assertEquals(testMessage, messageService.allMessages().get(1));
    }
}