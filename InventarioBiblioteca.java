import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Libro implements Serializable {
    private static final long serialVersionUID = 1L;

    private String titulo;
    private String autor;
    private int anio;
    
    private transient int cantidadCopias; 

    public Libro(String titulo, String autor, int anio, int cantidadCopias) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.cantidadCopias = cantidadCopias;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + 
               " | Autor: " + autor + 
               " | Año: " + anio + 
               " | Copias: " + cantidadCopias;
    }
}

public class InventarioBiblioteca {

    private static final String NOMBRE_ARCHIVO = "libros.ser";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 3) {
            System.out.println("\n- Programa de gestión de biblioteca:");
            System.out.println("1. Agregar Libro");
            System.out.println("2. Consultar Libros");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opción inválida.");
                continue;
            }

            switch (opcion) {
                case 1:
                    agregarLibro(scanner);
                    break;
                case 2:
                    consultarLibros();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no reconocida.");
            }
        }
    }

    @SuppressWarnings("unchecked")
    private static void agregarLibro(Scanner scanner) {
        System.out.print("Ingrese Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Ingrese Año: ");
        int anio = Integer.parseInt(scanner.nextLine());
        System.out.print("Ingrese Cantidad de Copias: ");
        int copias = Integer.parseInt(scanner.nextLine());

        Libro nuevoLibro = new Libro(titulo, autor, anio, copias);
        List<Libro> listaLibros = new ArrayList<>();

        File archivo = new File(NOMBRE_ARCHIVO);
        if (archivo.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
                listaLibros = (List<Libro>) ois.readObject();
            } catch (Exception e) {
                System.out.println("Nota: Creando nuevo archivo de inventario.");
            }
        }

        listaLibros.add(nuevoLibro);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(NOMBRE_ARCHIVO))) {
            oos.writeObject(listaLibros);
            System.out.println("Libro guardado correctamente en " + NOMBRE_ARCHIVO);
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private static void consultarLibros() {
        File archivo = new File(NOMBRE_ARCHIVO);
        if (!archivo.exists()) {
            System.out.println("No hay libros registrados aún.");
            return;
        }

        System.out.println("\n booklst");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            List<Libro> librosRecuperados = (List<Libro>) ois.readObject();
            
            for (Libro libro : librosRecuperados) {
                System.out.println(libro);
            }
            System.out.println("Nota: Observe que 'Copias' es 0 porque el atributo es 'transient'.");

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}