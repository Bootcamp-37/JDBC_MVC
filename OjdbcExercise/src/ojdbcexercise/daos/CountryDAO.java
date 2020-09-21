/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ojdbcexercise.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import ojdbcexercise.models.Country;

/**
 *
 * @author Laila
 */
public class CountryDAO {
    private Connection connection;

    public CountryDAO(Connection connection) {
        this.connection = connection;
    }

    public CountryDAO() {
    }
    
    
    public List<Country>getCountries(){
        List<Country> countries= new ArrayList<>();
        String query="select * from COUNTRIES";
        try {
            PreparedStatement preparedStatement=this.connection.prepareStatement(query);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()) {
                Country country= new Country();
                country.setId(resultSet.getString(1));//ambil dari nama kolom
                country.setName(resultSet.getString(2));//ambil dari nomor kolom
                country.setRegion(resultSet.getInt(3));//ambil dari nomor kolom
                countries.add(country);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countries;
    }
    
    public boolean insertCountry(Country country){
         boolean result = false;

        String query = "INSERT INTO Countries (country_id, country_name, region_id) VALUES (?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, country.getId());
            preparedStatement.setString(2, country.getName());
            preparedStatement.setInt(3, country.getRegion());
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return result;
        
    }
    
     public boolean updateCountry(Country country){
         boolean result = false;
         

        String query = "UPDATE Countries SET country_name=?, region_id=? WHERE (country_id = ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, country.getName());
            preparedStatement.setInt(2, country.getRegion());
            preparedStatement.setString(3, country.getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return result;
        
    }
     public List<Country> searchCountry(String key){
         List<Country> countries= new ArrayList<>();
         String query="select * from COUNTRIES where lower(country_id) LIKE ? OR lower(country_name) LIKE ? OR region_id LIKE ?";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(query);
           preparedStatement.setString(1, "%"+key.toLowerCase()+"%");
           preparedStatement.setString(2,"%"+ key.toLowerCase()+"%");
           preparedStatement.setString(3, "%"+key.toLowerCase()+"%");
           ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()) {
                Country country= new Country();
                country.setId(resultSet.getString(1));
                country.setName(resultSet.getString(2));
                country.setRegion(resultSet.getInt(3));
                countries.add(country);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countries;
     }
     
     public boolean deleteCountry(Country country){
         boolean result = false;
         

        String query = "DELETE FROM Countries WHERE (country_id = ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, country.getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return result;
        
    }
       public Country findByIdCountry(String id){
         Country country= null;
         String query="select * from COUNTRIES where country_id = ?";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(query);
           preparedStatement.setString(1, id);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()) {
                country = new Country(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return country;
     }
     
}
