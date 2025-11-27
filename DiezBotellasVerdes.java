public class DiezBotellasVerdes {
    public static void main(String[] args) {
        String botellasPlural = " botellas verdes colgando en la pared";
        String botellasSingular = " botella verde colgando en la pared";
        String[] numeros = {"Diez", "Nueve", "Ocho", "Siete", "Seis", "Cinco", "Cuatro", "Tres", "Dos", "Una"};
        for (int i = 0; i < numeros.length;) {
            while (i <= 8){
                System.out.println(numeros[i] + botellasPlural + ",\n" + numeros[i] + botellasPlural + ",");
                System.out.println("Si una botella verde se llega a caer,");
                i++;
                if (i == 9){
                    System.out.println(numeros[i] + botellasSingular + ".\n");
                }
                else{
                    System.out.println(numeros[i] + botellasPlural + ".\n");
                }
            }
            if (i == 9){
                System.out.println(numeros[i] + botellasSingular + ",\n" + numeros[i] + botellasSingular);
                System.out.println("Si esa botella verde se llega a caer,\nNo quedan" + botellasPlural + ".");
                i++;
            }
        }
    }
}
