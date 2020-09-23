/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ojdbcexercise.controllers;

import java.util.List;
import ojdbcexercise.daos.CountryDAO;
import ojdbcexercise.models.Country;
import ojdbcexercise.tools.Koneksi;

/**
 *
 * @author Laila
 */
public class CountryController {
      CountryDAO countryDAO;
/**
 * instanciating connection by Koneksi class from CountryDAO class
 */
    public CountryController() {
        this.countryDAO = new CountryDAO(new Koneksi().getConnection());
    }
/**
 * This method is called when you want to show all the data in countries table,
 * @return method getCountries from countryDAO
 */
    public List<Country> getDataCountry() {
        return countryDAO.getCountries();
    }
/**
 * This method is called when you want to save data
 * @param id
 * @param name
 * @param region, you must enter all the parameter, such id, name and region to insert/save data
 * @return method insertUpdateCountry from countryDAO
 * set the parameter to true, to call insert method
 */
    public String insertCountryController(String id, String name, String region) {
        int regionId = Integer.parseInt(region);
        Country country1 = new Country(id, name, regionId);
        return countryDAO.insertUpdateCountry(country1,true) ?  "Data has been saved" : "Failed to save data";
    }
/**
 * This method is called when you want to edit data
 * @param id
 * @param name
 * @param region, you must enter all the parameter, such id, name and region to edit data
 * @return method insertUpdateCountry from countryDAO
 * set the parameter to false, to call update method
 */
    public String updateCountryController(String id, String name, String region) {
        int regionId = Integer.parseInt(region);

        Country country1 = new Country(id, name, regionId);
        return countryDAO.insertUpdateCountry(country1,false) ?  "Data has been edited" : "Failed to edit data";
    }
/**
 * This method is called when you want to search data,
 * @param key is the keyword of data you want to search,
 * @return method searchCountry from countryDAO
 */
    public List<Country> findCountry(String key) {
        return countryDAO.searchCountry(key);
    }
    /**
     * This method is called when you want to delete data
     * @param id, you only must insert id to delete data
     * @return method deleteCountry from countryDAO
     */
     public String deleteCountryController(String id) {
          Country country1 = new Country();
       country1.setId(id);
        return countryDAO.deleteCountry(country1) ? "Data has been deleted" : "Failed to delete data";
    }
     /**
      * This method is called when you want to get the data from keyword id
      * @param id, you must only insert id to get the data
      * @return method findByIdCountry from countryDAO
      */
     public Country getByIdCountryController(String id){
         return this.countryDAO.findByIdCountry(id);
     }
}
