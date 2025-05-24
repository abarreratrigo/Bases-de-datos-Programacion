package Clases;

public class Matricula {
    private int id;
    Alumno alumno;
    Asignatura asignatura;
    float nota;

    public Matricula(int id, Alumno alumno, Asignatura asignatura, float nota){
        this.id = id;
        this.alumno = alumno;
        this.asignatura = asignatura;
        this.nota = nota;
    }

    public Matricula(Alumno alumno, Asignatura asignatura, float nota ){
        this.alumno = alumno;
        this.asignatura = asignatura;
        this.nota = nota;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Alumno getAlumno() {
        return alumno;
    }
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }
    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public float getNota() {
        return nota;
    }
    public void setNota(float nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "\tId= " + id +
                " | IdAlumno='" + alumno.getId() + '\'' +
                " | Alumno='" + alumno.getNombre() + '\'' +
                " | Asignatura='" + asignatura.getNombre() + '\'' +
                " | Nota='" + nota + '\'' +
                '\n';
    }
}
