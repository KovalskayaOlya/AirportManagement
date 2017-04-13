package Airport.Entity;

/**
 * Created by Olechka on 06.04.2017.
 */
public class DestinationEntity {
    private int id_destination;
    private int id_flight;
    private int id_city;
    private String airport_name;

    public int getId_destination() {
        return id_destination;
    }

    public int getId_flight() {
        return id_flight;
    }

    public int getId_city() {
        return id_city;
    }

    public String getAirport_name() {
        return airport_name;
    }

    public void setId_destination(int id_destination) {
        this.id_destination = id_destination;
    }

    public void setId_flight(int id_flight) {
        this.id_flight = id_flight;
    }

    public void setId_city(int id_city) {
        this.id_city = id_city;
    }

    public void setAirport_name(String airport_name) {
        this.airport_name = airport_name;
    }
}
