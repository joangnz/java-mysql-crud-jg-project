
package com.mycompanyjga.java.mysql.crud.jg.dao;

import com.mycompanyjga.java.mysql.crud.jg.project.model.Departamento;
import com.mycompanyjga.java.mysql.crud.jg.project.pool.MyDataSource;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joangonalv
 */
public class DepartamentoDaoImpl implements DepartamentoDao{

    private static DepartamentoDaoImpl instance;
    
    static {
        instance = new DepartamentoDaoImpl();
    }
    
    private DepartamentoDaoImpl() {}
    
    public static DepartamentoDaoImpl getInstance() {
        return instance;
    }
    
    @Override
    public int add(Departamento dep) throws SQLException {
        
        String sql = """
                     INSERT INTO departamentos (nombre)
                     VALUES (?);
                     """;
        
        int result;
        
        try(Connection conn = MyDataSource.getConnection(); PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, dep.getNombre());
            
            result = pstm.executeUpdate();
        }
        
        return result;
    }

    @Override
    public Departamento getById(int id) throws SQLException {
        Departamento result = null;

        String sql = "SELECT * FROM departamentos WHERE id_departamento = ?";

        try (Connection conn = MyDataSource.getConnection(); PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setInt(1, id);

            try (ResultSet rs = pstm.executeQuery()) {
                while (rs.next()) {
                    result = new Departamento();
                    result.setIdDepartamento(rs.getInt("id_departamento"));
                    result.setNombre(rs.getString("nombre"));
                }
            }
        }
        return result;
    }

    @Override
    public List<Departamento> getAll() throws SQLException {
        String sql = "SELECT * FROM departamentos";
        
        List<Departamento> result = new ArrayList<>();
        
        try (Connection conn = MyDataSource.getConnection(); PreparedStatement pstm = conn.prepareStatement(sql); ResultSet rs = pstm.executeQuery()) {
            Departamento dep;

            while (rs.next()) {
                dep = new Departamento();
                dep.setIdDepartamento(rs.getInt("id_departamento"));
                dep.setNombre(rs.getString("nombre"));

                result.add(dep);
            }
        }

        return result;
    }

    @Override
    public int update(Departamento dep) throws SQLException {
        String sql = """
                     UPDATE departamentos SET
                        nombre = ?
                     WHERE id_departamento = ?
                     """;
        
        int result;

        try (Connection conn = MyDataSource.getConnection(); PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, dep.getNombre());
            pstm.setInt(2, dep.getIdDepartamento());

            result = pstm.executeUpdate();

        }
        return result;
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM departamentos WHERE id_departamento = ?";

        try (Connection conn = MyDataSource.getConnection(); PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setInt(1, id);
            pstm.executeUpdate();
        }
    }
}
