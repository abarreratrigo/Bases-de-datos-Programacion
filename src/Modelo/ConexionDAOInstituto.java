package Modelo;

import Clases.Alumno;
import Clases.Asignatura;
import Clases.Matricula;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConexionDAOInstituto extends ArrayList<Object> {
    private static final String URL = "jdbc:mysql://localhost:3306/instituto";
    private static final String USER = "root";
    private static final String PASSWORD = "261206";
    private static Connection connect() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }


    /**
     * MÉTODOS DE ALUMNOS
     */

    public ArrayList <Alumno> selectAlumnos(){
        ArrayList<Alumno> alumnos= new ArrayList<>();

        try (Connection conn= connect()){
            //Escribo la consulta que quiero hacer
            String query = "SELECT * FROM alumnos;";
            //Preparo una sentencia en la conexión
            PreparedStatement stmt= conn.prepareStatement(query);
            //Ejecuto la sentencia y obtengo un conjunto de resultados
            ResultSet rs= stmt.executeQuery();

            while (rs.next()){
                //Tiene que estar en el mismo orden que las columnas
                int id= rs.getInt("id");
                String nombre= rs.getString("nombre");
                String direccion = rs.getString("direccion");
                String estado_Matricula= rs.getString("estado_Matricula");
                boolean carnet_conducir= (rs.getInt("carnet_conducir")==1) ? true : false;

                //Con lo leído de la base de datos
                //Creamos un objeto Alumno del modelo

                Alumno alumno = new Alumno(id, nombre, direccion, estado_Matricula, carnet_conducir);
                alumnos.add(alumno);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return alumnos;
    }

    public int insertarAlumno (Alumno a){
        int resultado = 0;
        try(Connection conn= connect()) {
            String query= "INSERT INTO alumnos (nombre, direccion, estado_matricula, carnet_conducir) "
                    + "VALUES (?, ?, ?, ?)";

            //Establecemos para cada ? su valor
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, a.getNombre());
            stmt.setString(2, a.getDireccion());
            stmt.setString(3, a.getEstadoMatricula());
            stmt.setInt(4, a.isCarnetConducir() ? 1 : 0);

            //El execute update se utiliza tanto para insertar, borrar o actualizar
            resultado = stmt.executeUpdate();
            if(resultado > 0){
                System.out.println("Alumno insertado correctamente");
                Thread.sleep(1000);
            }else if (resultado ==0){
                System.out.println("No se ha podido insertar el alumno");
                Thread.sleep(1000);
            }
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public int eliminarAlumno (int idAlumno){
        int resultado = 0;
        try (Connection conn= connect()){
            String query = "DELETE FROM alumnos " +
                    "WHERE id = " + idAlumno +";";

            //Establecemos para ? su valor
            PreparedStatement stmt= conn.prepareStatement(query);
            stmt.setInt(1, idAlumno);

            //El execute se usa para borrar en este caso
            resultado = stmt.executeUpdate();
            if (resultado >0){
                System.out.println("Alumno eliminado correctamente");
                Thread.sleep(1000);
            }else if(resultado == 0){
                System.out.println("No se ha podido eliminar el alumno");
                Thread.sleep(1000);
            }
        }catch (SQLException | InterruptedException e){
            e.printStackTrace();
        }
        return resultado;
    }

    public Alumno obtenerAlumnoPorId(int idAlumno){
        Alumno a = null;
        try (Connection conn= connect()){
            //Escribo la consulta
            String query = "SELECT id, nombre, direccion, estado_matricula, carnet_conducir FROM alumnos " +
                    "WHERE id = " + idAlumno +";";

            //Preparamos una sentencia
            PreparedStatement stmt= conn.prepareStatement(query);

            //Ejecutamos la sentencia
            ResultSet rs= stmt.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id");
                String nombre= rs.getString("nombre");
                String direccion= rs.getString("direccion");
                String estadoMatricula= rs.getString("estado_matricula");
                boolean carnet= (rs.getInt("carnet_conducir") ==1) ? true : false;

                //Con todos los datos leídos devolvemos el alumno
                a = new Alumno(id, nombre, direccion, estadoMatricula, carnet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return a;
    }

    /**
     * MÉTODOS DE ASIGNATURAS
     */

    public ArrayList<Asignatura> selectAsignaturas(){
        ArrayList<Asignatura> asignaturas = new ArrayList<>();

        try (Connection conn= connect()){
            //Escribo la consulta que quiero hacer
            String query = "SELECT * FROM asignaturas;";
            //Preparo una sentencia en la conexión
            PreparedStatement stmt= conn.prepareStatement(query);
            //Ejecuto la sentencia y obtengo un conjunto de resultados
            ResultSet rs= stmt.executeQuery();

            while (rs.next()){
                //Tiene que estar en el mismo orden que las columnas
                int id= rs.getInt("id");
                String nombre= rs.getString("nombre");
                int curso = rs.getInt("curso");

                //Con lo leído de la base de datos
                //Creamos un objeto Alumno del modelo

                Asignatura asignatura = new Asignatura(id, nombre, curso);
                asignaturas.add(asignatura);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return asignaturas;
    }

    public int insertarAsignatura(Asignatura a){
        int resultado = 0;
        try(Connection conn= connect()) {
            String query= "INSERT INTO asignaturas (nombre,curso) "
                    + "VALUES (?, ?)";

            //Establecemos para cada ? su valor
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, a.getNombre());
            stmt.setInt(2, a.getCurso());

            //El execute update se utiliza tanto para insertar, borrar o actualizar
            resultado = stmt.executeUpdate();
            if(resultado > 0){
                System.out.println("Asignatura insertada correctamente");
                Thread.sleep(1000);
            }else if (resultado ==0){
                System.out.println("No se ha podido insertar la asignatura");
                Thread.sleep(1000);
            }
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public int eliminarAsignatura(String nombre){
        int resultado = 0;
        try (Connection conn= connect()){
            String query = "DELETE FROM asignaturas " +
                    "WHERE nombre = " + nombre + ";";

            //Establecemos para ? su valor
            PreparedStatement stmt= conn.prepareStatement(query);
            stmt.setString(1, nombre);

            //El execute se usa para borrar en este caso
            resultado = stmt.executeUpdate();
            if (resultado >0){
                System.out.println("Asignatura eliminada correctamente");
                Thread.sleep(1000);
            }else if(resultado == 0){
                System.out.println("No se ha podido eliminar la asignatura");
                Thread.sleep(1000);
            }
        }catch (SQLException | InterruptedException e){
            e.printStackTrace();
        }
        return resultado;
    }

    public Asignatura obtenerAsignaturaPorId(int idAsignatura){
        Asignatura a = null;
        try (Connection conn= connect()){
            //Escribo la consulta
            String query = "SELECT id, nombre, curso FROM asignaturas " +
                    "WHERE id = " + idAsignatura +";";

            //Preparamos una sentencia
            PreparedStatement stmt= conn.prepareStatement(query);

            //Ejecutamos la sentencia
            ResultSet rs= stmt.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id");
                String nombre= rs.getString("nombre");
                int curso= rs.getInt("curso");

                //Con todos los datos leídos devolvemos el alumno
                a = new Asignatura(id, nombre, curso);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return a;
    }


    /**
     * MÉTODOS DE MATRÍCULAS
     */

    public ArrayList<Matricula> selectMatriculas(){
        ArrayList<Matricula> matriculas = new ArrayList<>();

        try (Connection conn = connect()){
            String query = "SELECT * FROM matriculas JOIN alumnos ON matriculas.id_alumno = alumnos.id JOIN asignaturas ON matriculas.id_asignatura = asignaturas.id;";

            PreparedStatement stmt= conn.prepareStatement(query);

            ResultSet rs= stmt.executeQuery();

            while (rs.next()){
                //Obtenemos los datos de la base de datos para crear la matrícula
                boolean carnet= (rs.getInt("carnet_conducir") ==1) ? true : false;
                Alumno a = new Alumno(
                        rs.getInt("alumnos.id"),
                        rs.getString("alumnos.nombre"),
                        rs.getString("direccion"),
                        rs.getString("estado_matricula"),
                        carnet
                );

                Asignatura as= new Asignatura(
                        rs.getInt("asignaturas.id"),
                        rs.getString("asignaturas.nombre"),
                        rs.getInt("curso")
                );

                Matricula matricula = new Matricula(
                        rs.getInt("id"),
                        a,
                        as,
                        rs.getFloat("nota")
                );

                //Con lo leído de la base de datos
                //Añadimos la matricula

                matriculas.add(matricula);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return matriculas;
    }

    public int insertarMatricula(Matricula m) {
        int resultado = 0;

        try (Connection conn = connect()) {
            // Validación previa
            if (m.getAlumno() == null || m.getAsignatura() == null) {
                System.out.println("Error: El alumno o la asignatura de la matrícula no existe.");
                return 0;
            }

            String query = "INSERT INTO matriculas (id_alumno, id_asignatura, nota) VALUES (?, ?, ?);";

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, m.getAlumno().getId());
            stmt.setInt(2, m.getAsignatura().getId());
            stmt.setFloat(3, m.getNota());

            resultado = stmt.executeUpdate();

            if (resultado > 0) {
                System.out.println("Matrícula insertada correctamente");
                Thread.sleep(1000);
            } else {
                System.out.println("No se ha podido insertar la matrícula");
                Thread.sleep(1000);
            }

        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }

        return resultado;
    }

    public int eliminarMatricula(int idAlumno, int idAsignatura){
        int resultado = 0;

        try (Connection conn= connect()){
            String query = "DELETE FROM matriculas " +
                    "WHERE id_alumno = " + idAlumno + " AND id_asignatura = " + idAsignatura + ";";

            PreparedStatement stmt= conn.prepareStatement(query);
            resultado=stmt.executeUpdate();

            if (resultado>0){
                System.out.println("Matrícula eliminada correctamente");
                Thread.sleep(1000);
            } else if (resultado == 0) {
                System.out.println("La matrícula no se ha podido eliminar");
                Thread.sleep(1000);
            }
        }
        catch (SQLException | InterruptedException e){
            System.out.println("No se ha podido eliminar");
        }
        return resultado;
    }

    public List<Matricula> selectMatriculasPorAlumno(int idAlumno){
        ArrayList<Matricula> matriculas = new ArrayList<>();

        try (Connection conn= connect()){
            //Escribo la consulta que quiero hacer
            String query = "SELECT m.id, m.nota, " +
                    "a.id as idAlumno, a.nombre as nombreAlumno, a.direccion, a.estado_matricula, a.carnet_conducir, " +
                    "b.id as idAsig, b.nombre as nombreAsignatura, b.curso " +
                    "FROM matriculas m INNER JOIN alumnos a ON m.id_alumno = a.id " +
                    "INNER JOIN asignaturas b ON m.id_asignatura = b.id " +
                    "WHERE a.id = " + idAlumno + ";";

            //Preparo una sentencia en la conexión
            PreparedStatement stmt= conn.prepareStatement(query);
            //Ejecuto la sentencia y obtengo un conjunto de resultados
            ResultSet rs= stmt.executeQuery();

            while (rs.next()){
                //Obtenemos los datos de la base de datos para crear la matrícula
                boolean carnet= (rs.getInt("carnet_conducir") ==1) ? true : false;
                Alumno a = new Alumno(
                        rs.getInt("idAlumno"),
                        rs.getString("nombreAlumno"),
                        rs.getString("direccion"),
                        rs.getString("estado_matricula"),
                        carnet
                );

                Asignatura as= new Asignatura(
                        rs.getInt("idAsig"),
                        rs.getString("nombreAsignatura"),
                        rs.getInt("curso")
                );

                Matricula matricula = new Matricula(
                        rs.getInt("id"),
                        a,
                        as,
                        rs.getFloat("nota")
                );

                //Con lo leído de la base de datos
                //Añadimos la matricula

                matriculas.add(matricula);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return matriculas;
    }

    public List<Matricula> selectMatriculasPorAsignatura(int idAsig){
        ArrayList<Matricula> matriculas = new ArrayList<>();

        try (Connection conn= connect()){
            //Escribo la consulta que quiero hacer
            String query = "SELECT m.id, m.nota, " +
                    "a.id as idAlumno, a.nombre as nombreAlumno, a.direccion, a.estado_matricula, a.carnet_conducir, " +
                    "b.id as idAsig, b.nombre as nombreAsignatura, b.curso " +
                    "FROM matriculas m INNER JOIN alumnos a ON m.id_alumno = a.id " +
                    "INNER JOIN asignaturas b ON m.id_asignatura = b.id " +
                    "WHERE b.id = " + idAsig + ";";

            //Preparo una sentencia en la conexión
            PreparedStatement stmt= conn.prepareStatement(query);
            //Ejecuto la sentencia y obtengo un conjunto de resultados
            ResultSet rs= stmt.executeQuery();

            while (rs.next()){
                //Obtenemos los datos de la base de datos para crear la matrícula
                boolean carnet= (rs.getInt("carnet_conducir") ==1) ? true : false;
                Alumno a = new Alumno(
                        rs.getInt("idAlumno"),
                        rs.getString("nombreAlumno"),
                        rs.getString("direccion"),
                        rs.getString("estado_matricula"),
                        carnet
                );

                Asignatura as= new Asignatura(
                        rs.getInt("idAsig"),
                        rs.getString("nombreAsignatura"),
                        rs.getInt("curso")
                );

                Matricula matricula = new Matricula(
                        rs.getInt("id"),
                        a,
                        as,
                        rs.getFloat("nota")
                );

                //Con lo leído de la base de datos
                //Añadimos la matricula

                matriculas.add(matricula);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return matriculas;
    }

    /**
     * MÉTODO EXTRA
     */

    public float[] obtenerNotasExtremasPorAlumno(int idAlumno) {
        float[] notas = new float[2]; // [0] = menor, [1] = mayor
        notas[0] = 0; // valor por defecto si no hay notas
        notas[1] = 0;

        String query = "SELECT MIN(nota) AS notaMin, MAX(nota) AS notaMax FROM matriculas WHERE id_alumno = ?";

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, idAlumno);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                notas[0] = rs.getFloat("notaMin");
                notas[1] = rs.getFloat("notaMax");

                if (rs.wasNull()) {
                    notas[0] = 0;
                    notas[1] = 0;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notas;
    }
}
