/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.JobDao;
import java.util.List;
import models.Job;
import tools.Koneksi;

/**
 *
 * @author User
 */
public class JobController {
    private JobDao jobDao;

    public JobController() {
        this.jobDao = new JobDao(new Koneksi().getConnection());
    }
    
    public List<Job> getDataJobs(){
        return jobDao.getJobs();
    }
    
    public String addJob(String id, String title, String min, String max){
        int jMin = Integer.parseInt(min);
        int jMax = Integer.parseInt(max);
        Job job = new Job(id, title, jMin, jMax);
        return jobDao.insertJob(job)? "Sukses":"Gagal";
    }
    
    public String editJob(String id, String title, String min, String max){
        int jMin = Integer.parseInt(min);
        int jMax = Integer.parseInt(max);
        Job job = new Job(id, title, jMin, jMax);
        return jobDao.updateJob(job)? "Sukses":"Gagal";
    }
    
    public List<Job> findJob(String title){
        return jobDao.searchJob(title);
    }
    
    public Job getDataJob(String id){
        return jobDao.getJob(id);
    }
    
    public String removeJob(String id){
        return jobDao.deleteJob(id)? "Sukses":"Gagal";
    }
    
    
}
