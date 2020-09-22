/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DepartmentDao;
import java.util.List;
import models.Department;
import tools.Koneksi;

/**
 *
 * @author Deo Lahara
 */
public class DepartmentController {
    
    private DepartmentDao departmentDao;

    public DepartmentController(){
        this.departmentDao= new DepartmentDao(new Koneksi().getConnection());
    }
    
    public List<Department> getDataDepartment (){
        return departmentDao.getDepartments();
    }

    public String saveRegion (String dept_id, String dept_name, String manager_id, String loc_id){
        int dDept_id = Integer.parseInt(dept_id);
        int dManager_id = Integer.parseInt(manager_id);
        int dLoc_id = Integer.parseInt(loc_id);
        Department department = new Department(dDept_id, dept_name, dManager_id, dLoc_id);
        return departmentDao.insertDepartment(department)? "Sukses":"Gagal";
    }
    
    public String editDepartment(String dept_id, String dept_name, String manager_id, String loc_id){
        int dDept_id = Integer.parseInt(dept_id);
        int dManager_id = Integer.parseInt(manager_id);
        int dLoc_id = Integer.parseInt(loc_id);
        Department department = new Department(dDept_id, dept_name, dManager_id, dLoc_id);
        return departmentDao.updateDepartment(department)?"Sukses":"Gagal";
    }
    
    public List<Department> findDpartment(String dept_id){
        int dDept_id = Integer.parseInt(dept_id);
        return departmentDao.searchDepartment(dDept_id);
    }
    
}
 

