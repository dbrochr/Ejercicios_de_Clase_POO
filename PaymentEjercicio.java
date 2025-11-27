interface Payment {
    void processPayment(double amount);
}

class CreditCard implements Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Procesando pago de $" + amount + " con Tarjeta de Crédito. \n -Verificando fondos...");
    }
}

class PayPal implements Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Procesando pago de $" + amount + " vía PayPal \n -Redirigiendo a login...");
    }
}

public class PaymentEjercicio{
    public static void main(String[] args) {
        Payment metodo1 = new CreditCard();
        Payment metodo2 = new PayPal();

        System.out.println("- Pasarela de Pagos:");
        metodo1.processPayment(150.00);
        metodo2.processPayment(89.99);
    }
}