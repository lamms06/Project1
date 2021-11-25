package nl.belastingdienst.servlet;

import domain.Person;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class RegistrationHandler extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Person p = new Person(request.getParameter("firstname"), request.getParameter("lastname"));
        request.setAttribute("person", p);
        request.getRequestDispatcher("registered").forward(request,response);
    }
}
