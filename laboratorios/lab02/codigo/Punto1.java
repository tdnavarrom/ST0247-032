import java.util.ArrayList;

/*
*
* Este Algorimto esta basado en el algoritmo de MAria Sofia Uribe
* y fue un trabajo en equipo con Juan Pablo Leal y Santiago Albisser
*
*
* */

public class Punto1 {


    private static int calcularCamino( Digraph g,  int [] path , int input) {
        int cost = g.getWeight(input,path[0]) + g.getWeight(path[path.length-1],input);
        for (int i =0 ; i < path.length - 1; i++)
            cost += g.getWeight(path[i],path[i+1]);
        return cost;
    }

    private static void permutaciones(int[] not_visited, int [] visited, int [] minCost, Digraph g, int v) {
        if (not_visited.length == 0){
            int cost = calcularCamino(g,visited,v);
            if (cost < minCost[0]) minCost[0] = cost;
        }
        else {
            for (int j = 0; j < not_visited.length; j++) {
                permutaciones(except(not_visited, j), add(visited, not_visited[j]), minCost, g, v);
            }
        }
    }

    private static int[] except (int[] a, int b){
        int [] nuevo = new int[a.length-1];
        int z=0;
        for (int i =0 ; i < a.length; i++){
            if (i != b){
                nuevo[z]= a[i];
                z++;
            }
        }
        return nuevo;
    }

    private static int calcular( Digraph g, int input) {
        ArrayList<Integer> hijos = g.getSuccessors(input);
        int [] kids;

        if (hijos.contains(input)) kids = new int[hijos.size()-1];
        else kids = new int[hijos.size()];

        int cont = 0;
        for (int i =0 ; i < hijos.size(); i++){
            int temp = hijos.get(i);
            if (temp != input ){
                kids[cont]=temp;
                cont++;
            }
        }
        int  costo_minimo =  calcularCamino(g,kids,input);
        int sol []= new int[]{ costo_minimo };
        permutaciones(kids,new int []{},sol,g,input);
        return sol[0];
    }

    private static int[] concatenacion(int[] arr1, int[] arr2){
        int[] r = new int[arr1.length + arr2.length];
        System.arraycopy(arr1,0,r,0,arr1.length);
        System.arraycopy(arr1,0,r,arr1.length,arr2.length);
        return r;
    }

    private static int[] add(int a[],int k) {
        return concatenacion(a, new int[] {k});
    }
    public static void main(String [] args){

        DigraphAL g1 = new DigraphAL(4);
        g1.addArc(0, 1, 2);
        g1.addArc(0, 2, 2);
        g1.addArc(0, 3, 1);
        g1.addArc(0, 4, 4);
        g1.addArc(1, 0, 2);
        g1.addArc(1, 2, 3);
        g1.addArc(1, 3, 2);
        g1.addArc(1, 4, 3);
        g1.addArc(2, 0, 2);
        g1.addArc(2, 1, 3);
        g1.addArc(2, 3, 2);
        g1.addArc(2, 4, 2);
        g1.addArc(3, 0, 1);
        g1.addArc(3, 1, 2);
        g1.addArc(3, 2, 2);
        g1.addArc(3, 4, 4);
        g1.addArc(4, 0, 4);
        g1.addArc(4, 1, 3);
        g1.addArc(4, 2, 2);
        g1.addArc(4, 3, 4);

        System.out.println(calcular(g1,9));

    }


}
