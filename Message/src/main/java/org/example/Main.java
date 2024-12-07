package org.example;

import java.util.ArrayList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        UserImpl userService = new UserImpl();
        MessageImpl messageService = new MessageImpl(userService);

        // Создаем пользователя и добавляем в сервис
        User user1 = new User(1, "name", "213", "qweqw", new ArrayList<>());
        userService.addUser(user1);

        // Создаем сообщение
        Message message1 = new Message(1, "Hello, World!", user1);
        messageService.sendMessage(message1, user1);
        Map<Integer, Message> integerMessageMap = messageService.allMessages();
        for (Map.Entry<Integer, Message> entry : integerMessageMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }
}

