package registroEmpleados;

public class Main {
    public static void main(String[] args) {
        GestionEmpleados gestionEmpleados = new GestionEmpleados();

        Empleado empleado1 = new EmpleadoPermanente("Jose Cardona", 28, 1, 1000000, 3);
        Empleado empleado2 = new EmpleadoTemporal("Edwin Acevedo", 33, 2, 2000000, "27-04-2025");

        gestionEmpleados.agegarEmpleado(empleado1);
        gestionEmpleados.agegarEmpleado(empleado2);

        gestionEmpleados.mostrarEmpleados();

        gestionEmpleados.eliminarEmpleado(1);

        System.out.println("Empleados que quedan:");
        gestionEmpleados.mostrarEmpleados();

    }
}
