import javafx.util.Pair;
import java.util.LinkedList;

public class Vertices {

    private int id;
    private double cord_x, cord_y;
    private String place;
    LinkedList<Pair<Integer,Arcos>> succesors;

    public Vertices(int id, double cord_x, double cord_y, String place){
        this.id = id;
        this.cord_x = cord_x;
        this.cord_y = cord_y;
        this.place = place;
        this.succesors= new LinkedList<Pair<Integer, Arcos>>();
    }

    public void addSuccesor(int id_v,Arcos a){
        succesors.add(new Pair<>(id_v,a));
    }

}
