
/**
 * Taller9
 * 
 * Por Tomas Navarro & Pablo Correa
 */
public class Taller9 {

    public static int lavenshtein(String a, String b) {
      int a_length = a.length() + 1;
      int b_length = b.length() + 1;
      int [][] matrix = new int[a_length][b_length];
  
      for(int i = 0; i < a_length; i++){
        matrix[i][0] = i;
      }
  
      for(int j = 0; j < b_length; j++){
        matrix[0][j] = j;
      }
  
      for(int j = 1; j < b_length; j++){
        for(int i = 1; i < a_length; i++){
          if(a.charAt(i - 1)==b.charAt(j - 1)){
            matrix[i][j] = matrix[i - 1][j - 1];
          }else{
            matrix[i][j] = Math.min(matrix[i - 1][j - 1] + 1, Math.min(matrix[i][j - 1] + 1, matrix[i - 1][j] + 1));
          }
        }
      }
  
      return matrix[a_length - 1][b_length - 1];
  
    }
  }
  