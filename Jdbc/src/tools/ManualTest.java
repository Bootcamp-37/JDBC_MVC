/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controllers.JobController;
import controllers.RegionController;
import java.util.List;
import models.Job;
import models.Region;

/**
 *
 * @author User
 */
public class ManualTest {
    public static void main(String[] args) {
//        System.out.println(new JobController());
//        System.out.println(new Koneksi().getConnection());
//        System.out.println(new RegionController().saveRegion("7", "Antartika"));
//        System.out.println(new RegionController().editRegion("7", "Papua"));
//        System.out.println(new RegionController().removeRegion("7"));
//        List<Region> data = new RegionController().getDataRegions();
//        List<Region> data = new RegionController().findRegion("ca");
//        Region data = new RegionController().getDataRegion("8");
//        for (Region region : data) {
//            System.out.println(region.getId()+" "+region.getName());
//        }
//        System.out.println(data.getId()+" "+ data.getName());


//        System.out.println(new JobController().addJobSP("IT_C#", "Java Programmer", "5000", "7500"));
        System.out.println(new JobController().saveJobSP("IT_Net", ".N Programmer", "6500", "8500"));
//        System.out.println(new JobController().editJob("IT_Java", "Senior Java Programmer", "6000", "9500"));
//        List<Job> data = new JobController().getDataJobs();
//        List<Job> data = new JobController().findJob("Programmer");
//        Job data = new JobController().getDataJob("IT_Java");
//        for (Job job : data) {
//            System.out.println(job.getId()+" "+job.getTitle()+" "+job.getMin_salary()+" "+job.getMax_salary());
//        }
//        System.out.println(data.getId()+" "+data.getTitle()+" "+data.getMin_salary()+" "+data.getMax_salary());
//        System.out.println(new JobController().removeJob("IT_Java"));


    }
}
