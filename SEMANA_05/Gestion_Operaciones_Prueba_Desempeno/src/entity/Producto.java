package entity;

public class Producto extends Tienda{

    private int id_producto;
    private String nombre;
    private double precio;
    private int id_tienda;
    private int stock;

    public Producto() {
    }

    public Producto(int id_producto, String nombre, double precio, int id_tienda, int stock) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.precio = precio;
        this.id_tienda = id_tienda;
        this.stock = stock;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getId_tienda() {
        return id_tienda;
    }

    public void setId_tienda(int id_tienda) {
        this.id_tienda = id_tienda;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id_producto=" + id_producto +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", id_tienda=" + id_tienda +
                ", stock=" + stock +
                '}';
    }
}