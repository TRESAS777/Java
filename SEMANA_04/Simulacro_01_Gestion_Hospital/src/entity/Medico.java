package entity;

public class Medico {

    private int id_Medico;
    private String nombre;
    private String apellido;
    private int id_Especialidad;

    public Medico() {
    }

    public Medico(int id_Medico, String nombre, String apellido, int id_Especialidad) {
        this.id_Medico = id_Medico;
        this.nombre = nombre;
        this.apellido = apellido;
        this.id_Especialidad = id_Especialidad;
    }

    public int getId_Medico() {
        return id_Medico;
    }

    public void setId_Medico(int id_Medico) {
        this.id_Medico = id_Medico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getId_Especialidad() {
        return id_Especialidad;
    }

    public void setId_Especialidad(int id_Especialidad) {
        this.id_Especialidad = id_Especialidad;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "id_Medico=" + id_Medico +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", id_Especialidad=" + id_Especialidad +
                '}';
    }
}
