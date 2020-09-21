/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ojdbcpractice.controllers;

import java.util.List;
import ojdbcpractice.daos.RegionDao;
import ojdbcpractice.models.Region;
import ojdbcpractice.tools.Koneksi;

/**
 *
 * @author Laila
 */
public class RegionController {

    RegionDao regionDao;

    public RegionController() {
        this.regionDao = new RegionDao(new Koneksi().getConnection());
    }

    public List<Region> getDataRegion() {
        return regionDao.getRegions();
    }

    public String insertRegionController(String id, String name) {
        int regionId = Integer.parseInt(id);
        //cara singkat no 1, 2, 3
        Region region1 = new Region(regionId, name);
//1       Region region1 = new Region();
// 2      region1.setId(regionId);
//  3     region1.setName(name);

//4       boolean result= regionDao.insertRegion(region1);
//5       if (result) {
//6       return "berhasil";    
//7       }
//8       return "gagal";
//9 return result?"Berhasil":"Gagal";
//cara singkat no 4-9 
        return regionDao.insertRegion(region1) ? "berhasil" : "gagal";
    }

    public String updateRegionController(String id, String name) {
        int regionId = Integer.parseInt(id);

        Region region1 = new Region(regionId, name);
        return regionDao.updateRegion(region1) ? "berhasil" : "gagal";
    }

    public List<Region> findRegion(String key) {
        return this.regionDao.searchRegion(key);
    }
     public String deleteRegionController(String id) {
        int regionId = Integer.parseInt(id);

          Region region1 = new Region();
       region1.setId(regionId);
        return regionDao.deleteRegion(region1) ? "berhasil" : "gagal";
    }
     public Region getByIdRegionController(int id){
         return this.regionDao.findByIdRegion(id);
     }

}
