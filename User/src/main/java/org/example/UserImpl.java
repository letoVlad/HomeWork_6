package org.example;

import java.util.HashMap;
import java.util.Map;

public class UserImpl implements UserService {
    Map<Integer, User> usermap = new HashMap<>();

    User addUser(User user) {
        return usermap.put(user.getId(), user);
    }

    Map<Integer, User> allUsers() {
        return usermap;
    }

    User getUser(int id) {
        return usermap.get(id);
    }

    void deleteUser(int id) {
        usermap.remove(id);
    }

}
