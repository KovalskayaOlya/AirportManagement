package Airport.Entity;

/**
 * Created by Olechka on 11.05.2017.
 */
public class PassengerEntity {

    private int id_passenger;
    private int id_ticket;
    private String surname;
    private  String name;
    private  String middle_name;
    private  String sex;
    private String residense;
    private String passport_data;

    public int getId_passenger() {
        return id_passenger;
    }

    public int getId_ticket() {
        return id_ticket;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public String getSex() {
        return sex;
    }

    public String getResidense() {
        return residense;
    }

    public String getPassport_data() {
        return passport_data;
    }

    public void setId_passenger(int id_passenger) {
        this.id_passenger = id_passenger;
    }

    public void setId_ticket(int id_ticket) {
        this.id_ticket = id_ticket;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setResidense(String residense) {
        this.residense = residense;
    }

    public void setPassport_data(String passport_data) {
        this.passport_data = passport_data;
    }
}

