package registroEmpleados;

public class EmpleadoTemporal extends Empleado{

    private String fechaContrato;

    public EmpleadoTemporal(String nombre, int edad, int idEmpleado, double salario, String fechaContrato) {
        super(nombre, edad, idEmpleado, salario);
        this.fechaContrato = fechaContrato;
    }

    public String getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(String fechaContrato) {
        this.fechaContrato = fechaContrato;
    }
}
