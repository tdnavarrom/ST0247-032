
import java.util.Random;

/**
 * Clase en la cual se implementan los metodos del Taller 12
 *
 * @author Tomas Navarro, Pablo Correa
 */

public class Taller12 {

    public static void main(String[] args) {
        pintTablero(HillClimb(4),4);
    }

    static class Queen<F, S> {

        public final F row;
        public final S col;

        public Queen(F row, S col) {
            this.row = row;
            this.col = col;
        }

    }

    public static int[] HillClimb(int n) {
        int[] table = new int[n];
        int heuristica =Integer.MAX_VALUE;
        Queen temp = new Queen(Integer.MAX_VALUE, tablero.clone());

        while (heuristica!= 0){
            table = generateBoard(n);
            for (int i = 0; i < n; i++) {
                int start = tablero[i];
                for (int j = 0; j < n; j++) {
                    table[i] = j;
                    heuristica = reinasAtacandose(tablero);
                    if (heuristica == 0) return tablero;
                    if ((int) temp.row > heuristica) temp = new Queen(heuristica, tablero.clone());
                    table[i] = start;
                }
                for (int j = 0; j < tablero.length; j++) {
                    table[j] = ((int[]) temp.col)[j];
                }
            }
        }
        return tablero;
    }

    public static int reinasAtacandose(int[] tablero) {
        int cont = 0;
        for (int i = 0; i < tablero.length - 1; ++i) {
            for (int j = i + 1; j < tablero.length; j++) {
                if (i==j||tablero[i]== tablero[j]||Math.abs(tablero[i] - tablero[j]) == Math.abs(i - j)){
                    cont++;
                }
            }
        }
        return cont;
    }

    public static int[] generateBoard(int n) {
        int [] startBoard = new int[n];
        Random rnd = new Random();
        for(int i=0; i<n; i++){
            startBoard[i] = rnd.nextInt(n);
        }
        return startBoard;
    }

    public static void printTablero(int[] tablero,int n) {
        System.out.print("  ");
        for (int i = 0; i < n; ++i) System.out.print(i + " ");
        System.out.print("\n");
        for (int i = 0; i < n; ++i) {
            System.out.print(i + " ");
            for (int j = 0; j < n; ++j) System.out.print((tablero[i] == j ? "Q" : "#") + " ");
            System.out.println();
        }
        System.out.println();
    }

}
