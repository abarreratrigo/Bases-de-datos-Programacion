package Controlador;
import Clases.*;
import Modelo.ConexionDAOInstituto;

import java.util.List;

public class Controlador {

    //Declaro un objeto ConexionDAOInstituto sin preocuparse
    //de que tipo es la base de datos ni como se obtienen los datos
    ConexionDAOInstituto daoInstituto = new ConexionDAOInstituto();

    /**
     * MÉTODOS DE LA CLASE ALUMNO
     */

    public List<Alumno> obtenerAlumno() {
        List<Alumno> lista = daoInstituto.selectAlumnos();
        return lista;
    }

    public int insertarAlumno(Alumno a) {
        return daoInstituto.insertarAlumno(a);
    }

    public int eliminarAlumno(int id) {
        return daoInstituto.eliminarAlumno(id);
    }

    public Alumno obtenerAlumnoPorId(int idAlumno) {
        return daoInstituto.obtenerAlumnoPorId(idAlumno);
    }

    public float notaMediaAlumno(int idAlumno){
        List<Matricula> matriculas = daoInstituto.selectMatriculasPorAlumno(idAlumno);
        float notaMedia = 0;
        for (Matricula m : matriculas){
            notaMedia += m.getNota();
        }
        return notaMedia/matriculas.size();
    }

    /**
     * MÉTODOS DE LA CLASE ASIGNATURA
     */

    public List<Asignatura> obtenerAsignaturas() {
        List<Asignatura> lista = daoInstituto.selectAsignaturas();
        return lista;
    }

    public int insertarAsignatura(Asignatura a) {
        return daoInstituto.insertarAsignatura(a);
    }

    public int eliminarAsignatura(String nombre) {
        return daoInstituto.eliminarAsignatura(nombre);
    }

    public Asignatura obtenerAsignaturaPorId(int id) {
        return daoInstituto.obtenerAsignaturaPorId(id);
    }

    public float notaMediaAsignatura(int idAsignatura){
        List<Matricula> matriculas = daoInstituto.selectMatriculasPorAsignatura(idAsignatura);
        float notaMedia = 0;
        for (Matricula m : matriculas){
            notaMedia += m.getNota();
        }
        return notaMedia/matriculas.size();
    }

    /**
     * MÉTODOS DE LA CLASE MATRÍCULA
     */

    public List<Matricula> obtenerMatriculas(){
        List<Matricula> lista = daoInstituto.selectMatriculas();
        return lista;
    }
    public List<Matricula> selectMatriculasPorAlumno(int idAlumno) {
        return daoInstituto.selectMatriculasPorAlumno(idAlumno);
    }

    public int insertarMatricula(Matricula m){
        return daoInstituto.insertarMatricula(m);
    }

    public int eliminarMatricula(int idAlumno, int idAsignatura){
        return daoInstituto.eliminarMatricula(idAlumno,idAsignatura);
    }

    public List<Matricula> selectMatriculasPorAsignatura(int idAsignatura){
        return daoInstituto.selectMatriculasPorAsignatura(idAsignatura);
   }

    /**
     * MÉTODO EXTRA
     */

    public float [] notaExtremoAlumno(int id){
        float [] notas = daoInstituto.obtenerNotasExtremasPorAlumno(id);
        return notas;
    }
}


