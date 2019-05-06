import java.util.Scanner;

/**
 *
 * @author Tomas Navarro & Pablo Correa
 * 
 */

public class Punto2Lab5 {

    public static void read () {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Pair<Integer, Integer>[] coordenates;
        int coord_x = sc.nextInt();
        int coord_y = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            int first_num = sc.nextInt();
            int second_num = sc.nextInt();

            Pair<Integer, Integer> posicionInicial = new Pair<>(first_num,second_num);
            int cont_desechos = sc.nextInt();
            DigraphAM grafo = new DigraphAM(cont_desechos + 1);

            coordenates = new Pair[cont_desechos + 1];
            coordenates[0] = posicionInicial;

            for (int j = 1; j <= cont_desechos; j++) {
                int numa = sc.nextInt();
                int numb = sc.nextInt();
                coordenates[j] = new Pair(numa,numb);
            }

            for (int k = 0; k <= cont_desechos; k++) {
                for (int j = 0; j <= cont_desechos; j++) {
                    if (k == j) continue;
                    
                    grafo.addArc(k, j, Math.abs(coordenates[k].first - coordenates[j].first)
                                    + Math.abs(coordenates[k].second - coordenates[j].second));
                }
            }
        }

    }
}