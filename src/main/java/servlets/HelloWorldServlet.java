package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by trierra on 8/3/15.
 */
public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        out.println("<H1> Welcome, User! </H1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("uname");
        String password = req.getParameter("pass");

        PrintWriter pw = resp.getWriter();

        pw.println("<H1> Welcome " + user + " </H1> <br/>");
        pw.println("<H1> Your password is " + password + "</H1> <br/>");
    }
}
