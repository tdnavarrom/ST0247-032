import java.util.ArrayList;

/**
 * Clase en la cual se implementan los metodos del Taller 3
 *
 * @author Tomas Navarro, Pablo Correa
 */
public class Taller3 {


    private static boolean siSeAtacan (int [] tablero,int x) {
        for (int i=0; i < x - 1; i++)
            for (int j=i+1; j < x; j++)
                if (Math.abs (tablero[i] - tablero[j]) == Math.abs(i - j))
                    return false;
        return true;
    }

    /**
     * Metodo auxiliar para llamar el metodo posterior
     *
     * @param  n numero de reinas
     * @return numero de soluciones
     */
    private static void nReinas(int n) {
        nReinas(n, new int[n],0);

    }

    private static boolean nReinas(int n, int[] tablero, int columna) {
        if (columna == n) {
            imprimirTablero(tablero);
            return true;
        }else if (siSeAtacan(tablero, columna)) nReinas(n, tablero, columna + 1);
         else if (!(siSeAtacan(tablero, columna + 1))) return false;

        return false;
    }

    public static void imprimirTablero(int[] tablero) {
        int n = tablero.length;
        System.out.print("    ");
        for (int i = 0; i < n; ++i)
            System.out.print(i + " ");
        System.out.println("\n");
        for (int i = 0; i < n; ++i) {
            System.out.print(i + "   ");
            for (int j = 0; j < n; ++j)
                System.out.print((tablero[i] == j ? "Q" : "#") + " ");
            System.out.println();
        }
        System.out.println();
    }


    public static void main(String[] args) {
        nReinas(10);
    }

}