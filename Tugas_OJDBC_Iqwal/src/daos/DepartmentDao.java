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
    private List<Department> departmens;
    
    public DepartmentDao(){}
    
    public DepartmentDao(Connection connection){
        this.connection= connection;
    }
    
    public List<Department> getDepartments (){
        List<Department> departments = new ArrayList<>();
        String query = "SELECT * FROM departments";
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Department d = new Department();
                d.setDept_id(resultSet.getInt("departments_id"));
                d.setDept_name(resultSet.getString(2));
                d.setManager_id(resultSet.getInt("manager_id"));
                d.setLoc_id(resultSet.getInt("location_id"));
                departments.add(d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }return departments;
        
    }
    
    public boolean insertDepartment (Department department){
        boolean result = false;
        String query = "INSERT INTO departments(department_id, department_name, manager_id, location_id) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            ps.setInt(1, department.getDept_id());
            ps.setString(2, department.getDept_name());
            ps.setInt(3, department.getManager_id());
            ps.setInt(4, department.getLoc_id());
            result=true;
            
        } catch (Exception e) {
            e.printStackTrace();
        } return result;
    
    }
    
    public boolean updateDepartment (Department department){
        boolean result = false;
        String query ="UPDATE departments SET department_name = ? WHERE department_id = ?";
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            ps.setInt(2, department.getDept_id());
            ps.setString(1, department.getDept_name());
//            ps.setInt(3, department.getManager_id());
//            ps.setInt(4, department.getLoc_id());
            ps.executeUpdate();
            result=true;
            
        } catch (Exception e) {
            e.printStackTrace();
        } return result;
    
    }
    
    public List<Department> searchDepartment(int dept_id) {
        List<Department> departments = new ArrayList<>();
        String query = "SELECT * FROM departments WHERE department_id = ?";
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            ps.setInt(1, dept_id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {                
                Department d = new Department();
                d.setDept_id(resultSet.getInt(1));
                d.setDept_name(resultSet.getString(2));
//                d.setManager_id(resultSet.getInt(3));
//                d.setLoc_id(resultSet.getInt(4));
                departments.add(d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return departments;
}
