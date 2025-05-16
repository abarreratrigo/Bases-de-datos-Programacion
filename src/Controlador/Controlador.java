package Controlador;
import BBDD.*;

import java.util.List;

public class Controlador {

    //Declaro un objeto ConexionDAOInstituto sin preocuparse
    //de que tipo es la base de datos ni como se obtienen los datos
    ConexionDAOInstituto daoInstituto= new ConexionDAOInstituto();
    public Controlador(){

    }

    //Primer metodo: Hallar alumno de la base de datos
    //Tengo que llamar al metodo selectAlumnos del DAO
    public List<Alumno> obtenerAlumno(){
        List<Alumno> lista= daoInstituto.selectAlumnos();
        return lista;
    }

    public int insertarAlumno(Alumno a){
        return daoInstituto.insertarAlumno(a);
    }

    public int eliminarAlumno(String nombre){
        return daoInstituto.eliminarAlumno(nombre);
    }

    public List<Asignatura> obtenerAsignaturas(){
        List<Asignatura> lista = daoInstituto.selectAsignaturas();
        return lista;
    }
}
