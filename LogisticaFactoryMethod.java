interface Transporte {
    void entregar();
}

class Camion implements Transporte {
    @Override
    public void entregar() {
        System.out.println("Entrega por carretera en una caja: Camión.");
    }
}

class Barco implements Transporte {
    @Override
    public void entregar() {
        System.out.println("Entrega por mar en un contenedor: Barco.");
    }
}

class Avion implements Transporte {
    @Override
    public void entregar() {
        System.out.println("Entrega aérea urgente: Avión.");
    }
}

abstract class Logistica {
    public void planificarEntrega() {
        Transporte t = crearTransporte(); 
        t.entregar();
    }

    protected abstract Transporte crearTransporte();
}

class LogisticaTerrestre extends Logistica {
    @Override
    protected Transporte crearTransporte() {
        return new Camion();
    }
}

class LogisticaMaritima extends Logistica {
    @Override
    protected Transporte crearTransporte() {
        return new Barco();
    }
}

class LogisticaAerea extends Logistica {
    @Override
    protected Transporte crearTransporte() {
        return new Avion();
    }
}

public class LogisticaFactoryMethod {
    public static void main(String[] args) {
        System.out.println("LOGÍSTICA DE ENVIO\n");

        Logistica logistica;

        System.out.println("-Caso 1: Envío local");
        logistica = new LogisticaTerrestre();
        logistica.planificarEntrega();

        System.out.println("\n-Caso 2: Envío internacional masivo");
        logistica = new LogisticaMaritima();
        logistica.planificarEntrega();

        System.out.println("\n-Caso 3: Envío urgente");
        logistica = new LogisticaAerea();
        logistica.planificarEntrega();
    }
}