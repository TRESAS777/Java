package registroEmpleados;

public class EmpleadoPermanente extends Empleado{

    private int yearsantiguedad;

    public EmpleadoPermanente(String nombre, int edad, int idEmpleado, double salario, int yearsantiguedad) {
        super(nombre, edad, idEmpleado, salario);
        this.yearsantiguedad = yearsantiguedad;
    }

    public int getYearsantiguedad() {
        return yearsantiguedad;
    }

    public void setYearsantiguedad(int yearsantiguedad) {
        this.yearsantiguedad = yearsantiguedad;
    }
}
