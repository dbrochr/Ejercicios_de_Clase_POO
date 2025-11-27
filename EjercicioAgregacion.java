import java.util.ArrayList;
import java.util.List;

class Estudiante {
    private String nombre;

    public Estudiante(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}

class Curso {
    private String nombreCurso;
    private List<Estudiante> estudiantes;

    public Curso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
        this.estudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public void mostrarEstudiantes() {
        System.out.println("Estudiantes en el curso de " + nombreCurso);
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes inscritos.");
        } else {
            for (Estudiante e : estudiantes) {
                System.out.println("- " + e.getNombre());
            }
        }
    }
}

public class EjercicioAgregacion {
    public static void main(String[] args) {
        
        Estudiante e1 = new Estudiante("Polo");
        Estudiante e2 = new Estudiante("José");

        Curso cursoJava = new Curso("Programación Orientada a Objetos");

        cursoJava.agregarEstudiante(e1);
        cursoJava.agregarEstudiante(e2);

        cursoJava.mostrarEstudiantes();

        System.out.println("\nEliminando el curso ...");
        cursoJava = null;

        System.out.println("El curso ha sido eliminado, pero el estudiante sigue aquí: " + e1.getNombre());
    }
}