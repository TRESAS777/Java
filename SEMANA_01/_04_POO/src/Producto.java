public class Producto {

    private int id;
    private String description;
    private int cantidad;

    public Producto(int id, String description, int cantidad) {
        this.id = id;
        this.description = description;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void agregarStock (int cantidadAgregar){
        this.cantidad += cantidadAgregar;
    }

    public void quitarStock (int cantidadQuitar){
        this.cantidad -= cantidadQuitar;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }
}
