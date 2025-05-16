package BBDD;

import java.sql.*;
import java.util.ArrayList;

public class ConexionDAOInstituto extends ArrayList<Object> {
    private static final String URL = "jdbc:mysql://localhost:3306/instituto";
    private static final String USER = "root";
    private static final String PASSWORD = "alexisba";

    private static Connection connect() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public ArrayList <Alumno> selectAlumnos(){
        ArrayList<Alumno> alumnos= new ArrayList<>();

        try (Connection conn= connect()){
            //Escribo la consulta que quiero hacer
            String query = "SELECT id, nombre, direccion, estado_matricula, carnet_conducir " +
                    "FROM alumnos ORDER BY nombre ASC;";
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

                Alumno alumno = new Alumno(id, nombre, direccion, estado_Matricula);
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
            }else if (resultado ==0){
                System.out.println("No se ha podido insertar el alumno");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public int eliminarAlumno (String n){
        int resultado = 0;
        try (Connection conn= connect()){
            String query = "DELETE FROM alumnos " +
                    "WHERE nombre = ?";

            //Establecemos para ? su valor
            PreparedStatement stmt= conn.prepareStatement(query);
            stmt.setString(1, n);

            //El execute se usa para borrar en este caso
            resultado = stmt.executeUpdate();
            if (resultado >0){
                System.out.println("Alumno eliminado correctamente");
            }else if(resultado == 0){
                System.out.println("No se ha podido eliminar el alumno");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return resultado;
    }

    public ArrayList<Asignatura> selectAsignaturas(){
        ArrayList<Asignatura> asignaturas = new ArrayList<>();

        try (Connection conn= connect()){
            //Escribo la consulta que quiero hacer
            String query = "SELECT id, nombre, curso " +
                    "FROM asignaturas ORDER BY nombre ASC;";
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
}
