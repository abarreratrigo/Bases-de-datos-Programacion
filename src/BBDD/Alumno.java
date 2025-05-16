package BBDD;

public class Alumno {
    private int id;
    private String nombre;
    private String direccion;
    private String estadoMatricula;
    private boolean carnetConducir;

    public Alumno (int id, String nombre, String dir, String estado){
        this.id = id;
        this.nombre = nombre;
        this.direccion= dir;
        this.estadoMatricula = estado;
    }

    public Alumno (int id, String nombre, String dir, String estado, boolean carnetConducir){
        this (id, nombre, dir, estado);
        this.carnetConducir= carnetConducir;
    }

    public Alumno (int id, String nombre){
        this.id=id;
        this.nombre=nombre;
    }
    public Alumno (String nombre, String direccion, String estadoMatricula, boolean carnetConducir){
        this.nombre=nombre;
        this.direccion= direccion;
        this.estadoMatricula= estadoMatricula;
        this.carnetConducir = carnetConducir;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstadoMatricula() {
        return estadoMatricula;
    }
    public void setEstadoMatricula(String estadoMatricula) {
        this.estadoMatricula = estadoMatricula;
    }

    public boolean isCarnetConducir() {
        return carnetConducir;
    }
    public void setCarnetConducir(boolean carnetConducir) {
        this.carnetConducir = carnetConducir;
    }

    @Override
    public String toString() {
        return "\tId= " + id +
                " | Nombre='" + nombre + '\'' +
                " | Direccion='" + direccion + '\'' +
                " | Estado Matricula='" + estadoMatricula + '\'' +
                " | Carnet Conducir=" + carnetConducir +
                '\n';
    }
}
