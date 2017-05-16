package Airport.Entity;

/**
 * Created by Olechka on 06.04.2017.
 */
public class FlightEntity {
    private   int id_flight;
    private   int id_airplane;
    private   int id_ticket;
    private   int id_destination;
    private   int departure_data;
    private   int departure_time;
    private   int arrival_data;
    private   int arrival_time;
    private   int aircraft_number;

    public int getId_flight() {
        return id_flight;
    }

    public int getId_airplane() {
        return id_airplane;
    }

    public int getId_ticket() {
        return id_ticket;
    }

    public int getId_destination() {
        return id_destination;
    }

    public int getDeparture_data() {
        return departure_data;
    }

    public int getDeparture_time() {
        return departure_time;
    }

    public int getArrival_data() {
        return arrival_data;
    }

    public int getArrival_time() {
        return arrival_time;
    }

    public int getAircraft_number() {
        return aircraft_number;
    }

    public void setId_flight(int id_flight) {
        this.id_flight = id_flight;
    }

    public void setId_airplane(int id_airplane) {
        this.id_airplane = id_airplane;
    }

    public void setId_ticket(int id_ticket) {
        this.id_ticket = id_ticket;
    }

    public void setId_destination(int id_destination) {
        this.id_destination = id_destination;
    }

    public void setDeparture_data(int departure_data) {
        this.departure_data = departure_data;
    }

    public void setDeparture_time(int departure_time) {
        this.departure_time = departure_time;
    }

    public void setArrival_data(int arrival_data) {
        this.arrival_data = arrival_data;
    }

    public void setArrival_time(int arrival_time) {
        this.arrival_time = arrival_time;
    }

    public void setAircraft_number(int aircraft_number) {
        this.aircraft_number = aircraft_number;
    }
}
