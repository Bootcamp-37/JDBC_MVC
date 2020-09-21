/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Job;

/**
 *
 * @author User
 */
public class JobDao {
    private Connection connection;

    public JobDao() {
    }

    public JobDao(Connection connection) {
        this.connection = connection;
    }
    
    public List<Job> getJobs(){
        List<Job> jobs = new ArrayList<>();
        String query = "SELECT * FROM jobs";
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {                
                Job j = new Job();
                j.setId(resultSet.getString(1));
                j.setTitle(resultSet.getString(2));
                j.setMin_salary(resultSet.getInt(3));
                j.setMax_salary(resultSet.getInt(4));
                jobs.add(j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jobs;
    }
    
    public boolean insertJob(Job job){
        boolean result = false;
        String query = "INSERT INTO jobs (job_id,job_title,min_salary,max_salary) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            ps.setString(1, job.getId());
            ps.setString(2, job.getTitle());
            ps.setInt(3, job.getMin_salary());
            ps.setInt(4, job.getMax_salary());
            ps.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public boolean updateJob(Job job){
        boolean result = false;
        String query = "UPDATE jobs SET job_title = ? , min_salary = ? , max_salary = ? WHERE job_id = ?";
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            ps.setString(4, job.getId());
            ps.setString(1, job.getTitle());
            ps.setInt(2, job.getMin_salary());
            ps.setInt(3, job.getMax_salary());
            ps.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public List<Job> searchJob(String title){
        List<Job> jobs = new ArrayList<>();
        String query = "SELECT * FROM jobs WHERE job_title LIKE ?";
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            ps.setString(1, "%"+title+"%");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {                
                Job j = new Job();
                j.setId(resultSet.getString(1));
                j.setTitle(resultSet.getString(2));
                j.setMin_salary(resultSet.getInt(3));
                j.setMax_salary(resultSet.getInt(4));
                jobs.add(j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jobs;
    }
    
    public Job getJob(String id){
        Job job = new Job();
        String query = "SELECT * FROM jobs WHERE job_id = ?";
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            ps.setString(1,id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {                
                job.setId(resultSet.getString(1));
                job.setTitle(resultSet.getString(2));
                job.setMin_salary(resultSet.getInt(3));
                job.setMax_salary(resultSet.getInt(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return job;
    }
    
    public boolean deleteJob(String id){
        boolean result = false;
        String query = "DELETE FROM jobs WHERE job_id = ?";
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
