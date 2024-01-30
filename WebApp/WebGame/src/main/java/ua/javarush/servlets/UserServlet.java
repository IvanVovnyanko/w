package ua.javarush.servlets;

import ua.javarush.models.User;
import ua.javarush.repository.UserRepository;
import ua.javarush.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/users")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserService userService;
    private UserRepository userRepository;
    private int id = 1;

    public void init() {
        userRepository = new UserRepository();
        userService = new UserService(userRepository);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String email = request.getParameter("email");


        User user = new User(name, age, email, id);

        // Збережіть користувача через сервіс
        userService.create(id, user);
        id++;


        response.sendRedirect(request.getContextPath() + "/users");
    }
}
