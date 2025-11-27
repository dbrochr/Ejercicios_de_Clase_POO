import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Usuario {
    private String nombre;
    private String correo;

    public Usuario(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getFormatoCSV() {
        return nombre + "," + correo;
    }
}

public class GestionUsuarios {

    private static final String ARCHIVO_CSV = "usuarios.csv";

    public static void main(String[] args) {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Juan Perez", "david@unimagdalena.edu.co"));
        usuarios.add(new Usuario("Maria Gomez", "polo@gmail.com"));
        usuarios.add(new Usuario("Carlos Ruiz", "josé@yahoo.com"));

        System.out.println("Guardando usuarios en fichero CSV");
        guardarUsuariosEnCSV(usuarios);

        System.out.println("\nLeyendo usuarios del fichero CSV");
        leerUsuariosDeCSV();
    }

    public static void guardarUsuariosEnCSV(List<Usuario> listaUsuarios) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_CSV))) {
            
            writer.write("Nombre,Correo");
            writer.newLine();

            for (Usuario u : listaUsuarios) {
                writer.write(u.getFormatoCSV());
                writer.newLine();
            }
            System.out.println("Datos guardados exitosamente en " + ARCHIVO_CSV);

        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }

    public static void leerUsuariosDeCSV() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO_CSV))) {
            String linea;
            System.out.println("Contenido del archivo:");
            
            while ((linea = reader.readLine()) != null) {
                System.out.println("Linea leída: " + linea);
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}