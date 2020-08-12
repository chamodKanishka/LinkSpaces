package controller.db_controller;

import db.DBConnection;
import model.JobDTO;
import model.ResumeDTO;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class JobController {

    public ArrayList<JobDTO> getJobTitles() {
        ArrayList<JobDTO> jobDTOS = new ArrayList<>();
        try {
            Connection connection = DBConnection.getDBConnection().getConnection();
            Statement createStatement = connection.createStatement();
            ResultSet rst = createStatement.executeQuery("select job_title from job_titles");
            while (rst.next()) {
                JobDTO jobDTO = new JobDTO();
                jobDTO.setJobTitle(rst.getString(1));
                jobDTOS.add(jobDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return jobDTOS;
    }

    public ArrayList<JobDTO> getJobs(String jobTitle) {
        ArrayList<JobDTO> jobDTOS = new ArrayList<>();
        try {
            Connection connection = DBConnection.getDBConnection().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select description,offered_by,job_type from job_offers where job_title=?");
            preparedStatement.setObject(1, jobTitle);
            ResultSet rst = preparedStatement.executeQuery();
            while (rst.next()) {
                JobDTO jobDTO = new JobDTO();
                jobDTO.setDescription(rst.getString(1));
                jobDTO.setOfferedBy(rst.getString(2));
                jobDTO.setJobType(rst.getString(3));
                jobDTOS.add(jobDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return jobDTOS;
    }

    public ArrayList<JobDTO> getCompanies() {
        ArrayList<JobDTO> jobDTOS = new ArrayList<>();
        try {
            Connection connection = DBConnection.getDBConnection().getConnection();
            Statement createStatement = connection.createStatement();
            ResultSet rst = createStatement.executeQuery("select company_name from company");
            while (rst.next()) {
                JobDTO jobDTO = new JobDTO();
                jobDTO.setOfferedBy(rst.getString(1));
                jobDTOS.add(jobDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return jobDTOS;
    }

    public ArrayList<JobDTO> getJobTypes() {
        ArrayList<JobDTO> jobDTOS = new ArrayList<>();
        try {
            Connection connection = DBConnection.getDBConnection().getConnection();
            Statement createStatement = connection.createStatement();
            ResultSet rst = createStatement.executeQuery("select job_type from job_type");
            while (rst.next()) {
                JobDTO jobDTO = new JobDTO();
                jobDTO.setJobType(rst.getString(1));
                jobDTOS.add(jobDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return jobDTOS;
    }

    public boolean addJob(JobDTO jobDTO) {
        java.util.Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            String SQL = "insert into job_offers (poster_id,job_title,description,offered_by,job_type,post_date,audience) values(?,?,?,?,?,?,?)";
            Connection connection = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = connection.prepareStatement(SQL);
            stm.setObject(1, jobDTO.getPosterId());
            stm.setObject(2, jobDTO.getJobTitle());
            stm.setObject(3, jobDTO.getDescription());
            stm.setObject(4, jobDTO.getOfferedBy());
            stm.setObject(5, jobDTO.getJobType());
            stm.setObject(6, dateFormat.format(date));
            stm.setObject(7, "abc");
            return stm.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addResume(ResumeDTO resumeDTO) {
        try {
            String SQL = "insert into resumes (poster_id,file_name) values(?,?)";
            Connection connection = DBConnection.getDBConnection().getConnection();
            PreparedStatement stm = connection.prepareStatement(SQL);
            stm.setObject(1, resumeDTO.getPosterId());
            stm.setObject(2, resumeDTO.getFileName());
            return stm.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<JobDTO> getAllJobs() {
        ArrayList<JobDTO> jobDTOS = new ArrayList<>();
        try {
            Connection connection = DBConnection.getDBConnection().getConnection();
            Statement createStatement = connection.createStatement();
            ResultSet rst = createStatement.executeQuery("select id,poster_id,job_title,description,offered_by,job_type,post_date from job_offers ORDER BY post_date DESC");
            while (rst.next()) {
                JobDTO jobDTO = new JobDTO();
                jobDTO.setId(Integer.parseInt(rst.getString(1)));
                jobDTO.setPosterId(Integer.parseInt(rst.getString(2)));
                jobDTO.setJobTitle(rst.getString(3));
                jobDTO.setDescription(rst.getString(4));
                jobDTO.setOfferedBy(rst.getString(5));
                jobDTO.setJobType(rst.getString(6));
                jobDTO.setPost_date(rst.getString(7));
                jobDTOS.add(jobDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return jobDTOS;
    }
}
