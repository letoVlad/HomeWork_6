package org.example;

import java.util.Map;
import java.util.NoSuchElementException;

public class SearchUserImpl implements SearchUserService {
    UserImpl userImpl;

    public SearchUserImpl(UserImpl user) {
        this.userImpl = user;
    }

    User searchByNickname(String nickName) {
        Map<Integer, User> integerUserMap = userImpl.allUsers();
        for (Map.Entry<Integer, User> entry : integerUserMap.entrySet()) {
            if (nickName.equals(entry.getValue().getName())) {
                return entry.getValue();
            }
        }
        throw new NoSuchElementException("Пользователь не найден");
    }

    User searchById(int id) {
        return userImpl.getUser(id);
    }
}
