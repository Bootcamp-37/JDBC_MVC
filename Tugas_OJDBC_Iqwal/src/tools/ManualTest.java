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
        System.out.println(new Koneksi().getConnection());
//        System.out.println(new DepartmentController().editDepartment("10", "Administrasi", "200", "1700"));
        List<Department> data = new DepartmentController().findDpartment("20");
        for (Department department : data) {
            System.out.println(department.getDept_id()+" "+department.getDept_name());
    }
}


