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
import models.Location;
/**
 *
 * @author ZFH
 */
public class LocationDao {
  private Connection connection;
 
  public LocationDao(){
  }
  public LocationDao (Connection connection){ this.connection=connection;
  }
  public List<Location> getLocations(){
        List<Location> locations = new ArrayList<>();
        String query = "SELECT * FROM HR.locations";
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {                
                Location r = new Location();
                r.setLocalId(resultSet.getInt("location_id"));
                r.setAddress(resultSet.getString(2));
                r.setPost(resultSet.getString(3));
                r.setCity(resultSet.getString(4));
                r.setProvince(resultSet.getString(5));
                r.setCountry(resultSet.getString(6));
                locations.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return locations;
    }
  /**
   * 
   * @param location = menentukan parameter dari 
   * @return 
   */
  public boolean insertLocation(Location location){
        boolean result = false;
//        String query = "INSERT INTO regions (region_id,region_name) VALUES ("+region.getId()+",'"+region.getName()+"')";
        String query = "INSERT INTO locations (location_id,street_address,postal_code,city,state_province,country_id) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            ps.setInt(1, location.getLocalId());
            ps.setString(2, location.getAddress());
            ps.setString(3, location.getPost());
            ps.setString(4, location.getCity());
            ps.setString(5, location.getProvince());
            ps.setString(6, location.getCountry());
            ps.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
  /**
   * 
   * @param location
   * @return 
   */
  public boolean updateLocation(Location location){
        boolean result = false;
        String query = "UPDATE locations SET street_address = ? WHERE location_id = ?";
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            ps.setInt(2, location.getLocalId());
            ps.setString(1, location.getAddress());
            ps.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
 /**
 * method searchLocation berfungsi untuk menemukan sebuah data pada tabel locations yang disesuaikan dengan parameter query yang diberikan
 * @param location_id = digunakan untuk menentukan data tertentu dengan menentukan location_id yang sesuai dengan table
 * @return = untuk mengembalikan sebuah nilai yang diberikan
 */
    public List<Location> searchLocation(int location_id){
        List<Location> locations = new ArrayList<>();
        String query = "SELECT * FROM HR.locations WHERE location_id = ?";
        try {System.out.println(location_id);
            PreparedStatement ps = this.connection.prepareStatement(query);
            ps.setInt(1, location_id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {                
                Location r = new Location();
                r.setLocalId(resultSet.getInt(1));
                r.setAddress(resultSet.getString(2));
                r.setPost(resultSet.getString(3));
                r.setCity(resultSet.getString(4));
                r.setProvince(resultSet.getString(5));
                r.setCountry(resultSet.getString(6));
                locations.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return locations;
    }
     public boolean deleteLocation(Location location){
        boolean result = false;
        String query = "DELETE FROM locations WHERE location_id = ?";
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            ps.setInt(2, location.getLocalId());
            ps.setString(1, location.getAddress());
            ps.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
