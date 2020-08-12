package controller.db_controller;


import db.DBConnection;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;

public class StudentController {

//    String conn = "jdbc:mysql://localhost:3306/linkspaces";
//    Dbcon db = new Dbcon();

    public void insert(HttpServletRequest request) {

        String uname = request.getParameter("uname");
        String pwd = request.getParameter("pwd");
        String type = request.getParameter("type");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String dob = request.getParameter("dob");
        String email = request.getParameter("email");
        String uni = request.getParameter("university");
        String index = request.getParameter("index");
        UserController user = new UserController();

        int id = -1;

        try {
            id = user.insert(uname, pwd, type, email);
            Connection con = DBConnection.getDBConnection().getConnection();

            String query = "insert into students values(" + id + ",'" + fname + "','" + lname + "','" + dob + "','" + uni + "','" + index + "')";
            PreparedStatement st = con.prepareStatement(query);
            st.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
