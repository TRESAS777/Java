package registroEmpleados;

import java.util.ArrayList;

public class GestionEmpleados {

    private ArrayList<Empleado> empleados;

    public GestionEmpleados() {
        empleados = new ArrayList<>();
    }

    public void agegarEmpleado(Empleado empleado){
        empleados.add(empleado);
    }

    public boolean eliminarEmpleado (int idEmpleado){
        return empleados.removeIf(empleado -> empleado.getIdEmpleado() == idEmpleado);
    }

    public void mostrarEmpleados() {
        for (Empleado empleado : empleados){
            System.out.println("ID Empleado: " + empleado.getIdEmpleado() +
                    ", Nombre: " + empleado.getNombre() + ", Salario: " + empleado.getSalario());
        }
    }
}
