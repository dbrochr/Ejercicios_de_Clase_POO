import java.util.ArrayList;
import java.util.List;

public class EjercicioComposicion {
    public static void main(String[] args) {
        System.out.println("Sistema de Carreras y Materias");

        Carrera ingSistemas = new Carrera("Ingeniería de Sistemas");

        ingSistemas.agregarMateria("Programación Orientada a Objetos");
        ingSistemas.agregarMateria("Estructura de datos");
        ingSistemas.agregarMateria("Cálculo Diferencial");

        ingSistemas.mostrarMaterias();

        System.out.println("\nEliminando la Carrera");
        ingSistemas = null;         
    }
}

class Carrera {
    private String nombreCarrera;
    private List<Materia> materias;

    public Carrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
        this.materias = new ArrayList<>();
    }

    public void agregarMateria(String nombreMateria) {
        Materia nuevaMateria = new Materia(nombreMateria);
        this.materias.add(nuevaMateria);
    }

    public void mostrarMaterias() {
        System.out.println("Carrera: " + this.nombreCarrera);
        System.out.println("Materias inscritas:");
        for (Materia m : materias) {
            System.out.println(" - " + m.getNombre());
        }
    }

    private class Materia {
        private String nombreMateria;

        private Materia(String nombreMateria) {
            this.nombreMateria = nombreMateria;
        }

        public String getNombre() {
            return nombreMateria;
        }
    }
}