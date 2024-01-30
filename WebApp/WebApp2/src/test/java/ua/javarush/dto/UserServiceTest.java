package ua.javarush.dto;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ua.javarush.models.User;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    private static final User IVAN = new User("Ivan", 20 , "123mail@gmail.com", 1);
    private static final User PETR = new User("Petr", 22 , "123Petrmail@gmail.com", 2);


    @Test
    void createUserWithoutError() {

    }

}