package Airport.Entity;

import javax.swing.text.html.parser.Entity;

/**
 * Created by Olechka on 06.04.2017.
 */
public class AirplaneEntity {

    private int id_airplane;
    private String model;
    private String airline;
    private int place_number;



    public int getId_airplane() {
        return id_airplane;
    }
    public String getModel() {
        return model;
    }
    public String getAirline() {
        return airline;
    }

    public int getPlace_number() {
        return place_number;
    }

    public void setId_airplane(int id_airplane) {
        this.id_airplane = id_airplane;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public void setPlace_number(int place_number) {
        this.place_number = place_number;
    }
}
