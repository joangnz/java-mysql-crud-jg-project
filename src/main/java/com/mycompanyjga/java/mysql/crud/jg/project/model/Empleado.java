package com.mycompanyjga.java.mysql.crud.jg.project.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author joangonalv
 */
public class Empleado {
    private int id_empleado;
    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private String puesto;
    private String email;
    private int idDepartamento;
    
    public Empleado() {
        
    }

    public Empleado(String nombre, String apellidos, LocalDate fechaNacimiento, String puesto, String email, int idDepartamento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.puesto = puesto;
        this.email = email;
        this.idDepartamento = idDepartamento;
    }

    public Empleado(int id_empleado, String nombre, String apellidos, LocalDate fechaNacimiento, String puesto, String email, int idDepartamento) {
        this(nombre, apellidos, fechaNacimiento, puesto, email, idDepartamento);
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public int getIdDepartamento() {
        return idDepartamento;
    }
    
    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return id_empleado == empleado.id_empleado
                && Objects.equals(nombre, empleado.nombre)
                && Objects.equals(apellidos, empleado.apellidos)
                && Objects.equals(fechaNacimiento, empleado.fechaNacimiento)
                && Objects.equals(puesto, empleado.puesto)
                && Objects.equals(email, empleado.email)
                && Objects.equals(idDepartamento, empleado.idDepartamento);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id_empleado, nombre, apellidos, fechaNacimiento, puesto, email, idDepartamento);
    }

    @Override
    public String toString() {
        return "Empleado{" + "id_empleado=" + id_empleado + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fechaNacimiento=" + fechaNacimiento + ", puesto=" + puesto + ", email=" + email + ", idDepartamento=" + idDepartamento + '}';
    }
    
}
