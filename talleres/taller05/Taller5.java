/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller;

import java.util.ArrayList;

/**
 * Clase en la cual se implementan los metodos del Taller 5
 * 
 * @author Tomas Navarro, Pablo Correa
 */
public class Taller5 {


	/**
	* Metodo que dado un grafo y un numero m, se asigna un color
	* a cada nodo, de manera que dos nodos adyacentes no poseean el mismo color
	* @param g grafo dado 
	* @param m numero de colores
	* @return true si es posible, false de lo contrario
	*/
	public static boolean mColoring(Digraph g, int m) {
		int[]colores = new int[g.size()];
                boolean x = mColoring(g, 0, colores, m);
                return x;
	}

	/**
	* Metodo que dado un grafo y un vertice v, intenta asignar un color
	* al nodo, de manera que dos nodos adyacentes no poseean el mismo color
	* @param g grafo dado 
	* @param m numero de colores
	* @param v vertice 
	* @param colors conjunto de colores
	* @return true si es posible, false de lo contrario
	*/
	private static boolean mColoring(Digraph g, int v, int[] colors, int m) {
		if (v == g.size()) return true;
                else{
                    for(int i = 1; i <= m; i++){
                        colors[v] = i;
                        if(!isSafe(g,v,colors)) return mColoring(g,v+1,colors,m);
                    }
                }
                return false;
	}

	/**
	* Metodo que dado un grafo y un vertice v, intenta asignar un color colors en la 
	* posicion c al nodo v, de manera que dos nodos adyacentes no poseean el mismo color
	* @param g grafo dado 
	* @param c indice de colores
	* @param v vertice 
	* @param colors conjunto de colores
	* @return true si es posible, false de lo contrario
	*/
	private static boolean isSafe(Digraph g, int v, int[] colors) {
		ArrayList <Integer> successors = g.getSuccessors(v);
                for(int i = 0; i < successors.size(); i++){
                    if(colors[successors.get(i)] == colors[v]) return true;
                }
                return false;
	}

	

}