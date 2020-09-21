/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controllers.RegionController;
import java.util.List;
import models.Region;

/**
 *
 * @author User
 */
public class ManualTest {
    public static void main(String[] args) {
        System.out.println(new Koneksi().getConnection());
//        System.out.println(new RegionController().saveRegion("9", "Antartika"));
//        System.out.println(new RegionController().editRegion("9", "Papua"));
        List<Region> data = new RegionController().getDataRegion();
//        List<Region> data = new RegionController().findRegion("ca");
//        Region data = new RegionController().getDataRegion("1");
        for (Region region : data) {
            System.out.println(region.getId()+" "+region.getName());
        }
//        System.out.println(data.getId()+" "+ data.getName());
//        System.out.println(new RegionController().removeRegion("7"));
        
    }
}
