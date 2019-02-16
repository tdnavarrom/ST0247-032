import java.util.ArrayList;

/**
 * Clase en la cual se implementan los metodos del Taller 4
 *
 * @author Mauricio Toro, Andres Paez
 */
public class Taller4 {


    public static boolean hayCaminoDFS(Digraph g, int v, int w) {
        boolean[] visitados = new boolean[g.size()];
        return hayCaminoDFS(g, v, w, visitados);
    }


    private static boolean hayCaminoDFS(Digraph g, int v, int w, boolean[] visitados) {
        visitados[v] = true;
        if (v == w) return true;
        else {
            ArrayList<Integer> hijos = g.getSuccessors(v);
            for (Integer h : hijos)
                if (!visitados[h] && hayCaminoDFS(g, h, w, visitados)) return true;
            return false;
        }
    }


    public static int costoMinimo(Digraph g, int inicio, int fin, boolean[] visitados) {
        visitados[inicio] = true;
        int costoMinimo = Integer.MAX_VALUE - 10000;
        int costoCamino = 0;
        if (inicio == fin) {
            visitados[inicio] = false;
            return costoCamino;
        }
        ArrayList<Integer> hijos = g.getSuccessors(inicio);
        for (Integer hijo : hijos) {
            if (!visitados[hijo]) {
                costoCamino = g.getWeight(inicio, hijo) + costoMinimo(g, hijo, fin, visitados);
                visitados[hijo] = false;
                if (costoCamino < costoMinimo) costoMinimo = costoCamino;
            }
        }

        return costoMinimo;
    }


    public static boolean hayCamino(Digraph g, int inicio, int end) {
        boolean visitados[] = new boolean[g.size()];
        return hayCaminoAux(g, inicio, end, visitados);
    }

    private static boolean hayCaminoAux(Digraph g, int inicio, int end, boolean[] visitados) {
        visitados[inicio] = true;
        if (inicio == end) {
            return true;
        } else {
            ArrayList<Integer> hijos = g.getSuccessors(inicio);
            for (Integer hijo : hijos) {
                if (!visitados[hijo] && hayCaminoAux(g, hijo, end, visitados)) {
                    return true;
                }
                return false;
            }
        }
        return true;


    }
}