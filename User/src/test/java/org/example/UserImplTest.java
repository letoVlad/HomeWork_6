package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class UserImplTest {
    private UserImpl userImpl;
    private User testUser;
    private User testUser2;


    @BeforeEach
    void setUp() {
        userImpl = new UserImpl();
        testUser = new User(1, "name", "password", "email", new ArrayList<>());
        testUser2 = new User(2, "name", "password", "email", new ArrayList<>());
    }

    @Test
    void checkThatANewUserHasBeenAdded() {
        userImpl.addUser(testUser);
        assertEquals(userImpl.getUser(1), testUser);
    }

    @Test
    void checkThatAllUsersAreReturned() {
        userImpl.addUser(testUser);
        userImpl.addUser(testUser2);
        assertEquals(2, userImpl.allUsers().size());
    }

    @Test
    void checkThatTheUserExists() {
        userImpl.addUser(testUser);
        User user = userImpl.getUser(1);
        assertEquals(testUser, user);
    }

    @Test
    void checkThatTheGetUserMethodCausesAnErrorNoSuchElementException() {
        assertThrows(NoSuchElementException.class, () -> userImpl.getUser(testUser.getId()));
    }

    @Test
    void checkThatTheUserHasBeenDeleted() {
        userImpl.addUser(testUser);
        assertEquals(testUser, userImpl.getUser(testUser.getId()));
        userImpl.deleteUser(testUser.getId());
        assertNull(userImpl.allUsers().get(1));
    }
}