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
        return String.format(
                "%-5d %-10d %-20s %-25s %-5.2f",
                id,
                alumno.getId(),
                alumno.getNombre() != null ? alumno.getNombre() : "N/A",
                asignatura.getNombre() != null ? asignatura.getNombre() : "N/A",
                nota
        );
    }

}
