package Airport.Entity;

/**
 * Created by Olechka on 06.04.2017.
 */
public class CityEntity {
    private int id_city;
    private int id_destination;
    private int code_country;
    private String city;


    public int getId_city() {
        return id_city;
    }

    public int getId_destination() {
        return id_destination;
    }

    public int getCode_country() {
        return code_country;
    }

    public String getCity() {
        return city;
    }

    public void setId_city(int id_city) {
        this.id_city = id_city;
    }

    public void setId_destination(int id_destination) {
        this.id_destination = id_destination;
    }

    public void setCode_country(int code_country) {
        this.code_country = code_country;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
