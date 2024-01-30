package ua.javarush.dto;

import ua.javarush.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> users = new ArrayList<>();
    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    public void createUser(User user) {
        users.add(user);
    }

    public void deleteUser(long userId) {
        users.removeIf(user -> user.getId() == userId);
    }
}