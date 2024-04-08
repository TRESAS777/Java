package entity;

import java.sql.Date;
import java.sql.Timestamp;

public class Compra extends Producto{
    private int id_compra;
    private Timestamp fecha_compra;
    private int cantidad;
    private int id_cliente;
    private int id_producto;

    public Compra() {
    }

    public Compra(int id_compra, Timestamp fecha_compra, int cantidad, int id_cliente, int id_producto) {
        this.id_compra = id_compra;
        this.fecha_compra = fecha_compra;
        this.cantidad = cantidad;
        this.id_cliente = id_cliente;
        this.id_producto = id_producto;
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public Timestamp getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(Timestamp fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "id_compra=" + id_compra +
                ", fecha_compra=" + fecha_compra +
                ", cantidad=" + cantidad +
                ", id_cliente=" + id_cliente +
                ", id_producto=" + id_producto +
                '}';
    }
}
