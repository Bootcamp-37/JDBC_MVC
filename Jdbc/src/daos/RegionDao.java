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
public class RegionDao {
    private Connection connection;

    public RegionDao() {
    }
    
    /**
     * Konstruktor ini digunakan jika ingin membuat object dengan parameter connection
     * @param connection = berisi connection berasal dari koneksi
     */
    public RegionDao(Connection connection) {
        this.connection = connection;
    }

    /**
     * Method ini berfungsi untuk melakukan pencarian region baik dengan keyword atau tidak
     * @param name = berisi keyword yang akan digunakan dalam pencarian
     * @return Method ini akan mengembalikan list yang berisi banyak region sesuai dengan isi dari parameter
     */
    public List<Region> getSearchRegion(String name) {
        List<Region> regions = new ArrayList<>();
        String query = "SELECT * FROM regions";
        PreparedStatement ps = null;
        try {
            if (!name.equals("")) {
                query = "SELECT * FROM regions WHERE lower(region_name) LIKE ? OR lower(region_id) LIKE ?";
                ps = this.connection.prepareStatement(query);
                ps.setString(1, "%"+name+"%" );
                ps.setString(2, "%"+name+"%" );
            }else{
                ps = this.connection.prepareStatement(query);
            }
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

    /**
     * Method ini digunakan untuk menambahkan dan merubah isi region
     * @param region = berisi data region yang akan ditambahkan atau diubah
     * @param isInsert = berisi true jika perintah yang digunakan yaitu menambahkan dan false untuk merubah
     * @return = Jika method ini berhasil dijalankan maka akan mengembalikan nilai true dan gagal mengembalikan nilai false
     */
    public boolean insertUpdateRegion(Region region, boolean isInsert ) {
        boolean result = false;
        String query = "UPDATE regions SET region_name = ? WHERE region_id = ?";
        try {
            if (isInsert) {
                query = "INSERT INTO regions (region_name,region_id) VALUES (?,?)";
            }
            PreparedStatement ps = this.connection.prepareStatement(query);           
            ps.setString(1, region.getName());
            ps.setInt(2, region.getId());
            ps.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    /**
     * Method ini berfungsi untuk mendapatkan sebuah data region berdasarkan id
     * @param id = berisi id region yang ingin dicari
     * @return = jika method ini berhasil maka akan mengembalikan object region
     */
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
    
    /**
     * Method ini berfungsi untuk menghapus data region berdasarkan id
     * @param id = berisi id region yang ingin dihapus
     * @return = Jika method ini berhasil maka akan mengembalikan true dan jika gagal, mengembalikan false
     */
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
