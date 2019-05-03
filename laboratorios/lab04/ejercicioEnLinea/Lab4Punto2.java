  
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
 *
 * @author Tomas Navarro, Pablo Correa
 */
import java.util.Arrays;
import java.util.Scanner;


public class Lab4Punto2 {

    
    public static void main(String [] args){
        read();
    }

    private static void read (){

        Scanner console = new Scanner(System.in);
        int a = console.nextInt();
        while (a!=0){
            int b = console.nextInt();
            int c = console.nextInt();
            int [] morning = new int[n];
            int [] afternoon = new int[n];
            int extra_hour = 0, extra_pay=0;

            for (int i = 0; i < n; i++) morning[i]= console.nextInt();
            for (int i = 0; i < n; i++) afternoon[i]= console.nextInt();


            Arrays.sort(morning);
            Arrays.sort(afternoon);

            for (int i = 0; i < n; i++)
                extra_hour += (morning[i] + afternoon[a-i-1]) - b;

            extra_pay = extra_hour * c;
            System.out.println(extra_pay);
            a = console.nextInt();

        }

    }
}
