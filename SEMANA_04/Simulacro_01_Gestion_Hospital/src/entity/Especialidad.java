package entity;

public class Especialidad {

    private int id_Especialidad;
    private String nombre;
    private String descipcion;

    public Especialidad() {
    }

    public Especialidad(int id, String nombre, String descipcion) {
        this.id_Especialidad = id;
        this.nombre = nombre;
        this.descipcion = descipcion;
    }

    public int getId() {
        return id_Especialidad;
    }

    public void setId(int id) {
        this.id_Especialidad = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescipcion() {
        return descipcion;
    }

    public void setDescipcion(String descipcion) {
        this.descipcion = descipcion;
    }

    @Override
    public String toString() {
        return "Especialidad{" +
                "id_Especialidad=" + id_Especialidad +
                ", nombre='" + nombre + '\'' +
                ", descipcion='" + descipcion + '\'' +
                '}';
    }
}
