/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ojdbcexercise.tools;

import java.util.List;
import ojdbcexercise.controllers.CountryController;
import ojdbcexercise.models.Country;

/**
 *
 * @author Laila
 */
public class ManualTest {

    public static void main(String[] args) {

        System.out.println(new Koneksi().getConnection());
//        System.out.println(new CountryController().insertCountryController("ID","Antartika","1"));
//        System.out.println(new CountryController().updateCountryController("ID", "INDONESIA","1"));
//        System.out.println(new CountryController().deleteCountryController("ID"));

//Country country= new CountryController().getByIdCountryController("IL");
//        System.out.println(country.getId()+" "+country.getName());
        
//List<Country> countries = new CountryController().getDataCountry();

List<Country> countries = new CountryController().findCountry("y");
        for (Country country : countries) {
            System.out.println(country.getId() + " " + country.getName());
        }
    }
}
