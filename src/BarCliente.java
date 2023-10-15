import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class BarCliente {
    private final ArrayList<Producto> listadoProducto=new ArrayList<>();
    private Pedido pe;

PriorityQueue<Pedido> pedidos;
    public BarCliente(){
        pedidos=new PriorityQueue<>();
        this.listadoProducto.add(new Producto("Salchipapa", "Salchipapa mas gaseosa", 3, 5,"PLATO A LA CARTA"));
        this.listadoProducto.add(new Producto("Choclo con queso", "Choclo con queso mas gaseosa", 3, 3,"PLATO A LA CARTA"));
        this.listadoProducto.add(new Producto("Limonada", "Jarra de limonada natural", 3, 4,"BEBIDA"));
        this.listadoProducto.add(new Producto("Cerveza", "Cerveza Club 1.5L", 2.5, 5,"BEBIDA"));
    }
    public void encolar(Pedido dato){
        pedidos.add(dato);
    }
    public List<Producto> listaProductos(){
        return listadoProducto;
    }

    public ArrayList<Producto> getListadoProductoNombre() {

        ArrayList<Producto> arreglo= new ArrayList<>();
        for(Producto p:listadoProducto){
            arreglo.add(p);
        }
        return arreglo;

    }

    public void buscarPedido(String nombre,int prioridad,int cantidad){
        for(Producto p:listadoProducto){
            if(nombre.compareToIgnoreCase(p.getNombre())==0)
            {
                pe=new Pedido(p.getNombre(),p.getDescripcion(),p.getPrecio(),cantidad,p.getTipo(),prioridad);
                System.out.println(p.getNombre()+p.getDescripcion()+p.getPrecio()+cantidad);
                encolar(pe);
            }
        }
    }

    public boolean validarStock(int cantidad,String nombrePedido) {
        boolean r=true;
        for (Producto p :listadoProducto) {
            if (cantidad> p.getCantidad() && p.getNombre().equals(nombrePedido)) {
                JOptionPane.showMessageDialog(null, "No hay suficientes productos de: " + p.getNombre());
            } else if (cantidad<= p.getCantidad()&& p.getNombre().equals(nombrePedido)) {
                r=false;
                p.setCantidad(p.getCantidad()-cantidad);
            }
        }
        return r;
    }

    public void reabastecer (String producto, int cantidad){
        for (Producto p :listadoProducto){
            if (p.getNombre().equals(producto)){
                p.setCantidad(p.getCantidad()+cantidad);
                JOptionPane.showMessageDialog(null,"Se reabastecio el producto de: "+p.getNombre()+" con la cantidad de: "+cantidad);

            }
        }
    }
    public List<Pedido> listapedidos(){
        return pedidos.stream().toList();
    }


    public Pedido desencolar() throws Exception{
        if(pedidos.isEmpty())
            throw new Exception("No hay elementos");
        return pedidos.poll();
    }

    public void agregarProducto(Producto p){
        listadoProducto.add(p);
    }
    public boolean validar(String nombre){
        for(Producto p:listadoProducto){
            if(nombre.compareToIgnoreCase(p.getNombre())==0)
            {
                return false;
            }
        }
        return true;
    }
}
