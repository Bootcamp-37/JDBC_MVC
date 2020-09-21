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
import models.Region;

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
    
    public List<Region> getJobs(){
        List<Region> regions = new ArrayList<>();
        String query = "SELECT * FROM regions";
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {                
                Region r = new Region();
                r.setId(resultSet.getInt("region_id"));
                r.setName(resultSet.getString(2));
                regions.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return regions;
    }
    
    public boolean insertRegion(Region region){
        boolean result = false;
//        String query = "INSERT INTO regions (region_id,region_name) VALUES ("+region.getId()+",'"+region.getName()+"')";
        String query = "INSERT INTO regions (region_id,region_name) VALUES (?,?)";
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            ps.setInt(1, region.getId());
            ps.setString(2, region.getName());
            ps.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public boolean updateRegion(Region region){
        boolean result = false;
        String query = "UPDATE regions SET region_name = ? WHERE region_id = ?";
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            ps.setInt(2, region.getId());
            ps.setString(1, region.getName());
            ps.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public List<Region> searchRegion(String name){
        List<Region> regions = new ArrayList<>();
        String query = "SELECT * FROM regions WHERE region_name LIKE ?";
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            ps.setString(1, "%"+name+"%");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {                
                Region r = new Region();
                r.setId(resultSet.getInt(1));
                r.setName(resultSet.getString(2));
                regions.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return regions;
    }
    
    public Region getRegion(int id){
        Region region = new Region();
        String query = "SELECT * FROM regions WHERE region_id = ?";
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            ps.setInt(1,id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {                
                region.setId(resultSet.getInt(1));
                region.setName(resultSet.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return region;
    }
    
    public boolean deleteRegion(int id){
        boolean result = false;
        String query = "DELETE FROM regions WHERE region_id = ?";
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
