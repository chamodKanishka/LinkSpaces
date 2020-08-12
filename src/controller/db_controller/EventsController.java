package controller.db_controller;

import db.DBConnection;
import model.EventDTO;

import java.sql.*;
import java.util.ArrayList;

public class EventsController {

    public boolean addEvent(EventDTO eventDTO) {
        try {
            String SQL = "insert into events (poster_id,title,start_date,end_date,start_time,venue,description,organized_by,category,website,image,audience) values(?,?,?,?,?,?,?,?,?,?,?,?)";
            Connection connection = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = connection.prepareStatement(SQL);
            stm.setObject(1, eventDTO.getPoster_id());
            stm.setObject(2, eventDTO.getTitle());
            stm.setObject(3, eventDTO.getStart_date());
            stm.setObject(4, eventDTO.getEnd_date());
            stm.setObject(5, eventDTO.getStart_time());
            stm.setObject(6, eventDTO.getVenue());
            stm.setObject(7, eventDTO.getDescription());
            stm.setObject(8, eventDTO.getOrganized_by());
            stm.setObject(9, eventDTO.getCategory());
            stm.setObject(10, eventDTO.getWebsite());
            stm.setObject(11, eventDTO.getImage());
            stm.setObject(12, "popo");
            return stm.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<EventDTO> getEvents(String startYear, String startMonth, String endYear, String endMonth) {
        ArrayList<EventDTO> eventDTOS = new ArrayList<>();
        try {
            Connection connection = DBConnection.getDBConnection().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from events where year(start_date)=? && month(start_date)=? && year(end_date)=? && month(end_date)<=?");
            preparedStatement.setObject(1, startYear);
            preparedStatement.setObject(2, startMonth);
            preparedStatement.setObject(3, endYear);
            preparedStatement.setObject(4, endMonth);
            ResultSet rst = preparedStatement.executeQuery();
            eventDTOS = setEvents(rst, eventDTOS);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return eventDTOS;
    }

    public ArrayList<EventDTO> getAllEvents() {
        ArrayList<EventDTO> eventDTOS = new ArrayList<>();
        try {
            Connection connection = DBConnection.getDBConnection().getConnection();
            Statement createStatement = connection.createStatement();
            ResultSet rst = createStatement.executeQuery("select * from events ORDER BY start_date DESC");
            eventDTOS = setEvents(rst, eventDTOS);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return eventDTOS;
    }

    public ArrayList<EventDTO> getAllEventsViaUid(String uid) {
        ArrayList<EventDTO> eventDTOS = new ArrayList<>();
        try {
            Connection connection = DBConnection.getDBConnection().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from events where poster_id=?");
            preparedStatement.setObject(1, uid);
            ResultSet rst = preparedStatement.executeQuery();
            eventDTOS = setEvents(rst, eventDTOS);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return eventDTOS;
    }

    private ArrayList<EventDTO> setEvents(ResultSet rst, ArrayList<EventDTO> eventDTOS) throws SQLException {
        while (rst.next()) {
            EventDTO eventDTO = new EventDTO();
            eventDTO.setId(rst.getInt(1));
            eventDTO.setPoster_id(rst.getInt(2));
            eventDTO.setTitle(rst.getString(3));
            eventDTO.setStart_date(rst.getString(4));
            eventDTO.setEnd_date(rst.getString(5));
            eventDTO.setStart_time(rst.getString(6));
            eventDTO.setVenue(rst.getString(7));
            eventDTO.setDescription(rst.getString(8));
            eventDTO.setOrganized_by(rst.getString(9));
            eventDTO.setCategory(rst.getString(10));
            eventDTO.setWebsite(rst.getString(11));
            eventDTO.setImage(rst.getString(12));
            eventDTOS.add(eventDTO);
        }
        return eventDTOS;
    }
}