interface Procesador { String getDetalle(); }
interface Grafica { String getDetalle(); }
interface DiscoDuro { String getDetalle(); }
interface RAM { String getDetalle(); }
interface SistemaOperativo { String getDetalle(); }

class Inteli7 implements Procesador { public String getDetalle() { return "Intel Core i7"; } }
class NvidiaRTX implements Grafica { public String getDetalle() { return "Nvidia RTX 3080"; } }
class SSD1TB implements DiscoDuro { public String getDetalle() { return "SSD 1TB NVMe"; } }
class RAM16GB implements RAM { public String getDetalle() { return "16GB DDR4"; } }
class Windows11 implements SistemaOperativo { public String getDetalle() { return "Windows 11 Pro"; } }

class AMDZen3 implements Procesador { public String getDetalle() { return "AMD Ryzen 9 (Zen 3)"; } }
class RadeonRX implements Grafica { public String getDetalle() { return "AMD Radeon RX 6800"; } }
class HDD2TB implements DiscoDuro { public String getDetalle() { return "HDD 2TB Mecánico"; } }
class RAM32GB implements RAM { public String getDetalle() { return "32GB DDR5"; } }
class UbuntuLinux implements SistemaOperativo { public String getDetalle() { return "Ubuntu Linux 22.04"; } }

interface FabricaComponentes {
    Procesador crearProcesador();
    Grafica crearGrafica();
    DiscoDuro crearDisco();
    RAM crearRAM();
    SistemaOperativo crearOS();
}

class FabricaComputadoraCanada implements FabricaComponentes {
    public Procesador crearProcesador() { return new Inteli7(); }
    public Grafica crearGrafica() { return new NvidiaRTX(); }
    public DiscoDuro crearDisco() { return new SSD1TB(); }
    public RAM crearRAM() { return new RAM16GB(); }
    public SistemaOperativo crearOS() { return new Windows11(); }
}

class FabricaComputadoraJapon implements FabricaComponentes {
    public Procesador crearProcesador() { return new AMDZen3(); }
    public Grafica crearGrafica() { return new RadeonRX(); }
    public DiscoDuro crearDisco() { return new HDD2TB(); }
    public RAM crearRAM() { return new RAM32GB(); }
    public SistemaOperativo crearOS() { return new UbuntuLinux(); }
}

abstract class Computadora {
    String nombre;
    Procesador procesador;
    Grafica grafica;
    DiscoDuro disco;
    RAM ram;
    SistemaOperativo sistema;

    abstract void ensamblar();

    void probar() {
        System.out.println("Probando componentes de " + nombre + ":");
        System.out.println(" - CPU: " + procesador.getDetalle());
        System.out.println(" - GPU: " + grafica.getDetalle());
        System.out.println(" - OS: " + sistema.getDetalle());
    }

    void embalar() {
        System.out.println("Embalando " + nombre + " para envío...\n");
    }
}

class ComputadoraGamer extends Computadora {
    FabricaComponentes fabrica;

    public ComputadoraGamer(FabricaComponentes fabrica) {
        this.fabrica = fabrica;
    }

    @Override
    void ensamblar() {
        System.out.println("Ensamblando " + nombre + "...");
        procesador = fabrica.crearProcesador();
        grafica = fabrica.crearGrafica();
        disco = fabrica.crearDisco();
        ram = fabrica.crearRAM();
        sistema = fabrica.crearOS();
    }
}

abstract class Ensambladora {
    protected abstract Computadora crearComputadora(String tipo);

    public Computadora ordenarComputadora(String tipo) {
        Computadora pc = crearComputadora(tipo);
        pc.ensamblar();
        pc.probar();
        pc.embalar();
        return pc;
    }
}

class EnsambladoraCanada extends Ensambladora {
    @Override
    protected Computadora crearComputadora(String tipo) {
        Computadora pc = null;
        FabricaComponentes fabricaCanada = new FabricaComputadoraCanada();

        if (tipo.equals("gamer")) {
            pc = new ComputadoraGamer(fabricaCanada);
            pc.nombre = "PC  (Specificaciones canada)";
        }
        return pc;
    }
}

class EnsambladoraJapon extends Ensambladora {
    @Override
    protected Computadora crearComputadora(String tipo) {
        Computadora pc = null;
        FabricaComponentes fabricaJapon = new FabricaComputadoraJapon();

        if (tipo.equals("gamer")) {
            pc = new ComputadoraGamer(fabricaJapon);
            pc.nombre = "PC Gamer (Specificaciones Japón)";
        }
        return pc;
    }
}

public class AbstractFactory {
    public static void main(String[] args) {
        System.out.println("Caraxteristicas de PC's\n");

        Ensambladora tiendaCanada = new EnsambladoraCanada();
        Ensambladora tiendaJapon = new EnsambladoraJapon();


        tiendaCanada.ordenarComputadora("gamer");

        tiendaJapon.ordenarComputadora("gamer");
    }
}