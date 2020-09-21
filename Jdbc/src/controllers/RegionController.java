/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.RegionDao;
import java.util.List;
import models.Region;
import tools.Koneksi;

/**
 *
 * @author User
 */
public class RegionController {
    
    private RegionDao regionDao;
    
    public RegionController() {
        this.regionDao = new RegionDao(new Koneksi().getConnection());
    }
    
    public List<Region> getDataRegion(){
        return regionDao.getRegions();
    }
    
    public String saveRegion(String id, String name){
        int rId = Integer.parseInt(id);
//        Region region = new Region();
//        region.setId(rId);
//        region.setName(name);
        Region region = new Region(rId, name);
//        boolean result = regionDao.insertRegion(region);
//        if (result) {
//            return "Berhasil";
//        }
//        return "Gagal";
//        return result? "Sukses":"Gagal";
        return regionDao.insertRegion(region)? "Sukses":"Gagal";
    }
    
    public String editRegion(String id, String name){
        int rId = Integer.parseInt(id);
        Region region = new Region(rId, name);
        return regionDao.updateRegion(region)? "Sukses":"Gagal";
    }
    
    public List<Region> findRegion(String id){
        int rId = Integer.parseInt(id);
        return regionDao.searchRegion(rId);
    }
}
