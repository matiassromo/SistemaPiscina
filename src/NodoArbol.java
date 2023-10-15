public class NodoArbol {
    int valor;
    boolean ocupado;
    NodoArbol izquierdo;
    NodoArbol derecho;

    public NodoArbol(int valor) {
        this.valor= valor;
        izquierdo = null;
        derecho = null;
        ocupado=false;
    }
}
