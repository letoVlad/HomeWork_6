package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class UserImpl implements UserService {
    Map<Integer, User> usermap = new HashMap<>();

    @Override
    public User addUser(User user) {
        return usermap.put(user.getId(), user);
    }

    @Override
    public Map<Integer, User> allUsers() {
        return usermap;
    }

    @Override
    public User getUser(int id) {
        if (usermap.get(id) != null) {
            return usermap.get(id);
        }
        throw new NoSuchElementException("Данный пользователь не найден" + id);
    }

    @Override
    public void deleteUser(int id) {
        usermap.remove(id);
    }

}
