package com.mycompanyjga.java.mysql.crud.jg.project;

import com.mycompanyjga.java.mysql.crud.jg.dao.EmpleadoDao;
import com.mycompanyjga.java.mysql.crud.jg.dao.DepartamentoDao;

import com.mycompanyjga.java.mysql.crud.jg.dao.EmpleadoDaoImpl;
import com.mycompanyjga.java.mysql.crud.jg.dao.DepartamentoDaoImpl;

import com.mycompanyjga.java.mysql.crud.jg.project.model.Departamento;
import com.mycompanyjga.java.mysql.crud.jg.project.model.Empleado;

import com.mycompanyjga.java.mysql.crud.jg.project.pool.MyDataSource;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author joangonalv
 */
public class JavaMysqlCrudJgProject {

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.init();
    }
    
    public static void testDao() {
//        DepartamentoDao dao = DepartamentoDaoImpl.getInstance();
//        
//        Departamento dep = new Departamento("Educación");
//        
//        try {
//            ADD
//            int n = dao.add(dep);
//            System.out.println("El número de registros insertados es: " + n);
//            
//            GET ALL
//            List<Departamento> departamentos = dao.getAll();
//            
//            if (departamentos.isEmpty()) {
//                System.out.println("No hay departamentos");
//            } else {
//                departamentos.forEach(System.out::println);
//            }

//            GET BY ID
//            Departamento dep1 = dao.getById(1);
//            System.out.println(dep1);
//            
//            dep1.setNombre("Construccion");
//            int n = dao.update(dep1);
//            dep1 = dao.getById(1);
//            System.out.println(dep1);
//            
//            DELETE
//            dao.delete(1);
//            
//            List<Departamento> departamentos = dao.getAll();
//            if (departamentos.isEmpty()) {
//                System.out.println("Empty Table");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//
//        EmpleadoDao dao = EmpleadoDaoImpl.getInstance();
//        
//        Empleado emp = new Empleado("Luis Miguel", "Lopez Magaña", LocalDate.of(1982, 9, 18), "Profesor", "luismi@test.com", 1);
//        
//        try {
//            ADD
//            int n = dao.add(emp);
//            System.out.println("El número de registros insertados es: " + n);
//
//            GET ALL
//            List<Empleado> empleados = dao.getAll();
//            
//            if (empleados.isEmpty()) {
//                System.out.println("No hay empleados");
//            } else {
//                empleados.forEach(System.out::println);
//            }
//            GET BY ID
//            Empleado emp1 = dao.getById(2);
//            System.out.println(emp1);
//            
//            UPDATE
//            emp1.setFechaNacimiento(LocalDate.of(1992, 9, 19));
//
//            int n = dao.update(emp1);
//            emp1 = dao.getById(1);
//            System.out.println(emp1);
//
//            DELETE
//            dao.delete(1);
//
//            List<Empleado> empleados = dao.getAll();
//            if (empleados.isEmpty()) {
//                System.out.println("Empty Table");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
    
    public static void testPool() {
        try (Connection conn = MyDataSource.getConnection()) {
            DatabaseMetaData metaData = conn.getMetaData();
            String[] types = {"TABLE"};
            ResultSet tables = metaData.getTables(null, null, "%", types);
            while(tables.next()) {
                System.out.println(tables.getString("TABLE_NAME"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
