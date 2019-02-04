public class Arcos {

    private  int id_start, id_end;
    private double distance;
    private String place;

    public Arcos(int id_start, int id_end, double distance, String place){
        this.id_start = id_start;
        this.id_end = id_end;
        this.distance = distance;
        this.place = place;
    }

    public int getIdStart(){
        return id_start;
    }

    public int getIdEnd(){
        return id_end;
    }

    public Double getDistance(){
        return distance;
    }

    public String getPlace(){
        return place;
    }
}
