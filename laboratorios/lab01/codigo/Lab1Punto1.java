import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class Lab1Punto1 {

    public static void main(String[] args)
    {

        HashMap<Integer, Vertices> hmap = new HashMap<Integer, Vertices>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("medellin_colombia-grande.txt"));
            String str_line = reader.readLine(); // salta la info
            str_line = reader.readLine();


            while (str_line != null){
                String[] linea_particionada = str_line.split(" ");
                String place = "";

                if (str_line.isEmpty()) { //revisa si la linea esta vacia
                    str_line = reader.readLine();
                    break;
                }

                if ((linea_particionada.length >= 4)) {
                    for (int i = 3; i < linea_particionada.length;i++) {
                        place += " " + linea_particionada[i];
                    }
                }

                int id_temp = (int)Double.parseDouble(linea_particionada[0]);
                double cord_x_temp = Double.parseDouble(linea_particionada[1]);
                double cord_y_temp = Double.parseDouble(linea_particionada[2]);

                Vertices vertex = new Vertices(id_temp,cord_x_temp,cord_y_temp,place);
                hmap.put(id_temp, vertex);

                str_line = reader.readLine();
            }

            str_line = reader.readLine(); // Esta linea salta la info.

            while (str_line != null){

                String [] linea_particionada = str_line.split(" ");

                int id_temp_s = (int) Double.parseDouble(linea_particionada[0]);
                int id_temp_e = (int) Double.parseDouble(linea_particionada[1]);
                double d_temp = Double.parseDouble(linea_particionada[2]);

                String place = "";

                if ((linea_particionada.length >= 4)) {
                    for (int i =3; i < linea_particionada.length;i++) place += " " + linea_particionada[i];
                }

                Vertices vertice = hmap.get(id_temp_s);
                Arcos arc = new Arcos(id_temp_s,id_temp_e,d_temp,place);
                vertice.addSuccesor(id_temp_e,arc);

                str_line = reader.readLine();

            }

            reader.close();

            System.out.println("Elements added to data structure.");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
