import java.time.LocalDate;

class Empleado {
    private String nombre;
    private String cargo;
    private LocalDate fechaContratacion;

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    public Empleado(String nombre, String cargo) {
        this.nombre = nombre;
        this.cargo = cargo;
    }

    public Empleado(String nombre, String cargo, LocalDate fechaContratacion) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.fechaContratacion = fechaContratacion;
    }

    public Empleado(Empleado emp) {
        this.nombre = emp.nombre;
        this.cargo = emp.cargo;
        this.fechaContratacion = emp.fechaContratacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(LocalDate fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    @Override
    public String toString() {
    return "Empleado: \nNombre = " + nombre + "\nCargo = " + cargo + "\nFecha de Contratacion = " + fechaContratacion + "\n";
    }
}

public class RegistroEmpleados {
    public static void main(String[] args) {
        
        Empleado emp1 = new Empleado("Carlos");
        System.out.println(emp1);

        Empleado emp2 = new Empleado("Ana", "Gerente");
        System.out.println(emp2);

        Empleado emp3 = new Empleado("Luis", "Analista", LocalDate.of(2025, 05, 10));
        System.out.println(emp3);

        Empleado emp4 = new Empleado(emp3);
        System.out.println(emp4);
    }
}
