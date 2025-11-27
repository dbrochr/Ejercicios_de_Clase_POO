import java.util.Scanner;

class DividirEntreCeroException extends Exception {
    public DividirEntreCeroException(String mensaje) {
        super(mensaje);
    }
}

public class CalculadoraSeguro {

    public static double dividir(double numerador, double denominador) throws DividirEntreCeroException {
        if (denominador == 0) {
            throw new DividirEntreCeroException("Error: No se puede dividir por cero.");
        }
        return numerador / denominador;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Calculasahdfgdora Seguro");

        try {
            System.out.print("Ingrese el numerador: ");
            String entradaNum = scanner.nextLine();
            double numerador = Double.parseDouble(entradaNum);

            System.out.print("Ingrese el denominador: ");
            String entradaDen = scanner.nextLine();
            double denominador = Double.parseDouble(entradaDen);

            double resultado = dividir(numerador, denominador);
            System.out.println("Resultado: " + resultado);

        } catch (DividirEntreCeroException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: Por favor ingrese solo valores numéricos.");
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        } finally {
            System.out.println("Operación finalizada.");
            scanner.close();
        }
    }
}