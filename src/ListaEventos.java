import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListaEventos {

    private List<Evento> listaEventos = new ArrayList<>();

    //Metodo de agregar
    public void agregarEvento(Evento nombreEvento){
        listaEventos.add(nombreEvento);
    }

    //Metodo de eliminar

    public void eliminarEvento(String cedula){
        Evento eventoAEliminar = null;
        for (Evento evento : listaEventos){
            if (evento.getCedula().equals(cedula)){
                eventoAEliminar = evento;
                break;
            }
        }
        if (eventoAEliminar != null ){
            listaEventos.remove(eventoAEliminar);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontro el evento", "Error", JOptionPane.ERROR_MESSAGE );
        }
    }

    public void actualizarDatos(String cedula, Evento nuevosDatos){

        for (Evento datos : listaEventos){
            if (datos.getCedula().equals(cedula)){
                datos.setFechaEvento(nuevosDatos.getFechaEvento());
                datos.setTipoEvento(nuevosDatos.getTipoEvento());
                datos.setCantidadInvitados(nuevosDatos.getCantidadInvitados());
            }else {
                JOptionPane.showMessageDialog(null, "Se han editado los datos correctamente");
            }
        }
    }

    public List<Evento> getListaEventos(){
        return listaEventos;
    }

    public List<Evento> ordenarPorNombre(){

        Collections.sort(listaEventos);

        return listaEventos;


    }

    public String generarReporte() {
        StringBuilder sb = new StringBuilder();
        for (Evento cd : listaEventos){
            sb.append("Tipo de evento: ").append(cd.getTipoEvento()).append("\n");
            sb.append("Cedula: ").append(cd.getCedula()).append("\n");
            sb.append("Nombre cliente: ").append(cd.getNombreCliente()).append("\n");
            sb.append("Cantidad de invitados: ").append(cd.getCantidadInvitados()).append("\n");
            sb.append("Fecha evento: ").append(cd.getFechaEvento()).append("\n");
            sb.append("Costo: ").append(cd.getPrecioEvento()).append("\n").append("\n");
        }
        return sb.toString();
    }

}
