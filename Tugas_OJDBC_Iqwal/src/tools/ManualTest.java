/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controllers.DepartmentController;
import java.util.List;
import models.Department;

/**
 *
 * @author Deo Lahara
 */
public class ManualTest {
    public static void main(String[] args) {
        
        //Department Insert Update Delete
//        System.out.println(new DepartmentController().addDepartment("301", "Support Admin", "200", "1700")); //INSERT BISA
//        System.out.println(new DepartmentController().editDepartment("301", "Support Administrasi", "201", "1700")); //EDIT BISA
//        System.out.println(new DepartmentController().deleteDepartment("300"));//Delete Bisa
        //Show Data
        List<Department> data = new DepartmentController().findDepartment("mi");
        //Department data = new DepartmentController().getDataDepartment("10");
        for (Department department : data) {
            System.out.println(department.getDept_id()+" "+department.getDept_name());
        }
                      
  }
}




