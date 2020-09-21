/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ojdbcpractice.tools;

import ojdbcpractice.controllers.RegionController;
import ojdbcpractice.models.Region;

/**
 *
 * @author Laila
 */
public class ManualTest {

    public static void main(String[] args) {

        System.out.println(new Koneksi().getConnection());
//        System.out.println(new RegionController().insertRegionController("7","Antartika"));
//        System.out.println(new RegionController().updateRegionController("7", "Artik"));
//        System.out.println(new RegionController().deleteRegionController("7"));
//        System.out.println(new RegionController().getByIdRegionController(6));
Region region= new RegionController().getByIdRegionController(1);
        System.out.println(region.getId()+" "+region.getName());
        
//List<Region> regions = new RegionController().getDataRegion();

//List<Region> regions = new RegionController().findRegion("E");
//        for (Region region : regions) {
//            System.out.println(region.getId() + " " + region.getName());
        }
//    }
}
