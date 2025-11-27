//import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Concurso {
    public static void main(String[] args) {
        
        System.out.println("Bienvenido al programa de Inscripcion para el  consurso");

        // Set<String> estudiantes = new HashSet<>();
        
        Set<String> estudiantes = new TreeSet<>();

        System.out.println("Estudiantes Inscritos: \n 'Zoe', 'Ana', 'Carlos', 'Ana', 'Beatriz', 'Carlos'");

        estudiantes.add("Zoe");
        estudiantes.add("Ana");
        estudiantes.add("Carlos");
        estudiantes.add("Ana");
        estudiantes.add("Beatriz"); 
        estudiantes.add("Carlos");

        System.out.println("\nLista Final de Inscritos");
        
        for (String nombre : estudiantes) {
            System.out.println("- " + nombre);
        }

        String busqueda = "Carlos";
        System.out.println("\n--- Verificación ---");
        
        if (estudiantes.contains(busqueda)) {
            System.out.println("El estudiante '" + busqueda + "' está inscrito correctamente.");
        } else {
            System.out.println("El estudiante '" + busqueda + "' no se encuentra inscrito.");
        }
    }
}