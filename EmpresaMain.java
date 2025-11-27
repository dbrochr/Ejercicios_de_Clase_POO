import java.time.LocalDate;

class Empleado {
    protected String nombre;
    protected String identificacion;
    protected int diasTrabajados;
    protected double salarioBase;
    protected LocalDate fechaContratacion;

    public Empleado(String nombre, String identificacion, int dias, double salario, LocalDate fecha) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.diasTrabajados = dias;
        this.salarioBase = salario;
        this.fechaContratacion = fecha;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + 
               " | ID: " + identificacion + 
               " | Días: " + diasTrabajados + 
               " | Salario: $" + salarioBase +
               " | Contratado: " + fechaContratacion;
    }
    
}

class EmpleadoProduccion extends Empleado {
    public String turno;

    public EmpleadoProduccion(String nombre, String id, int dias, double salario, LocalDate fecha, String turno) {
        super(nombre, id, dias, salario, fecha);
        this.turno = turno;
    }

    @Override
    public String toString() {
        return super.toString() + " | TURNO: " + turno + " (Producción)";
    }
}

class EmpleadoDistribucion extends Empleado {
    public String zona;

    public EmpleadoDistribucion(String nombre, String id, int dias, double salario, LocalDate fecha, String zona) {
        super(nombre, id, dias, salario, fecha);
        this.zona = zona;
    }

    @Override
    public String toString() {
        return super.toString() + " | ZONA: " + zona + " (Distribución)";
    }
}

public class EmpresaMain {
    public static void main(String[] args) {
        
        System.out.println("- Nómina de la Empresa:");

        EmpleadoProduccion emp1 = new EmpleadoProduccion(
            "Carlos", "1001", 20, 1500.0, LocalDate.of(2023, 1, 15), "Noche"
        );

        EmpleadoDistribucion emp2 = new EmpleadoDistribucion(
            "Ana", "2005", 22, 1600.0, LocalDate.now(), "Norte"
        );

        System.out.println(emp1);
        System.out.println("\n" + emp2);
    }
}