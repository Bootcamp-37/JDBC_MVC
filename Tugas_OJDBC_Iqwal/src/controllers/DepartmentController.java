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
        this.departmentDao = new DepartmentDao(new Koneksi().getConnection());
    }
    /**
     * Konstruktor yang akan digunakan jika nantinya ingin membuat objek dengan parameter connection
     * @param connection berisi connection yang terhubung dengan koneksi
     * @return 
     */
    
    public List<Department> getDataDepartements(){
        return departmentDao.getSearchDepartment("");
    }
    
    /**
     * Method ini digunakan untuk menambahkan department baru dengan inputan sesuai dengan banyaknya parameter
     * Mengambil nilai yang akan ditampilkan menjadi String. Dengan cara mengubah nilai awalan (int) menjadi String dengan Integer.parseInt
     * @param dept_id parameter pada kolom dept_id
     * @param dept_name parameter pada kolom dept_name
     * @param manager_id parameter pada kolom manager_id
     * @param loc_id parameter pada kolom loc_id
     * @return 
     */
    public String addDepartment(String dept_id, String dept_name, String manager_id, String loc_id){
        int dDept_id = Integer.parseInt(dept_id);
        int dManager_id = Integer.parseInt(manager_id);
        int dLoc_id = Integer.parseInt(loc_id);
        Department department = new Department(dDept_id, dept_name, dManager_id, dLoc_id);
        return departmentDao.insertUpdateDepartment(department,true)?"Sukses Menambahkan":"Gagal Menambahkan";
    }
    
    /**
     * Method ini digunakan untuk mengedit/merubah department sesuai dengan inputan yang akan dirubah sesuai parameter
     * Mengambil nilai yang akan ditampilkan menjadi String. Dengan cara mengubah nilai awalan (int) menjadi String dengan Integer.parseInt
     * @param dept_id parameter pada kolom dept_id
     * @param dept_name parameter pada kolom dept_name
     * @param manager_id parameter pada kolom manager_id
     * @param loc_id parameter pada kolom loc_id
     * @return 
     */
    public String editDepartment(String dept_id, String dept_name, String manager_id, String loc_id){
        int dDept_id = Integer.parseInt(dept_id);
        int dManager_id = Integer.parseInt(manager_id);
        int dLoc_id = Integer.parseInt(loc_id);
        Department department = new Department(dDept_id, dept_name, dManager_id, dLoc_id);
        return departmentDao.insertUpdateDepartment(department,false)?"Sukses Mengedit":"Gagal Mengedit";
    }
    
    /**
     * Method ini digunakan untuk mencari data pada Department dengan menggunakan keyword
     * @param name parameter yang digunakan sebagai keyword
     * @return 
     */
    public List<Department> findDepartment(String name){
        return departmentDao.getSearchDepartment(name);
    }
    
    public Department getDataDepartment(String dept_id){
        int dDept_id = Integer.parseInt(dept_id);
        return departmentDao.getDepartment(dDept_id);
    }
    
    /**
     * Method ini digunakan untuk menghapus department yang diinginkan berdasarkan dept_id
     * Mengambil nilai yang akan ditampilkan menjadi String. Dengan cara mengubah nilai awalan (int) menjadi String dengan Integer.parseInt
     * @param dept_id
     * @return 
     */
    public String deleteDepartment(String dept_id){
        int dDept_id = Integer.parseInt(dept_id);
        return departmentDao.deleteDepartment(dDept_id)?"Sukses Menghapus":"Gagal Menghapus";

    }
    

     }
