import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ListaClientes {
    private List<DatosCliente> clientes;


    public ListaClientes(){
        clientes = new ArrayList<>();
    }

    public void agregarCliente(DatosCliente cliente){
        clientes.add(cliente);
    }

    public List<DatosCliente> getListaClientes() {
        return clientes;
    }

    public void eliminar (DatosCliente cliente){
        clientes.remove(cliente);
    }

    public int tamanio(){
        int tam = clientes.size();
        return tam;
    }


    public void eliminarCliente(String nombre) {
        DatosCliente clienteAEliminar = null;
        for (DatosCliente cliente : clientes) {
            if (cliente.getNombre().equals(nombre)) {
                clienteAEliminar = cliente;
                break;
            }
        }
        if (clienteAEliminar != null) {
            clientes.remove(clienteAEliminar);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el cliente", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public boolean buscarCliente(String cedula){
        DatosCliente cedulaencontrada = null;
        for (DatosCliente cliente: clientes){
            if (cliente.getCedula().equals(cedula)){
                cedulaencontrada=cliente;
                break;
            }
        }
        if (cedulaencontrada!=null){
            JOptionPane.showMessageDialog(null,"Se econtro el usuario");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el cliente", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean buscarContrasena(String contrasena){
        DatosCliente contrasenaencontrada = null;
        for (DatosCliente cliente: clientes){
            if (cliente.getContrasena().equals(contrasena)){
                contrasenaencontrada=cliente;
                break;
            }
        }
        if (contrasenaencontrada!=null){
            JOptionPane.showMessageDialog(null,"La contrasena es valida");
            return true;
        } else{
            JOptionPane.showMessageDialog(null,"La contrasena es invalida", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public String buscarGenero(){
        String genero = "";
        for (DatosCliente cliente: clientes){
            if (cliente.getGenero().equalsIgnoreCase("Masculino")){
                genero="Masculino";
            } else {
                genero="Femenino";
            }
        }return genero;
    }
    public void modificarDatos(String nombre, DatosCliente clienteActualizado) {
        for (DatosCliente cliente : clientes) {
            if (cliente.getNombre().equals(nombre)) {
                cliente.setNombre(clienteActualizado.getNombre());
                cliente.setMembresia(clienteActualizado.isMembresia());
                return;
            } else {
                JOptionPane.showMessageDialog(null, "Se ha editado el cliente con éxito");
            }
        }
    }

    public void eliminarDatos(String nombre) {
        for (DatosCliente cliente : clientes) {
            if (cliente.getNombre().equals(nombre)) {
                clientes.remove(cliente);
                return;
            }
        }
    }


    public String reporteCliente() {
        StringBuilder sb = new StringBuilder();

        for (DatosCliente dc : clientes){

            sb.append("Nombre: ").append(dc.getNombre()).append("\n");
            sb.append("Cedula: ").append(dc.getCedula()).append("\n");
            sb.append("Cantidad de adultos: ").append(dc.getAdultos()).append("\n");
            sb.append("Cantidad de niños: ").append(dc.getNinios()).append("\n");
            sb.append("Cantidad de tercera edad: ").append(dc.getTerceraEdad()).append("\n");
            sb.append("Cantidad de acompañantes: ").append(dc.getAcomapaniantes()).append("\n");
            sb.append("Membresia: ").append(dc.isMembresia()).append("\n");
            sb.append("Codigo: ").append(dc.getCodigo()).append("\n");
            sb.append("Genero: ").append(dc.getGenero()).append("\n");

            int precioTotal = (dc.getAdultos() * Precios.PRECIO_ADULTO) + (dc.getNinios()* Precios.PRECIO_NINIOS) + (dc.getAcomapaniantes() * Precios.PRECIO_ACOMPANINATE) + (dc.getTerceraEdad() * Precios.PRECIO_TERCERAEDAD);

            sb.append("\nTotal a pagar: ").append("$").append(precioTotal).append(" dólares\n");
            sb.append("\n");
        }

        return sb.toString();
    }
}
