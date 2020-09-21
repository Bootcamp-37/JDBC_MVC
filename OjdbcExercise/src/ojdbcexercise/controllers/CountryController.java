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

    public CountryController() {
        this.countryDAO = new CountryDAO(new Koneksi().getConnection());
    }

    public List<Country> getDataCountry() {
        return countryDAO.getCountries();
    }

    public String insertCountryController(String id, String name, String region) {
        int regionId = Integer.parseInt(region);
        Country country1 = new Country(id, name, regionId);
        return countryDAO.insertCountry(country1) ? "berhasil" : "gagal";
    }

    public String updateCountryController(String id, String name, String region) {
        int regionId = Integer.parseInt(region);

        Country country1 = new Country(id, name, regionId);
        return countryDAO.updateCountry(country1) ? "berhasil" : "gagal";
    }

    public List<Country> findCountry(String key) {
        return this.countryDAO.searchCountry(key);
    }
     public String deleteCountryController(String id) {
          Country country1 = new Country();
       country1.setId(id);
        return countryDAO.deleteCountry(country1) ? "berhasil" : "gagal";
    }
     public Country getByIdCountryController(String id){
         return this.countryDAO.findByIdCountry(id);
     }
}
