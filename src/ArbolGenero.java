import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ArbolGenero {
    NodoArbol raiz;


    public ArbolGenero() {
        raiz = null;
    }

    public void asignarCasillero(String genero) {
        NodoArbol casillero = buscarPrimerCasilleroDisponible(raiz, genero);
        if (casillero != null) {
            casillero.ocupado = true;
            JOptionPane.showMessageDialog(null,"Casillero " + casillero.valor + " asignado al género " + genero);
        } else {
            JOptionPane.showMessageDialog(null,"No hay casilleros disponibles para asignar al género " + genero);
        }
    }

    private NodoArbol buscarPrimerCasilleroDisponible(NodoArbol nodo, String genero) {
        if (nodo == null) {
            return null;
        }
        if (genero.equalsIgnoreCase("Masculino")) {
            if (nodo.valor >= 1 && nodo.valor <= 12 && !nodo.ocupado) {
                return nodo;
            }
        } else if (genero.equalsIgnoreCase("Femenino")) {
            if (nodo.valor >= 13 && nodo.valor <= 24 && !nodo.ocupado) {
                return nodo;
            }
        }
        NodoArbol casilleroIzquierdo = buscarPrimerCasilleroDisponible(nodo.izquierdo, genero);
        if (casilleroIzquierdo != null) {
            return casilleroIzquierdo;
        }
        return buscarPrimerCasilleroDisponible(nodo.derecho, genero);
    }

    public void desocuparCasillero(int valor) {
        if (desocuparCasillero(raiz, valor)) {
            JOptionPane.showMessageDialog(null,"Casillero " + valor + " desocupado");
        } else {
            JOptionPane.showMessageDialog(null,"El casillero " + valor + " ya está vacío");
        }
    }

    private boolean desocuparCasillero(NodoArbol nodo, int valor) {
        if (nodo == null) {
            return false;
        }
        if (nodo.valor == valor) {
            if (nodo.ocupado) {
                nodo.ocupado = false;
                return true;
            } else {
                return false;
            }
        }
        if (desocuparCasillero(nodo.izquierdo, valor)) {
            return true;
        }
        return desocuparCasillero(nodo.derecho, valor);
    }

    public String imprimirCasillerosOcupados() {
        StringBuilder sb=new StringBuilder();
        imprimirCasillerosOcupados(raiz,sb);
        return sb.toString();
    }

    private void imprimirCasillerosOcupados(NodoArbol nodo, StringBuilder sb) {
        if (nodo == null) {
            return;
        }
        imprimirCasillerosOcupados(nodo.izquierdo, sb);
        if (nodo.ocupado) {
            sb.append("Casillero ").append(nodo.valor).append(" ocupado\n");
        }
        imprimirCasillerosOcupados(nodo.derecho, sb);
    }
    public String imprimirCasillerosDisponibles() {
        StringBuilder sb = new StringBuilder();
        imprimirCasillerosDisponibles(raiz, sb);
        return sb.toString();
    }

    private void imprimirCasillerosDisponibles(NodoArbol nodo, StringBuilder sb) {
        if (nodo == null) {
            return;
        }
        imprimirCasillerosDisponibles(nodo.izquierdo, sb);
        if (!nodo.ocupado) {
            sb.append("Casillero ").append(nodo.valor).append(" disponible\n");
        }
        imprimirCasillerosDisponibles(nodo.derecho, sb);
    }

    public void inicializarCasilleros() {
        raiz = new NodoArbol(1);
        raiz.izquierdo = new NodoArbol(2);
        raiz.derecho = new NodoArbol(13);
        NodoArbol nodoMasculino = raiz.izquierdo;
        NodoArbol nodoFemenino = raiz.derecho;
        for (int i = 3; i <= 12; i++) {
            nodoMasculino.derecho = new NodoArbol(i);
            nodoMasculino = nodoMasculino.derecho;
        }
        for (int i = 14; i <= 24; i++) {
            nodoFemenino.derecho = new NodoArbol(i);
            nodoFemenino = nodoFemenino.derecho;
        }
    }

}
