import java.util.ArrayList;

public class SistemaTuberias {
    private ArrayList<Tuberia> listadoTuberia=new ArrayList<>();

    public SistemaTuberias() {
        this.listadoTuberia = listadoTuberia;
        this.listadoTuberia.add(new Tuberia("G1","Funcionamiento correcto","","Abierto"));
        this.listadoTuberia.add(new Tuberia("G2","Pendiente reparacion","Posible fuga se requiere mantenimiento","Cerrado"));
        this.listadoTuberia.add(new Tuberia("G3","Funcionamiento correcto","","Abierto"));
        this.listadoTuberia.add(new Tuberia("G4","Funcionamiento correcto","","Abierto"));
        this.listadoTuberia.add(new Tuberia("P1","Funcionamiento correcto","","Abierto"));
        this.listadoTuberia.add(new Tuberia("P2","Pendiente reparacion","Posible fallo en la tuberia","Cerrado"));
        this.listadoTuberia.add(new Tuberia("P3","Funcionamiento correcto","","Abierto"));
        this.listadoTuberia.add(new Tuberia("P4","Funcionamiento correcto","","Abierto"));
    }
    public void encolarTuberia(Tuberia t){
        listadoTuberia.add(t);
    }
    public void cambioEstado(String nombreT,String s){
        for(Tuberia p:listadoTuberia){
            if(nombreT.compareToIgnoreCase(p.getNombre())==0) {
                p.setEstado("Funcionamiento correcto");
                p.setComentario("");
                p.setAbierto("Abierto");
            }
        }
    }
    public void registroAnomalia(String nombreT,String s){
        for(Tuberia p:listadoTuberia){
            if(nombreT.compareToIgnoreCase(p.getNombre())==0) {
                p.setEstado("Pendiente reparacion");
                p.setComentario(s);
                p.setAbierto("Cerrado");
            }
        }
    }

    public ArrayList<Tuberia> getListadoTuberias() {

        ArrayList<Tuberia> arreglo= new ArrayList<>();
        for(Tuberia p:listadoTuberia){
            arreglo.add(p);
        }
        return arreglo;

    }
}
