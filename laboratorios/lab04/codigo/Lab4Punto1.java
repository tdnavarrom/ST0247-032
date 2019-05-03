/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
 *
 * @author Tomas Navarro, Pablo Correa
 */
import java.util.*;
public class Lab4Punto1 {
    
    public static int salesman(Digraph g){
        int result = 0;
        int minCost = Integer.MAX_VALUE;
        int i = 0;
        boolean[]visited = new boolean[g.size];
        while(i!=g.size-1){
            ArrayList<Integer>successors = g.getSuccessors(x);
            for(int j = 0; j < successors.size(); j++){
                if(visited[j] == false && g.getWeight(i, successors.get(j)) < minCost){
                    minCost = g.getWeight(i, successors.get(j));
                    i = successors.get(j);
                    visited[j] = true;
                }
            }
            result += g.getWeight(i, successors.get(i));
        }
        return result;
    }
}