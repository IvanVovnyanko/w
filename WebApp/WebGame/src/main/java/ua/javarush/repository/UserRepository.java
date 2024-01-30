package ua.javarush.repository;

import ua.javarush.models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class UserRepository {

    private HashMap<Integer, User> db = new HashMap<>();


    public void save(User user) {
        db.put(user.getId(), user);
    }

    public void delete(Integer id) {
        db.remove(id);
    }

    public List<User> getAllUser() {
        return new ArrayList<>(db.values());
    }

    public Optional<User> getById(Integer id) {
        return Optional.ofNullable(db.get(id));
    }
}

