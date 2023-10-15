public class Evento implements Comparable<Evento>{

    private String tipoEvento;
    private int cantidadInvitados;
    private String fechaEvento;
    private int precioEvento;
    private String cedula;
    private String nombreCliente;

    public Evento(){

    }

    public  Evento(String tipoEvento, int cantidadInvitados, String fechaEvento, String cedula, String nombreCliente) {
        this.tipoEvento = tipoEvento;
        this.cantidadInvitados = cantidadInvitados;
        this.fechaEvento = fechaEvento;
        this.nombreCliente = nombreCliente;
        this.cedula = cedula;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getCantidadInvitados() {
        return cantidadInvitados;
    }

    public void setCantidadInvitados(int cantidadInvitados) {
        this.cantidadInvitados = cantidadInvitados;
    }

    public String getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(String fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public int getPrecioEvento() {
        return precioEvento;
    }

    public void setPrecioEvento(int precioEvento) {
        this.precioEvento = precioEvento;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    @Override
    public String toString() {
        return "ListaEvento{" +
                "\tTipo de evento: " + tipoEvento +
                "\tCantidad de invitados: " + cantidadInvitados +
                "\tFecha de evento: " + fechaEvento +
                "\tCosto evento: " + precioEvento +
                "\tCedula: " + cedula +
                "\tNombre clientes" + nombreCliente;
    }

    @Override
    public int compareTo(Evento o) {
        return this.getCedula().compareTo(o.getCedula());
    }
}
