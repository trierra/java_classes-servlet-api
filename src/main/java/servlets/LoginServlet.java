package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = {"/login", "register"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getServletPath().equals("/login")) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        } else {
            response.sendRedirect(request.getContextPath() + "/register.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, String> messages = new HashMap<String, String>();

        request.setAttribute("messageMap", messages);

        String login = request.getParameter("loginParam");

        if (login == null) {
            messages.put("login", "Please enter login");
        }

        String password = request.getParameter("passwd");

        if (password == null) {
            messages.put("passwd", "Please enter password");
        }

        if (messages.isEmpty()) {
            messages.put("userName", login);
            messages.put("success", String.format("Hello %s ! your login is %s and password is %s", login, login, password));
        }

        request.getRequestDispatcher("/hello.jsp").forward(request, response);

    }
}
