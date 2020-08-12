package controller.db_controller;

import db.DBConnection;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UniversityController {

//    String conn = "jdbc:mysql://localhost:3306/linkspaces";
//    Dbcon db = new Dbcon();


    public void insert(HttpServletRequest request){

        String uname = request.getParameter("uname");
        String pwd = request.getParameter("pwd");
        String type = request.getParameter("type");
        String name = request.getParameter("uni");
        String regno = request.getParameter("regno");
        String email = request.getParameter("email");
        String weburl = request.getParameter("weburl");
        UserController user = new UserController();
        int id = -1;

        try{

            id = user.insert(uname, pwd, type, email);
            Connection con = DBConnection.getDBConnection().getConnection();

            String query = "insert into university values("+id+",'"+name+"','"+regno+"','"+weburl+"')";
            PreparedStatement st = con.prepareStatement(query);
            st.execute();

//            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List getUniList(){

        List<String> uniList = new ArrayList<String>();

        try{

            Connection con = DBConnection.getDBConnection().getConnection();
            String query = "select name from university";
            PreparedStatement st = con.prepareStatement(query);
            ResultSet rs = st.executeQuery();

            while(rs.next()){
                uniList.add(rs.getString(1));
            }
//            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return uniList;
    }

//    public static void main(String[] args){
//        List<String> uniList = new ArrayList<>();
//        UniversityController uni = new UniversityController();
//        uniList = uni.getUniList();
//        for(String uniName: uniList){
//            System.out.println(uniName);
//        }
//    }
}
