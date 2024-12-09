package org.example;

import java.util.Map;

public interface UserService {


    User addUser(User user);

    Map<Integer, User> allUsers();

    User getUser(int id);

    void deleteUser(int id);
}
