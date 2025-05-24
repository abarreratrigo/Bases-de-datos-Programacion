package Vistas;

import Clases.Alumno;
import Clases.Asignatura;
import Clases.Matricula;
import Controlador.Controlador;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//Implementamos como si fuera una vista de UI
public class Main {
    public static void main(String[] args) throws InterruptedException{
        Controlador controlador= new Controlador();

        int opcionPrincipal;
        Scanner sc= new Scanner(System.in);
        do {
            System.out.println("\n**** INSTITUTO ****\n");
            System.out.println("1. Gestión de alumnos");
            System.out.println("2. Gestión de asignaturas");
            System.out.println("3. Gestión de matrículas");
            System.out.println("4. Ejercicio extra");
            System.out.println("4. Salir");
            opcionPrincipal = sc.nextInt();

            switch (opcionPrincipal){
                case 1 -> {
                    int opcionAlumnos;
                    do {
                        System.out.println("\n**** GESTIÓN DE ALUMNOS ****\n");
                        System.out.println("1. Añadir Alumno");
                        System.out.println("2. Eliminar Alumno");
                        System.out.println("3. Listar Alumnos");
                        System.out.println("4. Salir");
                        opcionAlumnos = sc.nextInt();

                        switch (opcionAlumnos){

                            case 1-> {
                                System.out.println("Nombre del alumno: ");
                                String nombre= new Scanner(System.in).nextLine();
                                System.out.println("Direccion: ");
                                String direccion = new Scanner(System.in).nextLine();
                                System.out.println("Estado de la matrícula: ");
                                String estado = new Scanner(System.in).nextLine();
                                System.out.println("¿Tienes carnet de conducir? Si/No");
                                String respuesta = new Scanner(System.in).nextLine();
                                boolean carnetConducir = false;
                                if (respuesta.equals("Si")){
                                    carnetConducir = true;
                                }

                                Alumno a = new Alumno(nombre, direccion, estado, carnetConducir);
                                controlador.insertarAlumno(a);
                            }
                            case 2-> {
                                System.out.println("Introduce el nombre del alumno a eliminar: ");
                                String nombre = new Scanner(System.in).nextLine();
                                controlador.eliminarAlumno(nombre);
                            }
                            case 3-> obtenerAlumnos(controlador);
                            case 4-> {
                                System.out.println("Volviendo al menú principal...");
                                Thread.sleep(2000);
                            }
                            default -> System.out.println("Opción no válida");
                        }
                    }while (opcionAlumnos != 4);
                }
                case 2 -> {
                    int opcionAsignaturas;
                    do {
                        System.out.println("\n**** GESTIÓN DE ASIGNATURAS ****\n");
                        System.out.println("1. Añadir asignatura");
                        System.out.println("2. Eliminar asignatura");
                        System.out.println("3. Listar asignaturas");
                        System.out.println("4. Obtener nota media en una asignatura");
                        System.out.println("5. Salir");
                        opcionAsignaturas = sc.nextInt();

                        switch (opcionAsignaturas){
                            case 1-> {
                                System.out.println("Nombre de la asignatura: ");
                                String nombre = new Scanner(System.in).nextLine();
                                System.out.println("Curso: ");
                                int curso = new Scanner(System.in).nextInt();
                                Asignatura a = new Asignatura(nombre, curso);
                                controlador.insertarAsignatura(a);
                            }
                            case 2-> {
                                System.out.println("Introduce el nombre de la asignatura a eliminar: ");
                                String nombre = new Scanner(System.in).nextLine();
                                controlador.eliminarAsignatura(nombre);
                            }
                            case 3->obtenerAsignaturas(controlador);
                            case 4->{
                                System.out.println("Asignaturas existentes");
                                obtenerAsignaturas(controlador);
                                System.out.println("Introduce el ID de la asignatura: ");
                                int id = sc.nextInt();

                                System.out.println("La nota media de la asignatura es: " + controlador.notaMediaAsignatura(id));

                            }
                            case 5->{
                                System.out.println("Volviendo al menú principal...");
                                Thread.sleep(2000);
                            }
                        }
                    }while (opcionAsignaturas != 5);
                }
                case 3 -> {
                    int opcionMatriculas;
                    do {
                        System.out.println("\n**** GESTIÓN DE MATRÍCULAS ****\n");
                        System.out.println("1. Insertar matrícula");
                        System.out.println("2. Eliminar matrícula de alumno en asignatura");
                        System.out.println("3. Matrículas de un alumno");
                        System.out.println("4. Matrículas de una asignatura");
                        System.out.println("5. Nota media de un alumno");
                        System.out.println("6. Salir");
                        opcionMatriculas = sc.nextInt();

                        switch (opcionMatriculas){
                            case 1-> {
                                System.out.println("\nAlumnos existentes");
                                obtenerAlumnos(controlador);
                                System.out.println("Introduce el ID del alumno: ");
                                int idAlumno = new Scanner(System.in).nextInt();

                                sc.nextLine(); // ← Lo uso para limpiar el salto de línea

                                System.out.println("\nAsignaturas existentes");
                                obtenerAsignaturas(controlador);
                                System.out.println("Introduce el ID de la asignatura: ");
                                int id = new Scanner(System.in).nextInt();
                                System.out.println("Introduce la nota: ");
                                float nota = new Scanner(System.in).nextFloat();

                                Alumno a = controlador.obtenerAlumnoPorId(idAlumno);
                                Asignatura ag= controlador.obtenerAsignaturaPorId(id);
                                Matricula m = new Matricula(a, ag, nota);
                                controlador.insertarMatricula(m);
                            }
                            case 2-> {
                                System.out.println("Alumnos existentes");
                                obtenerAlumnos(controlador);
                                System.out.println("Introduce el id del alumno: ");
                                int id = new Scanner(System.in).nextInt();
                                System.out.println("Asignaturas existentes");
                                obtenerAsignaturas(controlador);
                                System.out.println("Introduce el ID de la asignatura: ");
                                int idAsig =new Scanner(System.in).nextInt();

                                Alumno alumno = controlador.obtenerAlumnoPorId(id);
                                Asignatura asignatura = controlador.obtenerAsignaturaPorId(idAsig);

                                controlador.eliminarMatricula(alumno.getId(), asignatura.getId());
                            }
                            case 3-> {
                                System.out.println("Alumnos existentes");
                                obtenerAlumnos(controlador);
                                System.out.println("Introduce el id del alumno: ");
                                int id = sc.nextInt();

                                Alumno alumno=controlador.obtenerAlumnoPorId(id);
                                obtenerMatriculasAlumno(controlador, alumno.getId());
                            }
                            case 4-> {
                                System.out.println("Asignaturas existentes");
                                obtenerAsignaturas(controlador);
                                System.out.println("Introduce el ID de la asignatura: ");
                                int id = sc.nextInt();

                                Asignatura asignatura=controlador.obtenerAsignaturaPorId(id);
                                obtenerMatriculasAsignatura(controlador, asignatura.getId());
                            }
                            case 5-> {
                                System.out.println("Matrículas existentes");
                                obtenerMatriculas(controlador);
                                System.out.println("Introduce el id del alumno: ");
                                int id = sc.nextInt();

                                Alumno alumno = controlador.obtenerAlumnoPorId(id);
                                System.out.println("La nota media del alumno es: " + controlador.notaMediaAlumno(alumno.getId()));
                            }
                            case 6-> {
                                System.out.println("Volviendo al menú principal...");
                                Thread.sleep(2000);
                            }
                        }
                    }while (opcionMatriculas != 6);
                }
                case 4 -> {
                    System.out.println("\n**** EJERCICIO EXTRA ****\n");
                    System.out.println("Alumnos existentes");
                    obtenerAlumnos(controlador);
                    System.out.println("Introduce el ID del alumno: ");
                    int id = sc.nextInt();

                    System.out.println("Las notas más baja y alta del alumno son: ");
                    System.out.println(Arrays.toString(controlador.notaExtremoAlumno(id)));
                }
                case 5 -> System.out.println("Saliendo de la aplicación...");
                }
        }while (opcionPrincipal !=4);
    }

    private static void obtenerAlumnos(Controlador controlador) {
        List<Alumno> alumnos= controlador.obtenerAlumno();
        System.out.println(alumnos.toString());
    }

    private static void obtenerAsignaturas(Controlador controlador) {
        List<Asignatura> asignaturas = controlador.obtenerAsignaturas();
        System.out.println(asignaturas.toString());
    }

    private static void obtenerMatriculasAlumno(Controlador controlador, int idAlumno) {
        List<Matricula> matriculas = controlador.selectMatriculasPorAlumno(idAlumno);
        System.out.println(matriculas.toString());
    }

    private static void obtenerMatriculasAsignatura(Controlador controlador, int id) {
        List<Matricula> matriculas = controlador.selectMatriculasPorAsignatura(id);
        System.out.println(matriculas.toString());
    }

    private static void obtenerMatriculas(Controlador controlador) {
        List<Matricula> matriculas= controlador.obtenerMatriculas();
        System.out.println(matriculas.toString());
    }
}
