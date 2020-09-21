/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ojdbcpractice.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import ojdbcpractice.models.Region;

/**
 *
 * @author Laila
 */
public class RegionDao {
    private Connection connection;

    public RegionDao(Connection connection) {
        this.connection = connection;
    }

    public RegionDao() {
    }
    
    
    public List<Region>getRegions(){
        List<Region> regions= new ArrayList<>();
        String query="select * from REGIONS";
        try {
            PreparedStatement preparedStatement=this.connection.prepareStatement(query);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()) {
                Region region= new Region();
                region.setId(resultSet.getInt("region_id"));//ambil dari nama kolom
                region.setName(resultSet.getString(2));//ambil dari nomor kolom
                regions.add(region);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return regions;
    }
    
    public boolean insertRegion(Region region){
         boolean result = false;

        String query = "INSERT INTO Regions (region_id, region_name) VALUES (?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, region.getId());
            preparedStatement.setString(2, region.getName());
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return result;
        
    }
    
     public boolean updateRegion(Region region){
         boolean result = false;
         

        String query = "UPDATE Regions SET region_name=? WHERE (region_id = ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(2, region.getId());
            preparedStatement.setString(1, region.getName());
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return result;
        
    }
     public List<Region> searchRegion(String key){
         List<Region> regions= new ArrayList<>();
         String query="select * from REGIONS where region_id LIKE ? OR lower(region_name) LIKE ?";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(query);
           preparedStatement.setString(1, "%"+key.toLowerCase()+"%");
           preparedStatement.setString(2,"%"+ key.toLowerCase()+"%");
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()) {
                Region region= new Region();
                region.setId(resultSet.getInt(1));//ambil dari nama kolom
                region.setName(resultSet.getString(2));//ambil dari nomor kolom
                regions.add(region);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return regions;
     }
     
     public boolean deleteRegion(Region region){
         boolean result = false;
         

        String query = "DELETE FROM Regions WHERE (region_id = ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, region.getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return result;
        
    }
       public Region findByIdRegion(int id){
         Region region= null;
         String query="select * from REGIONS where region_id = ?";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(query);
           preparedStatement.setInt(1, id);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()) {
                region = new Region(resultSet.getInt(1), resultSet.getString(2));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return region;
     }
     
}
