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
import models.Department;

/**
 *
 * @author Deo Lahara
 */
public class DepartmentDao {
    private Connection connection;

    
    public DepartmentDao(){}
    /**
     * Konstruktor yang akan digunakan jika nantinya ingin membuat objek dengan parameter connection
     * @param connection berisi connection yang terhubung dengan koneksi
     */
    public DepartmentDao(Connection connection){
        this.connection= connection;
    }
    
    /**
     * Method ini berfungsi untuk melakukan pencarian baik. To Lower Key berguna untuk merubah huruf kapital menjadi huruf kecil semua. 
     * Sedangkan huruf kecil sudah tidak dirubah karena sudah menjadi huruf kecil
     * 1,2,3,4 urutan kolom berdasarkan tanda tanya
     * @param name Parameter yang akan digunakan untuk pencarian keyword dengan parameter name
     * @return Mengembalikan list department
     */
    public List<Department> getSearchDepartment(String name) { 
        List<Department> departments = new ArrayList<>();
        String query = "SELECT * FROM departments";
        PreparedStatement ps = null;
        try {
            if (!name.equals("")) {
                query = "SELECT * FROM departments WHERE (department_id) LIKE ? OR lower(department_name) LIKE ? OR (manager_id) LIKE ? OR (location_id) LIKE ?";
                ps = this.connection.prepareStatement(query);
                ps.setString(1, "%"+name.toLowerCase()+"%" );
                ps.setString(2, "%"+name.toLowerCase()+"%" );
                ps.setString(3, "%"+name.toLowerCase()+"%" );
                ps.setString(4, "%"+name.toLowerCase()+"%");
            }else{
                ps = this.connection.prepareStatement(query);
            }
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Department d = new Department();
                d.setDept_id(resultSet.getInt(1));
                d.setDept_name(resultSet.getString(2));
                d.setManager_id(resultSet.getInt(3));
                d.setLoc_id(resultSet.getInt(4));
                departments.add(d);
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return departments;
    }
    
    /**
     * Method ini berfungsi untuk Query Insert Update. Boolean disini sebagai Pilihan, apakah dia adalah Inser ? Jika Insert maka menjalankan Query Insert
     * dan sebaliknya.
     * @param department tabel department yang ingin ditambahkan atau dirubah
     * @param isInsert berisi true jika insert 
     * @return Mengembalikan sebuah informasi berhasil atau tidak
     */
    public boolean insertUpdateDepartment(Department department, boolean isInsert){
        boolean result = false;
        String query = "UPDATE departments SET department_name = ?, manager_id = ?, location_id = ? WHERE department_id = ?";
        try {
            if(isInsert){
            query = "INSERT INTO departments(department_name,manager_id,location_id,department_id) VALUES (?,?,?,?)";
            }
            PreparedStatement ps = this.connection.prepareStatement(query);
            ps.setString(1, department.getDept_name());
            ps.setInt(2, department.getManager_id());
            ps.setInt(3, department.getLoc_id());
            ps.setInt(4, department.getDept_id());
            ps.executeUpdate();
            result=true;
        } catch (Exception e) {
            e.printStackTrace();
    }return result;
}

    /**
     * Method ini berfungsi untuk mendapatkan sebuah data departement berdasarkan dept_id
     * @param dept_id parameter yang akan dilakukan sebagai pencarian
     * @return 
     */
     public Department getDepartment(int dept_id){
        Department department = new Department();
        String query = "SELECT * FROM departments WHERE department_id = ?";
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            ps.setInt(1,dept_id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {                
                Department d = new Department();
                d.setDept_id(resultSet.getInt(1));
                d.setDept_name(resultSet.getString(2));
                d.setManager_id(resultSet.getInt(3));
                d.setLoc_id(resultSet.getInt(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return department;
    }
    
     /**
      * Metode ini berfungsi untuk menghapus data Tabel Departement berdasarkan ID Nya
      * @param dept_id
      * @return 
      */
        public boolean deleteDepartment(int dept_id){
            boolean result = false;
            String query = "DELETE FROM departments WHERE department_id = ?";
            try {
                PreparedStatement ps = this.connection.prepareStatement(query);
                ps.setInt(1, dept_id);
                ps.executeUpdate();
                result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

  
}
            
