package com.mycompanyjga.java.mysql.crud.jg.project;

import com.mycompanyjga.java.mysql.crud.jg.dao.DepartamentoDao;
import com.mycompanyjga.java.mysql.crud.jg.dao.EmpleadoDao;
import com.mycompanyjga.java.mysql.crud.jg.dao.DepartamentoDaoImpl;
import com.mycompanyjga.java.mysql.crud.jg.dao.EmpleadoDaoImpl;
import com.mycompanyjga.java.mysql.crud.jg.project.model.Departamento;
import com.mycompanyjga.java.mysql.crud.jg.project.model.Empleado;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.IntStream;


/**
 *
 * @author joangonalv
 */
public class Menu {

    private KeyboardReader reader;
    private EmpleadoDao empDao;
    private DepartamentoDao depDao;

    public Menu() {
        reader = new KeyboardReader();
    }

    public void init() {
        int opcion;

        do {
            menu();
            opcion = reader.nextInt();
            
            switch (opcion) {
                case 1:
                    empMenu();
                    break;
                case 2:
                    depMenu();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 0:
                    System.out.println("\nSaliendo del programa.\n");
                    break;
                default:
                    System.err.println("\nEl numero introducido no se corresponde con una operacion valida.\n\n");
                    break;
            }
        } while (opcion != 0);
    }

    public void menu() {
        int opcion;

        System.out.println("SISTEMA DE GESTION");
        System.out.println("===============================");
        System.out.println("-> Introduzca una opcion de entre las siguientes:");
        System.out.println("0: Salir");
        System.out.println("1: Gestion de Empleados");
        System.out.println("2: Gestion de Departamentos");
        System.out.print("\nOpción: ");

    }
    
    public void empMenu() {
        String table = "empleados";
        int opcion;
        
        empDao = EmpleadoDaoImpl.getInstance();

        do {
            System.out.println("SISTEMA DE GESTION DE EMPLEADOS");
            System.out.println("===============================");
            System.out.println("0: Atrás");
            System.out.println("1: Listar todos los empleados");
            System.out.println("2: Listar un empleado por ID");
            System.out.println("3: Insertar un nuevo empleado");
            System.out.println("4: Actualizar un empleado");
            System.out.println("5: Eliminar un empleado");
            System.out.print("\nOpción: ");

            opcion = reader.nextInt();

            switch (opcion) {
                case 1:
                    getAll(table);
                    break;
                case 2:
                    getById(table);
                    break;
                case 3:
                    insert(table);
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 0:
                    System.out.println("\nSaliendo del programa.\n");
                    break;
                default:
                    System.err.println("\nEl numero introducido no se corresponde con una operacion valida.\n\n");
                    break;
            }
        } while (opcion != 0);
    }

    public void depMenu() {
        String table = "departamentos";
        int opcion;
        
        depDao = DepartamentoDaoImpl.getInstance();
        
        do {
            System.out.println("SISTEMA DE GESTION DE DEPARTAMENTOS");
            System.out.println("===============================");
            System.out.println("0: Atrás");
            System.out.println("1: Listar todos los departamentos");
            System.out.println("2: Listar un departamento por ID");
            System.out.println("3: Insertar un nuevo departamento");
            System.out.println("4: Actualizar un departamento");
            System.out.println("5: Eliminar un departamento");
            System.out.print("\nOpción: ");

            opcion = reader.nextInt();

            switch (opcion) {
                case 1:
                    getAll(table);
                    break;
                case 2:
                    getById(table);
                    break;
                case 3:
                    insert(table);
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 0:
                    System.out.println("\nSaliendo del programa.\n");
                    break;
                default:
                    System.err.println("\nEl numero introducido no se corresponde con una operacion valida.\n\n");
                    break;
            }
        } while (opcion != 0);
    }

    static class KeyboardReader {

        BufferedReader br;
        StringTokenizer st;

