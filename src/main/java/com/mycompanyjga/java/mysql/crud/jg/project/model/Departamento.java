package com.mycompanyjga.java.mysql.crud.jg.project.model;

import java.util.Objects;

/**
 *
 * @author joangonalv
 */
public class Departamento {
    private int idDepartamento;
    private String nombre;
    
    public Departamento() {
        
    }
    
    public Departamento(String nombre) {
        this.nombre = nombre;
    }
    
    public Departamento(int idDepartamento, String nombre) {
        this(nombre);
    }
    
    public int getIdDepartamento() {
        return idDepartamento;
    }
    
    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Departamento departamento = (Departamento) o;
        return idDepartamento == departamento.idDepartamento
                && Objects.equals(nombre, departamento.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDepartamento, nombre);
    }

    @Override
    public String toString() {
        return "Departamento{" + "idDepartamento=" + idDepartamento + ", nombre=" + nombre + '}';
    }   
}
