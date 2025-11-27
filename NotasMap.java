import java.util.HashMap;
import java.util.Map;
//import java.util.TreeMap;

public class NotasMap {
    public static void main(String[] args) {
        
        System.out.println("Sistema de Notas con Map");
        Map<Integer, Double> notas = new HashMap<>();
        System.out.println("Insertando datos...");
        notas.put(103, 3.5);
        notas.put(101, 4.8);
        notas.put(105, 2.1);
        notas.put(102, 3.9);

        System.out.println("\nListado de Notas:");
        for (Map.Entry<Integer, Double> entrada : notas.entrySet()) {
            System.out.println("ID del Estudiante: " + entrada.getKey() + " = Nota: " + entrada.getValue());
        }

        System.out.println("\nActualizando la nota del estudiante con ID:105...");
        notas.put(105, 5.0);
        System.out.println("Nueva nota del 105: " + notas.get(105));
        int idBuscar = 101;
        System.out.println("\nValidación");
        
        if (notas.containsKey(idBuscar)) {
            System.out.println("El ID " + idBuscar + " existe en la base de datos.");
        } else {
            System.out.println("El ID " + idBuscar + " NO existe.");
        }
    }
}