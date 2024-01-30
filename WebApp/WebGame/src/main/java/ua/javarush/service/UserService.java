package ua.javarush.service;

import ua.javarush.exceptions.InvalidParamException;
import ua.javarush.exceptions.UserNotFoundException;
import ua.javarush.models.User;
import ua.javarush.repository.UserRepository;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class UserService {
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void create(Integer id, User user) {
        if (id <= 0) {
            throw new InvalidParamException("Id cannot be less or equal zero!");
        }
        validation(user);
        userRepository.save(user);
    }

    public void delete(Integer id) {
        userRepository.getById(id).orElseThrow(() -> new UserNotFoundException(
                String.format("User with id = %d not found!", id)
        ));
        userRepository.delete(id);
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUser();
    }

    private void validation(User user) {
        if (Objects.isNull(user)) {
            throw new InvalidParamException("User is null");
        }
        if (user.getName().isEmpty()) {
            throw new InvalidParamException("User firstName is empty");
        }
        if (user.getAge() <= 0) {
            throw new InvalidParamException("User age is 0 or less than zero!");
        }
        if (user.getEmail().isEmpty()) {
            throw new InvalidParamException("User email is empty");
        }
        if (!VALID_EMAIL_ADDRESS_REGEX.matcher(user.getEmail()).matches()) {
            throw new InvalidParamException("User email is invalid");
        }
    }

}