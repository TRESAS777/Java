public class Empleado {

    private String nombre;
    private String position;
    private double salario;
    private int id;

    public Empleado() {
    }

    public Empleado(String nombre, String position, double salario, int id) {
        this.nombre = nombre;
        this.position = position;
        this.salario = salario;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void aumentarSalario (double porcentaje){
        this.salario = salario + (salario*(porcentaje/100));
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", position='" + position + '\'' +
                ", salario=" + salario +
                ", id=" + id +
                '}';
    }
}
