public class Tuberia {
    private String nombre;
    private String estado;
    private String comentario;
    private String abierto;

    public Tuberia(String nombre, String estado, String comentario, String abierto) {
        this.nombre = nombre;
        this.estado = estado;
        this.comentario = comentario;
        this.abierto = abierto;
    }

    public Tuberia() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getAbierto() {
        return abierto;
    }

    public void setAbierto(String abierto) {
        this.abierto = abierto;
    }

    @Override
    public String toString() {
        return "Tuberia{" +
                "nombre='" + nombre + '\'' +
                ", estado='" + estado + '\'' +
                ", comentario='" + comentario + '\'' +
                ", abierto='" + abierto + '\'' +
                '}';
    }
}
