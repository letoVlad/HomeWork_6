package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        UserImpl userService = new UserImpl();
        MessageImpl messageService = new MessageImpl(userService);
        SearchUserImpl searchUser = new SearchUserImpl(userService);

        User user1 = new User(1, "name", "213", "qweqw", new ArrayList<>());
        userService.addUser(user1);

        System.out.println(searchUser.searchByNickname("name"));

    }
}