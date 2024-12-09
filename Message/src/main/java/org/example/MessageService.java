package org.example;

import java.util.Map;

public interface MessageService {

    Message newMessage(Message message);

    Map<Integer, Message> allMessages();

    void sendMessage(Message message, User user);

    void deleteMessage(Message message);
}
