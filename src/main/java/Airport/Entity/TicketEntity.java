package Airport.Entity;

/**
 * Created by Olechka on 06.04.2017.
 */
public class TicketEntity {
    private int id_ticket;
    private  int id_flight;
    private  int cost;
    private  int place;

    public int getId_ticket() {
        return id_ticket;
    }

    public int getId_flight() {
        return id_flight;
    }

    public int getCost() {
        return cost;
    }

    public int getPlace() {
        return place;
    }

    public void setId_ticket(int id_ticket) {
        this.id_ticket = id_ticket;
    }

    public void setId_flight(int id_flight) {
        this.id_flight = id_flight;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setPlace(int place) {
        this.place = place;
    }
}

