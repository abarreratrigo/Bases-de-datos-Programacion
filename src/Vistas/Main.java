package Vistas;

import BBDD.Alumno;
import Controlador.Controlador;

import java.util.List;
import java.util.Scanner;

//Implementamos como si fuera una vista de UI
public class Main {
    public static void main(String[] args) {
        Controlador controlador= new Controlador();

        int opcion;
        Scanner sc= new Scanner(System.in);
        do {
            System.out.println("**** MENÚ DE LA APLICACIÓN ****");
            System.out.println("1. Listar por orden alfabético");
            System.out.println("2. Nuevo alumno");
            System.out.println("3. Eliminar alumno");
            System.out.println("0. Salir");
            opcion = sc.nextInt();

            switch (opcion){
                case 1 -> obtenerAlumnos(controlador);
                case 2 -> {
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
                    anadirAlumno(controlador, a);
                }
                case 3 -> {
                    System.out.println("Introduce el nombre del alumno a eliminar: ");
                    String nombre = new Scanner(System.in).nextLine();
                    eliminarAlumno(controlador,nombre);
                }
            }
        }while (opcion!=0);
    }

    private static void obtenerAlumnos(Controlador controlador) {
        List<Alumno> alumnos= controlador.obtenerAlumno();
        System.out.println(alumnos.toString());
    }

    public static void anadirAlumno(Controlador controlador, Alumno a){
         controlador.insertarAlumno(a);
    }

    private static void eliminarAlumno(Controlador controlador, String nombre){
        controlador.eliminarAlumno(nombre);
    }
}
