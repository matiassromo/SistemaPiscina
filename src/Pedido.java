import java.util.PriorityQueue;

public class Pedido extends Producto implements Comparable<Pedido>{
    PriorityQueue<Pedido> pedidos;
    private int prioridad;
    private int cantidad;
    public Pedido(){
        pedidos=new PriorityQueue<Pedido>();
    }
    public Pedido(String nombre, String descripcion, double precio, int cantidad,String tipo, int prioridad) {
        super(nombre, descripcion, precio, cantidad,tipo);
        this.cantidad=cantidad;
        this.prioridad=prioridad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public void encolar(Pedido dato){
        pedidos.add(dato);
    }

    @Override
    public String toString() {
        return super.toString()+
                " Prioridad: " + prioridad + ", " +
                " Cantidad: " + cantidad;
    }

    @Override
    public int compareTo(Pedido nuevo) {
        if(this.prioridad<nuevo.getPrioridad())
            return 1;
        else
            return -1;
    }
}
