import java.util.Scanner;

/**
 *
 * @author Tomas Navarro & Pablo Correa
 * 
 */

public class Punto2Lab5 {
    
    public static int heldKarp(Digraph g) {
        
        int size = g.size();
        int[][] values = new int[n][(int) Math.pow(2, size - 1)];
        int[][] previous = new int[n][(int) Math.pow(2, size - 1)];
        for (int i = 0; i < size; ++i) {
            values[i][0] = g.getWeight(0, i);
            previous[i][0] = 0;
        }
        for (int j = 1; j < (int) Math.pow(2, size - 1); ++j) {
            for (int i = 1; i < size; ++i) {
                if (i == j) {
                    values[i][j] = 0;
                } else {
                    int tempValue = (j - 1) - i;
                    if (j > size && tempValue > 0 && tempValue < size) {
                        values[i][j] = 0;
                        values[tempValue][j] = 0;
                    } else {
                        if (j < size) {
                            values[i][j] = values[j][0] + g.getWeight(j, i);
                        }else{
                            int tempValue2=j-i;
                            int tempValue3=j-tempValue2-1;
                            values[i][j] = Math.max(values[tempValue2][tempValue3]+g.getWeight(tempValue2,i),values[tempValue3][tempValue2]+g.getWeight(tempValue3,i));
                        }
                    }
                }

            }
        }
        return values[0][(int) Math.pow(2, n - 1)];
    }

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
            System.out.println("The shortest path has length " + heldKarp(grafo));
        }

    }
}
