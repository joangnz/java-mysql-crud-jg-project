package com.mycompanyjga.java.mysql.crud.jg.dao;

import com.mycompanyjga.java.mysql.crud.jg.project.model.Departamento;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author joangonalv
 */
public interface DepartamentoDao {
    
    int add(Departamento emp) throws SQLException;
    
    Departamento getById(int id) throws SQLException;
    
    List<Departamento> getAll() throws SQLException;
    
    int update(Departamento dep) throws SQLException;
    
    void delete(int id) throws SQLException;
}
