import java.util.ArrayList;
import java.util.Scanner;

class Libro {
    String titulo;
    String autor;
    boolean disponibilidad;

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponibilidad = true;
    }

    public void prestar() {
        if (disponibilidad) {
            disponibilidad = false;
            System.out.println("El libro ha sido prestado.");
        } else {
            System.out.println("El libro ya está prestado. No puede prestarse nuevamente.");
        }
    }

    public void devolver() {
        if (!disponibilidad) {
            disponibilidad = true;
            System.out.println("El libro ha sido devuelto y ahora está disponible.");
        } else {
            System.out.println("El libro ya estaba disponible.");
        }
    }
}

public class Biblioteca {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ArrayList<Libro> libros = new ArrayList<>();
            libros.add(new Libro("Cien años de soledad", "Gabriel Garcia Marquez"));
            libros.add(new Libro("El viejo y el mar", "Ernest Hemingway"));
            libros.add(new Libro("1984", "George Orwell"));
            
            int opcion;
            
            do {
                System.out.println("\nBienvenido al programa de gestión de biblioteca, para salir, introduzca '9'");
                System.out.println("\nMENÚ PRINCIPAL");
                System.out.println("1. Agregar libro");
                System.out.println("2. Mostrar libros");
                System.out.print("Elige una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();
                
                switch (opcion) {
                    case 1 -> {
                        System.out.print("Ingrese el título del libro: ");
                        String titulo = scanner.nextLine();
                        System.out.print("Ingrese el autor del libro: ");
                        String autor = scanner.nextLine();
                        
                        libros.add(new Libro(titulo, autor));
                        System.out.println("Libro agregado correctamente.");
                    }
                        
                    case 2 -> {
                        System.out.println("\nLISTA DE LIBROS");
                        
                        for (int i = 0; i < libros.size(); i++) {
                            Libro l = libros.get(i);
                            
                            String estado;
                            if (l.disponibilidad) {
                                estado = "DISPONIBLE";
                            } else {
                                estado = "PRESTADO";
                            }
                            
                            System.out.println((i + 1) + ". " + l.titulo +
                                    ", Autor: " + l.autor +
                                    " (" + estado + ")");
                        }
                        
                        System.out.println("\n¿Qué desea hacer?");
                        System.out.println("1. Prestar un libro");
                        System.out.println("2. Devolver un libro");
                        System.out.print("Opción: ");
                        
                        int accion = scanner.nextInt();
                        
                        switch (accion) {
                            case 1 ->                             {
                                System.out.print("Ingrese el número del libro que desea prestar: ");
                                int num = scanner.nextInt();
                                if (num < 1 || num > libros.size()) {
                                    System.out.println("Selección inválida.");
                                } else {
                                    Libro libro = libros.get(num - 1);
                                    
                                    if (libro.disponibilidad) {
                                        libro.prestar();
                                    } else {
                                        System.out.println("Ese libro NO está disponible para préstamo.");
                                    }
                                }                              }
                            case 2 ->                             {
                                System.out.print("Ingrese el número del libro que desea devolver: ");
                                int num = scanner.nextInt();
                                if (num < 1 || num > libros.size()) {
                                    System.out.println("Selección inválida.");
                                } else {
                                    Libro libro = libros.get(num - 1);
                                    
                                    if (!libro.disponibilidad) {
                                        libro.devolver();
                                    } else {
                                        System.out.println("Ese libro ya está disponible, no se puede devolver.");
                                    }
                                }                              }
                            default -> System.out.println("Opción inválida.");
                        }
                    }
                        
                        
                    default -> {
                        if (opcion != 9){
                            System.out.println("Opción inválida.");}
                    }
                }
                
            } while (opcion != 9);
        }
    }
}
