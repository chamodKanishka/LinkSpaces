package controller.url_controller.auth;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;
import java.io.IOException;

import controller.db_controller.IndustrialController;
import controller.db_controller.StudentController;
import controller.db_controller.UniversityController;

@WebServlet(urlPatterns = "/register")
public class RegisterController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String referer = request.getHeader("Referer");
        PrintWriter write = response.getWriter();
//        String conn = "jdbc:mysql://localhost:3306/linkspaces";
//        write.println(referer);

        if(referer.contains("reg_students.jsp")){

            StudentController st = new StudentController();
            st.insert(request);

        } else if(referer.contains("reg_industrial.jsp")){

            IndustrialController ind = new IndustrialController();
            ind.insert(request);

        } else if(referer.contains("reg_uni.jsp")){

            UniversityController uni = new UniversityController();
            uni.insert(request);

        }
        response.sendRedirect("/login.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
