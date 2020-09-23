/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.LocationDao;
import java.util.List;
import models.Location;
import tools.Koneksi;
/**
 *
 * @author ZFH
 */

public class LocationController {
    LocationDao locationDao;
    
    public LocationController() {
        this.locationDao = new LocationDao(new Koneksi().getConnection());
    }
    
   public List<Location> getDataLocation(){
       return locationDao.getLocations();
    }
    /**
     * Method saveLocation digunakan untuk menemukan sebuah data yang dicari dengan menggunakan parameter dari table
     * @param location_id = parameter dari table dan digunakan untuk menentukan id dari table
     * @param street_address = parameter dari tablle yang digunakan untuk membantu method menemukan data tersebut dari tabel
     * @return = mengembalikan nilai dari objek yang dituju pada location
     */
    public String saveLocation(String location_id, String street_address){
        int rLocalId = Integer.parseInt(location_id);
//        Region region = new Region();
//        region.setId(rId);
//        region.setName(name);
        Location location = new Location(rLocalId, street_address);
//        boolean result = regionDao.insertRegion(region);
//        if (result) {
//            return "Berhasil";
//        }
//        return "Gagal";
//        return result? "Sukses":"Gagal";
        return locationDao.insertLocation(location)? "Sukses":"Gagal";
    }
    
    public String editLocation(String location_id, String street_address){
        int rLocalId = Integer.parseInt(location_id);
        Location location = new Location(rLocalId, street_address);
        return locationDao.updateLocation(location)? "Sukses":"Gagal";
    }
    
    public List<Location> findLocation(String location_id){
        int rLocalId = Integer.parseInt(location_id);
        System.out.println(rLocalId);
        return locationDao.searchLocation(rLocalId);
    }
    public String deleteLocationControl (String location_id, String street_address) {
        int rLocalId = Integer.parseInt(location_id);
        Location location = new Location(rLocalId, street_address);
        return locationDao.deleteLocation(location)? "Sukses":"Gagal";
    }

}
