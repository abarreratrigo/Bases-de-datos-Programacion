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
    // Códigos ANSI para colores
    static final String ANSI_RESET = "\u001B[0m";
    static final String ANSI_BLUE = "\u001B[34m";
    static final String ANSI_GREEN = "\u001B[32m";
    static final String ANSI_RED = "\u001B[31m";
    static final String ANSI_WHITE = "\u001B[37m";
    public static final String ALUMNOS_EXISTENTES_BOX =
            "┌───────────────────────────┐\n" +
                    "│ Alumnos existentes:       │\n" +
                    "└───────────────────────────┘";
    public static final String ASIGNATURAS_EXISTENTES_BOX =
            "┌───────────────────────────┐\n" +
                    "│ Asignaturas existentes:   │\n" +
                    "└───────────────────────────┘";


    public static void main(String[] args) throws InterruptedException{
        Controlador controlador= new Controlador();

        int opcionPrincipal;
        Scanner sc= new Scanner(System.in);
        do {
            System.out.println("\n" + ANSI_WHITE + "╔════════════════════════════════════╗" + ANSI_RESET);
            System.out.println(ANSI_WHITE + "║" + ANSI_BLUE + "             INSTITUTO              " + ANSI_WHITE + "║" + ANSI_RESET);
            System.out.println(ANSI_WHITE + "╠════════════════════════════════════╣" + ANSI_RESET);
            System.out.println(ANSI_WHITE + "║ " + ANSI_GREEN + "1.  Gestión de alumnos             " + ANSI_WHITE + "║" + ANSI_RESET);
            System.out.println(ANSI_WHITE + "║ " + ANSI_GREEN + "2.  Gestión de asignaturas         " + ANSI_WHITE + "║" + ANSI_RESET);
            System.out.println(ANSI_WHITE + "║ " + ANSI_GREEN + "3.  Gestión de matrículas          " + ANSI_WHITE + "║" + ANSI_RESET);
            System.out.println(ANSI_WHITE + "║ " + ANSI_GREEN + "4.  Ejercicio extra                " + ANSI_WHITE + "║" + ANSI_RESET);
            System.out.println(ANSI_WHITE + "║ " + ANSI_RED + "5.  Salir                          " + ANSI_WHITE + "║" + ANSI_RESET);
            System.out.println(ANSI_WHITE + "╚════════════════════════════════════╝" + ANSI_RESET);
            System.out.print(ANSI_WHITE + "Seleccione una opción: " + ANSI_RESET);

            opcionPrincipal = sc.nextInt();

            switch (opcionPrincipal){
                case 1 -> {
                    int opcionAlumnos;
                    do {
                        System.out.println("\n" + ANSI_WHITE + "╔══════════════════════════╗" + ANSI_RESET);
                        System.out.println(ANSI_WHITE + "║" + ANSI_BLUE + "    GESTIÓN DE ALUMNOS    " + ANSI_WHITE + "║" + ANSI_RESET);
                        System.out.println(ANSI_WHITE + "╠══════════════════════════╣" + ANSI_RESET);
                        System.out.println(ANSI_WHITE + "║ " + ANSI_GREEN + "1. Añadir Alumno         " + ANSI_WHITE + "║" + ANSI_RESET);
                        System.out.println(ANSI_WHITE + "║ " + ANSI_GREEN + "2. Eliminar Alumno       " + ANSI_WHITE + "║" + ANSI_RESET);
                        System.out.println(ANSI_WHITE + "║ " + ANSI_GREEN + "3. Listar Alumnos        " + ANSI_WHITE + "║" + ANSI_RESET);
                        System.out.println(ANSI_WHITE + "║ " + ANSI_RED + "4. Salir                 " + ANSI_WHITE + "║" + ANSI_RESET);
                        System.out.println(ANSI_WHITE + "╚══════════════════════════╝" + ANSI_RESET);
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
                                if (respuesta.trim().equalsIgnoreCase("Si")) {
                                    carnetConducir = true;
                                }

                                Alumno a = new Alumno(nombre, direccion, estado, carnetConducir);
                                controlador.insertarAlumno(a);
                            }
                            case 2-> {
                                System.out.println(ALUMNOS_EXISTENTES_BOX);
                                obtenerAlumnos(controlador);
                                System.out.println("Introduce el ID del alumno a eliminar: ");
                                int id = new Scanner(System.in).nextInt();
                                controlador.eliminarAlumno(id);
                            }
                            case 3-> obtenerAlumnos(controlador);
                            case 4-> {
                                System.out.println("Volviendo al menú principal...");
                                Thread.sleep(2000);
                            }
                            default -> System.out.println("Opción no válida, vuelve a intentarlo.");
                        }
                    }while (opcionAlumnos != 4);
                }
                case 2 -> {
                    int opcionAsignaturas;
                    do {
                        System.out.println("\n" + ANSI_WHITE + "╔══════════════════════════════════╗" + ANSI_RESET);
                        System.out.println(ANSI_WHITE + "║" + ANSI_BLUE + "       GESTIÓN DE ASIGNATURAS     " + ANSI_WHITE + "║" + ANSI_RESET);
                        System.out.println(ANSI_WHITE + "╠══════════════════════════════════╣" + ANSI_RESET);
                        System.out.println(ANSI_WHITE + "║ " + ANSI_GREEN + "1. Añadir asignatura             " + ANSI_WHITE + "║" + ANSI_RESET);
                        System.out.println(ANSI_WHITE + "║ " + ANSI_GREEN + "2. Eliminar asignatura           " + ANSI_WHITE + "║" + ANSI_RESET);
                        System.out.println(ANSI_WHITE + "║ " + ANSI_GREEN + "3. Listar asignaturas            " + ANSI_WHITE + "║" + ANSI_RESET);
                        System.out.println(ANSI_WHITE + "║ " + ANSI_GREEN + "4. Nota media por asignatura     " + ANSI_WHITE + "║" + ANSI_RESET);
                        System.out.println(ANSI_WHITE + "║ " + ANSI_RED + "5. Salir                         " + ANSI_WHITE + "║" + ANSI_RESET);
                        System.out.println(ANSI_WHITE + "╚══════════════════════════════════╝" + ANSI_RESET);

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
                                System.out.println(ASIGNATURAS_EXISTENTES_BOX);
                                obtenerAsignaturas(controlador);
                                System.out.println("Introduce el nombre de la asignatura a eliminar: ");
                                String nombre = new Scanner(System.in).nextLine();
                                controlador.eliminarAsignatura(nombre);
                            }
                            case 3->obtenerAsignaturas(controlador);
                            case 4-> {
                                System.out.println(ASIGNATURAS_EXISTENTES_BOX);
                                obtenerAsignaturas(controlador);
                                System.out.println("Introduce el ID de la asignatura: ");
                                int id = sc.nextInt();

                                System.out.println("La nota media de la asignatura es: " + controlador.notaMediaAsignatura(id));

                            }
                            case 5-> {
                                System.out.println("Volviendo al menú principal...");
                                Thread.sleep(2000);
                            }
                            default -> System.out.println("Opción no válida, vuelve a intentarlo.");
                        }
                    }while (opcionAsignaturas != 5);
                }
                case 3 -> {
                    int opcionMatriculas;
                    do {
                        System.out.println("\n" + ANSI_WHITE + "╔════════════════════════════════════════════════════════╗" + ANSI_RESET);
                        System.out.println(ANSI_WHITE + "║" + ANSI_BLUE + "                GESTIÓN DE MATRÍCULAS                   " + ANSI_WHITE + "║" + ANSI_RESET);
                        System.out.println(ANSI_WHITE + "╠════════════════════════════════════════════════════════╣" + ANSI_RESET);
                        System.out.println(ANSI_WHITE + "║ " + ANSI_GREEN + "1. Insertar matrícula                                  " + ANSI_WHITE + "║" + ANSI_RESET);
                        System.out.println(ANSI_WHITE + "║ " + ANSI_GREEN + "2. Eliminar matrícula de alumno en asignatura          " + ANSI_WHITE + "║" + ANSI_RESET);
                        System.out.println(ANSI_WHITE + "║ " + ANSI_GREEN + "3. Matrículas de un alumno                             " + ANSI_WHITE + "║" + ANSI_RESET);
                        System.out.println(ANSI_WHITE + "║ " + ANSI_GREEN + "4. Matrículas de una asignatura                        " + ANSI_WHITE + "║" + ANSI_RESET);
                        System.out.println(ANSI_WHITE + "║ " + ANSI_GREEN + "5. Nota media de un alumno                             " + ANSI_WHITE + "║" + ANSI_RESET);
                        System.out.println(ANSI_WHITE + "║ " + ANSI_RED + "6. Salir                                               " + ANSI_WHITE + "║" + ANSI_RESET);
                        System.out.println(ANSI_WHITE + "╚════════════════════════════════════════════════════════╝" + ANSI_RESET);
                        opcionMatriculas = sc.nextInt();

                        switch (opcionMatriculas){
                            case 1-> {
                                System.out.println(ALUMNOS_EXISTENTES_BOX);
                                obtenerAlumnos(controlador);
                                System.out.println("Introduce el ID del alumno: ");
                                int idAlumno = new Scanner(System.in).nextInt();

                                sc.nextLine(); // ← Lo uso para limpiar el salto de línea

                                System.out.println(ASIGNATURAS_EXISTENTES_BOX);
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
                                System.out.println(ALUMNOS_EXISTENTES_BOX);
                                obtenerAlumnos(controlador);
                                System.out.println("Introduce el id del alumno: ");
                                int id = new Scanner(System.in).nextInt();
                                System.out.println(ASIGNATURAS_EXISTENTES_BOX);
                                obtenerAsignaturas(controlador);
                                System.out.println("Introduce el ID de la asignatura: ");
                                int idAsig =new Scanner(System.in).nextInt();

                                Alumno alumno = controlador.obtenerAlumnoPorId(id);
                                Asignatura asignatura = controlador.obtenerAsignaturaPorId(idAsig);

                                controlador.eliminarMatricula(alumno.getId(), asignatura.getId());
                            }
                            case 3-> {
                                System.out.println(ALUMNOS_EXISTENTES_BOX);
                                obtenerAlumnos(controlador);
                                System.out.println("Introduce el id del alumno: ");
                                int id = sc.nextInt();

                                Alumno alumno=controlador.obtenerAlumnoPorId(id);
                                obtenerMatriculasAlumno(controlador, alumno.getId());
                            }
                            case 4-> {
                                System.out.println(ASIGNATURAS_EXISTENTES_BOX);
                                obtenerAsignaturas(controlador);
                                System.out.println("Introduce el ID de la asignatura: ");
                                int id = sc.nextInt();

                                Asignatura asignatura=controlador.obtenerAsignaturaPorId(id);
                                obtenerMatriculasAsignatura(controlador, asignatura.getId());
                            }
                            case 5-> {
                                System.out.println(ALUMNOS_EXISTENTES_BOX);
                                obtenerAlumnos(controlador);
                                System.out.println("Introduce el id del alumno: ");
                                int id = sc.nextInt();

                                Alumno alumno = controlador.obtenerAlumnoPorId(id);
                                System.out.println("La nota media del alumno es: " + controlador.notaMediaAlumno(alumno.getId()));
                            }
                            case 6-> {
                                System.out.println("Volviendo al menú principal...");
                                Thread.sleep(2000);
                            }
                            default -> System.out.println("Opción no válida, vuelve a intentarlo.");
                        }
                    }while (opcionMatriculas != 6);
                }
                case 4 -> {
                    System.out.println("\n" + ANSI_WHITE + "╔════════════════════════════════════╗" + ANSI_RESET);
                    System.out.println(ANSI_BLUE + "           EJERCICIO EXTRA              " + ANSI_RESET);
                    System.out.println(ANSI_WHITE + "╚════════════════════════════════════╝" + ANSI_RESET +"\n");
                    System.out.println(ALUMNOS_EXISTENTES_BOX);
                    obtenerAlumnos(controlador);
                    System.out.println("Introduce el ID del alumno: ");
                    int id = sc.nextInt();

                    System.out.println("Las notas más baja y alta del alumno son: ");
                    System.out.println(Arrays.toString(controlador.notaExtremoAlumno(id)));
                }
                case 5 -> {
                    System.out.println("Saliendo de la aplicación...");
                    Thread.sleep(2000);
                }
                default -> System.out.println("Opción no válida, vuelve a intentarlo.");
                }
        }while (opcionPrincipal !=5);
    }

    private static void obtenerAlumnos(Controlador controlador) {
        List<Alumno> alumnos= controlador.obtenerAlumno();
        System.out.printf("%-5s %-20s %-30s %-15s %-10s%n",
                "ID", "Nombre", "Dirección", "Estado", "Carnet");
        System.out.println("----------------------------------------------------------------------------------");
        for (Alumno a : alumnos) {
            System.out.println(a);
        }

    }

    private static void obtenerAsignaturas(Controlador controlador) {
        List<Asignatura> asignaturas = controlador.obtenerAsignaturas();
        System.out.printf("%-5s %-25s %-10s%n",
                "ID", "Nombre", "Curso");
        System.out.println("-----------------------------------------");
        for (Asignatura a : asignaturas) {
            System.out.println(a);
        }

    }

    private static void obtenerMatriculasAlumno(Controlador controlador, int idAlumno) {
        List<Matricula> matriculas = controlador.selectMatriculasPorAlumno(idAlumno);
        System.out.printf("%-5s %-10s %-20s %-25s %-5s%n",
                "ID", "AlumnoID", "Nombre Alumno", "Asignatura", "Nota");
        System.out.println("--------------------------------------------------------------------------");
        for (Matricula m : matriculas) {
            System.out.println(m);
        }
    }

    private static void obtenerMatriculasAsignatura(Controlador controlador, int id) {
        List<Matricula> matriculas = controlador.selectMatriculasPorAsignatura(id);
        System.out.printf("%-5s %-10s %-20s %-25s %-5s%n",
                "ID", "AlumnoID", "Nombre Alumno", "Asignatura", "Nota");
        System.out.println("--------------------------------------------------------------------------");
        for (Matricula m : matriculas) {
            System.out.println(m);
        }
    }

    private static void obtenerMatriculas(Controlador controlador) {
        List<Matricula> matriculas= controlador.obtenerMatriculas();
        System.out.printf("%-5s %-10s %-20s %-25s %-5s%n",
                "ID", "AlumnoID", "Nombre Alumno", "Asignatura", "Nota");
        System.out.println("--------------------------------------------------------------------------");
        for (Matricula m : matriculas) {
            System.out.println(m);
        }
    }
}
