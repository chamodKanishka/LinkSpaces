package controller.db_controller;

import db.DBConnection;
import model.CommentDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CommentsJobsController {
    public ArrayList<CommentDTO> getComments(String event_id) {
        ArrayList<CommentDTO> commentDTOS = new ArrayList<>();
        try {
            Connection connection = DBConnection.getDBConnection().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select id,job_id,poster_id,comment,post_time,post_date,username from comments_jobs c,users u where u.uid=c.poster_id && job_id=?");
            preparedStatement.setObject(1, event_id);
            ResultSet rst = preparedStatement.executeQuery();
            while (rst.next()) {
                CommentDTO commentDTO = new CommentDTO();
                commentDTO.setId(rst.getInt(1));
                commentDTO.setJob_id(rst.getInt(2));
                commentDTO.setPoster_id(rst.getInt(3));
                commentDTO.setComment(rst.getString(4));
                commentDTO.setPost_time(rst.getString(5));
                commentDTO.setPost_date(rst.getString(6));
                commentDTO.setPoster_name(rst.getString(7));
                commentDTOS.add(commentDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return commentDTOS;
    }

    public boolean addComment(CommentDTO commentDTO) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        try {
            String SQL = "insert into comments_jobs (job_id,poster_id,comment,post_time,post_date) values(?,?,?,?,?)";
            Connection connection = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = connection.prepareStatement(SQL);
            stm.setObject(1, commentDTO.getJob_id());
            stm.setObject(2, commentDTO.getPoster_id());
            stm.setObject(3, commentDTO.getComment());
            stm.setObject(4, timeFormat.format(date));
            stm.setObject(5, dateFormat.format(date));
            return stm.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateComment(CommentDTO commentDTO) {
        try {
            String SQL = "update comments_jobs set comment=? where id=?";
            Connection connection = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = connection.prepareStatement(SQL);
            stm.setObject(1, commentDTO.getComment());
            stm.setObject(2, commentDTO.getId());
            return stm.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteComment(String id) {
        try {
            String SQL = "delete from comments_jobs where id=?";
            Connection connection = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = connection.prepareStatement(SQL);
            stm.setObject(1, id);
            return stm.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
