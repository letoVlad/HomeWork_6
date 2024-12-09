package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class SearchUserImplTest {
    private UserImpl userImplMock;
    private SearchUserImpl searchUser;

    @BeforeEach
    void setUp() {
        userImplMock = Mockito.mock(UserImpl.class);
        searchUser = new SearchUserImpl(userImplMock);
    }

    @Test
    void searchByNickname_Found() {
        Map<Integer, User> users = new HashMap<>();
        User user = new User(1, "John", "password", "email", new ArrayList<>());
        users.put(1, user);
        when(userImplMock.allUsers()).thenReturn(users);

        User result = searchUser.searchByNickname("John");

        assertNotNull(result);
        assertEquals("John", result.getName());
    }

    @Test
    void searchByNickname_NotFound() {
        Map<Integer, User> users = new HashMap<>();
        users.put(1, new User(1, "John", "password", "email", new ArrayList<>()));

        when(userImplMock.allUsers()).thenReturn(users);

        assertThrows(NoSuchElementException.class, () -> searchUser.searchByNickname("Bob"));
    }

    @Test
    void searchById_Found() {
        User user = new User(1, "John", "password", "email", new ArrayList<>());
        when(userImplMock.getUser(1)).thenReturn(user);

        User result = searchUser.searchById(1);

        assertNotNull(result);
        assertEquals("John", result.getName());
    }

}