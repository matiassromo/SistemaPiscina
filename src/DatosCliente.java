public class DatosCliente implements Comparable<DatosCliente>{
    private String nombre;
    private int adultos;
    private int ninios;
    private int terceraEdad;
    private int acomapaniantes;
    private String membresia;
    private int codigo;
    private String cedula;
    private String contrasena;
    private String genero;


    public DatosCliente(String nombre, int adultos, int ninios, int terceraEdad, int acomapaniantes, String membresia,
                        int codigo,String cedula,String contrasena, String genero) {
        this.nombre = nombre;
        this.adultos = adultos;
        this.ninios = ninios;
        this.terceraEdad = terceraEdad;
        this.acomapaniantes = acomapaniantes;
        this.membresia = membresia;
        this.codigo = codigo;
        this.cedula=cedula;
        this.contrasena=contrasena;
        this.genero = genero;
    }

    public DatosCliente(String nombre, String membresia,String cedula,String contrasena){
        this.nombre = nombre;
        this.membresia = membresia;
        this.cedula=cedula;
        this.contrasena=contrasena;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAdultos() {
        return adultos;
    }

    public void setAdultos(int adultos) {
        this.adultos = adultos;
    }

    public int getNinios() {
        return ninios;
    }

    public void setNinios(int ninios) {
        this.ninios = ninios;
    }

    public int getTerceraEdad() {
        return terceraEdad;
    }

    public void setTerceraEdad(int terceraEdad) {
        this.terceraEdad = terceraEdad;
    }

    public int getAcomapaniantes() {
        return acomapaniantes;
    }

    public void setAcomapaniantes(int acomapaniantes) {
        this.acomapaniantes = acomapaniantes;
    }

    public String isMembresia() {
        return membresia;
    }

    public void setMembresia(String membresia) {
        this.membresia = membresia;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "DatosCliente{" +
                "nombre: " + nombre +
                "\nAdultos: " + adultos +
                "\nNinios: " + ninios +
                "\nTerceraEdad: " + terceraEdad +
                "\nAcomapaniantes: " + acomapaniantes +
                "\nMembresia: " + membresia +
                "\nCodigo: " + codigo +
                "\nCedula: " + cedula +
                "\nContrasena: " + contrasena +
                "\nGenero: " + genero;
    }

    @Override
    public int compareTo(DatosCliente otroCliente) {
        return this.nombre.compareTo(otroCliente.getNombre());
    }
}
