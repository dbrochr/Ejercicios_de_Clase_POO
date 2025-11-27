class Motor {
    void encender() { System.out.println("Motor: Arrancando V8..."); }
    void apagar() { System.out.println("Motor: Apagado."); }
}

class Neumaticos {
    void verificarPresion() { System.out.println("Neumáticos: Presión OK (32 PSI)."); }
}

class Combustible {
    void verificarNivel() { System.out.println("Combustible: Nivel al 85%."); }
}

class Asiento {
    void ajustarPosicion() { System.out.println("Asiento: Ajustando a memoria 'Conductor 1'."); }
}

class Navegador {
    void configurarRuta(String destino) { System.out.println("GPS: Calculando ruta hacia " + destino + "..."); }
}

class SistemaAudio {
    void reproducirListaFavorita() { System.out.println("Audio: Reproduciendo 'Por Que Te vas - Jeanette' en Spotify."); }
    void detener() { System.out.println("Audio: Silenciado."); }
}

class InicioViajeFacade {
    private Motor motor;
    private Neumaticos neumaticos;
    private Combustible combustible;
    private Asiento asiento;
    private Navegador navegador;
    private SistemaAudio audio;

    public InicioViajeFacade() {
        this.motor = new Motor();
        this.neumaticos = new Neumaticos();
        this.combustible = new Combustible();
        this.asiento = new Asiento();
        this.navegador = new Navegador();
        this.audio = new SistemaAudio();
    }

    public void prepararViaje(String destino) {
        System.out.println(">>> Preparando vehículo para ir a: " + destino + " <<<");
        neumaticos.verificarPresion();
        combustible.verificarNivel();
        asiento.ajustarPosicion();
        navegador.configurarRuta(destino);
        motor.encender();
        audio.reproducirListaFavorita();
        System.out.println(">>> ¡Vehículo listo! Disfrute el viaje. <<<\n");
    }

    public void terminarViaje() {
        System.out.println(">>> Finalizando viaje <<<");
        audio.detener();
        motor.apagar();
        System.out.println(">>> Vehículo asegurado. <<<");
    }
}

public class CarroInteligenteFacade {
    public static void main(String[] args) {
        System.out.println("Carro inteligente");

        InicioViajeFacade miCarro = new InicioViajeFacade();

        miCarro.prepararViaje("Oficina Central");

        miCarro.terminarViaje();
    }
}