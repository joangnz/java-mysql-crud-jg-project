package com.mycompanyjga.java.mysql.crud.jg.dao;

import com.mycompanyjga.java.mysql.crud.jg.project.model.Empleado;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author joangonalv
 */
public interface EmpleadoDao {
    
    int add(Empleado emp) throws SQLException;
    
    Empleado getById(int id) throws SQLException;
    
    List<Empleado> getAll() throws SQLException;
    
    int update(Empleado emp) throws SQLException;
    
    void delete(int id) throws SQLException;
}
