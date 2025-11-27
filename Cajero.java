import java.util.Scanner;

class FondosInsuficientesExcepcion extends Exception {
    public FondosInsuficientesExcepcion(String mensaje) {
        super(mensaje);
    }
}

public class Cajero {
    private double saldo;

    public Cajero() {
        this.saldo = 100000;
    }

    public void consultarSaldo() {
        System.out.println("Su saldo actual es: $" + saldo);
    }

    public void retirar(double monto) throws FondosInsuficientesExcepcion {
        if (monto > saldo) {
            throw new FondosInsuficientesExcepcion("Error: Fondos insuficientes para realizar el retiro de $" + monto);
        }
        if (monto <= 0) {
            System.out.println("El monto a retirar debe ser positivo.");
            return;
        }
        saldo -= monto;
        System.out.println("Retiro exitoso: $" + monto);
        consultarSaldo();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cajero miCajero = new Cajero();
        
        System.out.println("Bienvenido a la red de cajeros de Ban-Locombia");
        miCajero.consultarSaldo();

        try {
            System.out.print("Ingrese monto a retirar: ");
            double monto = Double.parseDouble(scanner.nextLine());
            
            miCajero.retirar(monto);

        } catch (FondosInsuficientesExcepcion e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: Ingrese un valor numérico válido.");
        } finally {
            System.out.println("Gracias por usar el cajero.");
            scanner.close();
        }
    }
}