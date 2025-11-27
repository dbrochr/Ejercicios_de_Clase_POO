abstract class Figura {
    
    public abstract void calcularArea();
    public abstract void calcularPerimetro();
}

class Circulo extends Figura {
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    public void calcularArea() {
        double area = Math.PI * Math.pow(radio, 2);
        System.out.println("Círculo (Radio " + radio + ") -> Área: " + area);
    }

    @Override
    public void calcularPerimetro() {
        double perimetro = 2 * Math.PI * radio;
        System.out.println("Círculo (Radio " + radio + ") -> Perímetro: " + perimetro);
    }
}

class Cuadrado extends Figura {
    private double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    @Override
    public void calcularArea() {
        double area = lado * lado;
        System.out.println("Cuadrado (Lado " + lado + ") -> Área: " + area);
    }

    @Override
    public void calcularPerimetro() {
        double perimetro = 4 * lado;
        System.out.println("Cuadrado (Lado " + lado + ") -> Perímetro: " + perimetro);
    }
}

public class CalculoFiguras {
    public static void main(String[] args) {
        System.out.println("-Cálculo de figuras gepmétricas\n");

        Figura miCirculo = new Circulo(5.0);
        
        miCirculo.calcularArea();
        miCirculo.calcularPerimetro();

        Figura miCuadrado = new Cuadrado(10.0);
        
        miCuadrado.calcularArea();
        miCuadrado.calcularPerimetro();
    }
}