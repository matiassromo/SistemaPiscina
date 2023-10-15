import java.util.ArrayList;

public class Producto {
    private String nombre;
    private String descripcion;
    private double precio;
    private int cantidad;
    private String tipo;
    ArrayList<Producto> productos;

    public Producto(String nombre, String descripcion, double precio, int cantidad, String tipo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.tipo=tipo;
    }

    public Producto() {
    }

    public String getTipo() {
        return tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Pedido-- " +
                " Nombre: " + nombre + ", " +
                " Descripción: " + descripcion + ", " +
                " Precio: " + precio + ", ";
    }
}
