/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controllers.LocationController;
import java.util.List;
import models.Location;
/**
 *
 * @author ZFH
 */
public class ManualTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(new Koneksi().getConnection());
//        System.out.println(new RegionController().saveRegion("9", "Antartika"));
//        System.out.println(new RegionController().editRegion("9", "Papua"));
//        List<Region> data = new RegionController().getDataRegion();
        List<Location> data = new LocationController().findLocation("1000");
        for (Location location : data) {
            System.out.println(location.getLocalId()+" "+location.getAddress());
    }
    }
}
