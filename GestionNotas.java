public class GestionNotas {
    public static void main(String[] args) {
        
        double[] notas = new double[5];

        notas[0] = 4.5;
        notas[1] = 3.8;
        notas[2] = 2.9;
        notas[3] = 4.0;
        notas[4] = 3.2;

        double suma = 0;

        System.out.println("Listado de Notas:");
        
        /*for (int i = 0; i < notas.length; i++) {
            System.out.println("Estudiante " + (i + 1) + ": " + notas[i]);    
            suma += notas[i];
        }*/

        for (double nota : notas) {
            System.out.println("Nota: " + nota);
            suma += nota;
        }

        double promedio = suma / notas.length;     
        System.out.println("- El promedio final es: " + promedio);
    }
}

