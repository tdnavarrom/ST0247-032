/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
 * @author Tomas Navarro & Pablo Correa
 * 
 */
public class Punto1 {

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

}