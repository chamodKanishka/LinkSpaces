package controller.db_controller;

import db.DBConnection;
import model.UserDTO;
import security.Encrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserController {
    public UserDTO chkLogin(String username, String password) {
        UserDTO userDTO = null;
        try {
            Connection connection = DBConnection.getDBConnection().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select uid,username,user_type from users where (username=? || email=?) && password=?");
            preparedStatement.setObject(1, username);
            preparedStatement.setObject(2, username);
            preparedStatement.setObject(3, password);
            ResultSet rst = preparedStatement.executeQuery();
            if (rst.next()) {
                userDTO = new UserDTO();
                userDTO.setUid(rst.getString(1));
                userDTO.setUsername(rst.getString(2));
                userDTO.setAccountType(rst.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return userDTO;
    }

    public int insert(String uname, String pwd, String type, String email) {

        Encrypt enc = new Encrypt();
        int id = -1;
//        String pwdEnc = enc.getHash(pwd);
        String query = "insert into users(username,password,user_type,email) values('" + uname + "','" + pwd + "','" + type + "','" + email + "')";
        String query1 = "select uid from users where username = '" + uname + "' and password = '" + pwd + "'";
//        String conn = "jdbc:mysql://localhost:3306/linkspaces";
//        Dbcon db = new Dbcon();

        try {
            Connection con = DBConnection.getDBConnection().getConnection();
            PreparedStatement stmt = con.prepareStatement(query);//insert the details into users table
            stmt.execute();//and generate the unique uid in the process

            PreparedStatement stmt1 = con.prepareStatement(query1);
            ResultSet rs = stmt1.executeQuery();//get the generated uid
            if (rs.next()) {
                id = rs.getInt(1);
            } else
                System.out.println("error");

        } catch (Exception e) {
            System.out.println(e);
        }

        return id;
    }
}
