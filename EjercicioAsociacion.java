class Juego {
    private String titulo;

    public Juego(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }
}

class Jugador {
    private String nombre;
    private Juego juego;

    public Jugador(String nombre, Juego juego) {
        this.nombre = nombre;
        this.juego = juego;
    }

    public void mostrarInformacion() {
        System.out.println("Jugador: " + this.nombre + 
                           " | Está jugando a: " + this.juego.getTitulo());
    }
}

public class EjercicioAsociacion {
    public static void main(String[] args) {
        System.out.println("--- Sistema de Jugadores y Juegos ---");

        Juego miJuego = new Juego("Super Mario Bros");

        Jugador jugador1 = new Jugador("Luis", miJuego);
        Jugador jugador2 = new Jugador("Ana", miJuego);

        jugador1.mostrarInformacion();
        jugador2.mostrarInformacion();
    }
}