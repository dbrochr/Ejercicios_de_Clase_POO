import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EjercicioListas {
    public static void main(String[] args) {
        
        System.out.println("Prueba ARRAYLIST:");
        List<String> listaEstudiantes = new ArrayList<>();
        gestionarLista(listaEstudiantes);

        System.out.println("\nPrueba LinkedList:");
        List<String> listaEnlazada = new LinkedList<>();      
        gestionarLista(listaEnlazada);
    }

    public static void gestionarLista(List<String> lista) {
        lista.add("Ana");
        lista.add("Carlos");
        lista.add("Elena");
        lista.add("Daniel");
        lista.add("Beatriz");

        System.out.println("Lista original: " + lista);
        int mitad = lista.size() / 2;
        String eliminado = lista.remove(mitad);
        System.out.println("Se eliminó a: " + eliminado);
        System.out.println("Lista resultante: " + lista);
    }
}