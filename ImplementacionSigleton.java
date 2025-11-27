class ConfiguracionSistema {
    private static ConfiguracionSistema uniqueInstance;

    private String nombreInstitucion;
    private int anioAcademico;
    private int maxCreditosPorSemestre;

    private ConfiguracionSistema(String nombre, int anio, int creditos) {
        this.nombreInstitucion = nombre;
        this.anioAcademico = anio;
        this.maxCreditosPorSemestre = creditos;
    }

    public static ConfiguracionSistema getInstance(String nombre, int anio, int creditos) {
        if (uniqueInstance == null) {
            uniqueInstance = new ConfiguracionSistema(nombre, anio, creditos);
            System.out.println("-> Creando nueva instancia de Configuración");
        } else {
            System.out.println("-> Devolviendo instancia existente");
        }
        return uniqueInstance;
    }

    public static ConfiguracionSistema getInstance() {
        return uniqueInstance;
    }

    public void setAnioAcademico(int anioAcademico) {
        this.anioAcademico = anioAcademico;
    }

    @Override
    public String toString() {
        return "Configuración [Institución: " + nombreInstitucion + 
               ", Año: " + anioAcademico + 
               ", Max Créditos: " + maxCreditosPorSemestre + "]";
    }
}

public class ImplementacionSigleton {
    public static void main(String[] args) {
        System.out.println(" CONFIGURACIÓN UNIVERSITARIA\n");

        System.out.println("1. Intentando acceder a la configuración por primera vez:");
        ConfiguracionSistema config1 = ConfiguracionSistema.getInstance("Universidad del Magdalena", 2025, 18);
        System.out.println(config1);

        System.out.println("\n2. Intentando crear una 'segunda' configuración con datos distintos:");
        ConfiguracionSistema config2 = ConfiguracionSistema.getInstance("Otra Universidad", 2030, 20);
        System.out.println(config2);

        System.out.println("\n3. Verificando identidad de objetos:");
        if (config1 == config2) {
            System.out.println("¡ÉXITO! config1 y config2 son el mismo objeto en memoria.");
        } else {
            System.out.println("ERROR: Son objetos diferentes.");
        }

        System.out.println("\n4. Modificando config1 y leyendo config2:");
        config1.setAnioAcademico(2026);
        System.out.println("Config2 ahora muestra año: " + config2.toString());
    }
}