        public KeyboardReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException ex) {
                    System.err.println("Error leyendo el teclado");
                    ex.printStackTrace();
                }
            }

            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        LocalDate nextLocalDate() {
            return LocalDate.parse(next(),
                    DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
        
        String nextLine() {
            String str = "";
            try {
                if (st.hasMoreElements()) {
                    str = st.nextToken("\n");
                } else {
                    str = br.readLine();
                }
            } catch (IOException ex) {
                System.err.println("Error leyendo el teclado");
                ex.printStackTrace();
            }
            return str;
        }
    }
    
    public void insert(String table) {
        switch(table) {
            case "empleados":
                insertEmpleado();
                break;
            case "departamentos":
                insertDepartamento();
                break;
        }
        
    }
    
    public void getAll(String table) {
        switch (table) {
            case "empleados":
                getAllEmpleados();
                break;
            case "departamentos":
                getAllDepartamentos();
                break;
        }
    }
        
    public void getById(String table) {
        switch (table) {
            case "empleados":
                getEmpleadoById();
                break;
            case "departamentos":
                getDepartamentoById();
                break;
        }
    }
    
    public void update(String table) {
        switch (table) {
            case "empleados":
                updateEmpleado();
                break;
            case "departamentos":
                updateDepartamento();
                break;
        }
    }
    
    public void delete(String table) {
        
    }
    
    private void insertEmpleado() {
        System.out.println("\nINSERCION DE UN NUEVO EMPLEADO");
        System.out.println("--------------------------------\n");
        
        System.out.println("Introduzca el nombre del empleado");
        String nombre = reader.nextLine();
        
        System.out.println("Introduzca los apellidos del empleado");
        String apellidos = reader.nextLine();
        
        System.out.println("Introduzca la fecha de nacimiento del empleado (dd/MM/aaaa)");
        LocalDate fechaNacimiento = reader.nextLocalDate();
        
        System.out.println("Introduzca el puesto del empleado");
        String puesto = reader.nextLine();
        
        System.out.println("Introduzca el email del nuevo empleado");
        String email = reader.nextLine();
        
        System.out.println("Introduzca el ID del departamento del empleado");
        int idDepartamento = reader.nextInt();
        
        try {
            empDao.add(new Empleado(nombre, apellidos, fechaNacimiento, puesto, email, idDepartamento));
            System.out.println("Nuevo empleado registrado.");
        } catch (Exception e) {
            System.err.println("Error insertando el nuevo empleado en la base de datos.");
        }
    }
    
    private void insertDepartamento() {
        System.out.println("\nINSERCION DE UN NUEVO DEPARTAMENTO");
        System.out.println("--------------------------------\n");
        
        System.out.println("Introduzca el nombre del departamento");
        String nombre = reader.next();
        
        try{
            depDao.add(new Departamento(nombre));
            System.out.println("Nuevo departamento registrado.");
        } catch (Exception e) {
            System.err.println("Error insertando el nuevo departamento en la base de datos.");
        }
    }
    
    private void getAllEmpleados() {
        System.out.println("\nLISTADO DE TODOS LOS EMPLEADOS");
        System.out.println("-----------------------------------\n");
        
        try {
            List<Empleado> result = empDao.getAll();
            
            if (result.isEmpty()) {
                System.out.println("No hay empleados registrados.");
            } else {
                printCabeceraEmpleados();
                result.forEach(this::printEmpleado);
            }
        } catch (SQLException e) {
            System.err.println("Error consultando en la base de datos.");
        }
        System.out.println("\n");
    }
    
    private void getAllDepartamentos() {
        System.out.println("\nLISTADO DE TODOS LOS DEPARTAMENTOS");
        System.out.println("-----------------------------------\n");

        try {
            List<Departamento> result = depDao.getAll();
            
            if (result.isEmpty()) {
                System.out.println("No hay departamentos registrados.");
            } else {
                printCabeceraDepartamentos();
                result.forEach(this::printDepartamento);
            }
        } catch (SQLException e) {
            System.err.println("Error consultando en la base de datos.");
        }
        System.out.println("\n");
    }
    
    private void getEmpleadoById() {
        System.out.println("\nBÚSQUEDA DE EMPLEADO");
        System.out.println("----------------------\n");
        
        try {
            System.out.print("Introduzca el ID del empleado a buscar: ");
            int id = reader.nextInt();
            
            Empleado empleado = empDao.getById(id);
            
            if (empleado == null) {
                System.out.println("No se ha encontrado ningun ID que coincida.");
            } else {
                printCabeceraEmpleados();
                printEmpleado(empleado);
            }
        } catch (SQLException e) {
            System.err.println("Error consultando en la base de datos.");
        }
    }
    
    private void getDepartamentoById() {
        System.out.println("\nBÚSQUEDA DE DEPARTAMENTO");
        System.out.println("---------------------------\n");
        
        try {
            System.out.print("Introduzca el ID del departamento a buscar: ");
            int id = reader.nextInt();
            
            Departamento departamento = depDao.getById(id);
            
            if (departamento == null) {
                System.out.println("No se ha encontrado ningun ID que coincida.");
            } else {
                printCabeceraDepartamentos();
                printDepartamento(departamento);
            }
        } catch (SQLException e) {
            System.err.println("Error consultando en la base de datos.");
        }
    }
    
    private void updateEmpleado() {
        System.out.println("\nACTUALIZAR UN EMPLEADO");
        System.out.println("------------------------\n");
        
        try {
            System.out.print("Introduzca el ID del empleado: ");
            int id = reader.nextInt();
            
            Empleado empleado = empDao.getById(id);
            
            if (empleado == null) {
                System.out.println("No se ha encontrado ningun ID que coincida.");
            } else {
                printCabeceraEmpleados();
                printEmpleado(empleado);
                System.out.println("\n");
                
                System.out.printf("Introduzca el nombre del empleado (%s): ", empleado.getNombre());
                String nombre = reader.nextLine();
                
                nombre = (nombre.isBlank()) ? empleado.getNombre() : nombre;
                
                System.out.printf("Introduzca los apellidos del empleado (%s): ", empleado.getApellidos());
                String apellidos = reader.nextLine();
                apellidos = (apellidos.isBlank()) ? empleado.getApellidos(): apellidos;
                
                
            }
        } catch (SQLException e) {
            System.err.println("Error consultando en la base de datos.");
        }
    }
    
    private void updateDepartamento() {
        System.out.println("\nACTUALIZAR UN DEPARTAMENTO");
        System.out.println("----------------------------\n");
        
        try {
            System.out.print("Introduzca el ID del departamento: ");
            int id = reader.nextInt();

            Departamento departamento = depDao.getById(id);

            if (departamento == null) {
                System.out.println("No se ha encontrado ningun ID que coincida.");
            } else {
                printCabeceraDepartamentos();
                printDepartamento(departamento);
                System.out.println("\n");

                System.out.printf("Introduzca el nombre del departamento (%s)", departamento.getNombre());
                String nombre = reader.nextLine();

                nombre = (nombre.isBlank()) ? departamento.getNombre() : nombre;
            }
        } catch (SQLException e) {
            System.err.println("Error consultando en la base de datos.");
        }
    }
    
    private void printCabeceraEmpleados() {
        System.out.printf("%2s %30s %8s %10s %25s %2s", "ID", "NOMBRE", "FEC. NAC.", "PUESTO", "EMAIL", "DEP.");
        System.out.println("");
        IntStream.range(1, 100).forEach(x -> System.out.print("-"));
        System.out.println("\n");
    }
    
    private void printCabeceraDepartamentos() {
        System.out.printf("%2s %30s", "ID", "NOMBRE");
        System.out.println("");
        IntStream.range(1, 40).forEach(x -> System.out.print("-"));
        System.out.println("\n");
    }
    
    private void printEmpleado(Empleado emp) {
        System.out.printf("%2s %30s %9s %10s %25s %2s",
                emp.getId_empleado(),
                emp.getNombre() + " " + emp.getApellidos(),
                emp.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/yy")),
                emp.getPuesto(),
                emp.getEmail(),
                emp.getIdDepartamento());
        System.out.println("");

    }

    private void printDepartamento(Departamento dep) {
        System.out.printf("%2s %30s",
                dep.getIdDepartamento(),
                dep.getNombre());
        System.out.println("");
    }
}
