package Airport.Entity;

/**
 * Created by Olechka on 06.04.2017.
 */
public class AirplaneEntity {

    private int id_airplane;
    private String model;
    private String airline;

    public void setId_airplane(int id_airplane) {
        this.id_airplane = id_airplane;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public int getId_airplane() {
        return id_airplane;
    }
    public String getModel() {
        return model;
    }

    public String getAirline() {
        return airline;
    }
}
