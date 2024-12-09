package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;


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
        Message result = messageService.newMessage(testMessage);
        assertNull(result);

        assertEquals(testMessage, messageService.messagesMap.get(testMessage.getId()));

        Message newTestMessage = new Message(1, "Updated Message", testUser);
        Message previousMessage = messageService.newMessage(newTestMessage);
        assertEquals(testMessage, previousMessage);

        assertEquals(newTestMessage, messageService.messagesMap.get(newTestMessage.getId()));
    }


    @Test
    void testGetMessage() {
        messageService.sendMessage(testMessage, testUser);
        assertEquals(testMessage, messageService.allMessages().get(1));
    }

    @Test
    void errorWhatTheUserWillNotFind() {
        assertThrows(NoSuchElementException.class, () -> messageService.sendMessage(testMessage, new User()));
    }

    @Test
    void verifyingThatAMessageIsBeingCreated() {
        messageService.newMessage(testMessage);
        assertEquals(testMessage, messageService.allMessages().get(1));
    }

    @Test
    void checkThatTheMessageHasBeenDeleted() {
        messageService.newMessage(testMessage);
        assertEquals(testMessage, messageService.allMessages().get(1));

        messageService.deleteMessage(testMessage);
        assertNull(messageService.allMessages().get(1));
    }
}