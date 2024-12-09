package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class MessageImpl implements MessageService {
    Map<Integer, Message> messagesMap = new HashMap<>();
    UserImpl userImpl;


    public MessageImpl(UserImpl userImpl) {
        this.userImpl = userImpl;
    }

    @Override
    public Message newMessage(Message message) {
        return messagesMap.put(message.getId(), message);
    }

    @Override
    public Map<Integer, Message> allMessages() {
        return messagesMap;
    }

    @Override
    public void sendMessage(Message message, User user) {
        if (userImpl.getUser(user.getId()) != null) {
            messagesMap.put(message.getId(), message);
            List<Integer> messageList = user.getMessageIds();
            messageList.add(message.getId());
            user.setMessageIds(messageList);

        } else {
            throw new NoSuchElementException("Данный пользователь не найден" + user.getId());
        }
    }

    @Override
    public void deleteMessage(Message message) {
        messagesMap.remove(message.getId());
    }
}
