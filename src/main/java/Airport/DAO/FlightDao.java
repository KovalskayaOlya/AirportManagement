package Airport.DAO;

import Airport.Entity.FlightEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Olechka on 13.04.2017.
 */
public class FlightDao {
    private static final String url = "jdbc:mysql://localhost:3306/airport";
    private static final String username = "root";
    private static final String password = "123654";


    public void deleteById(int id) {
        try (Connection connect = DriverManager.getConnection ( url, username, password );
             PreparedStatement preparedStatement = connect.prepareStatement ( "DELETE FROM flight WHERE ID = ?" )) {
            preparedStatement.setInt ( 1, id );
            preparedStatement.executeUpdate ();
            preparedStatement.close ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }

    public List<FlightEntity> getAll() {
        List<FlightEntity> allFlight = new ArrayList<> ();
        try (Connection connect = DriverManager.getConnection ( url, username, password );
             PreparedStatement preparedStatement = connect.prepareStatement ( "SELECT * FROM flight" );
             ResultSet resultSet = preparedStatement.executeQuery ()) {

            while (resultSet.next ()) {
                FlightEntity flightEntity = new FlightEntity ();
                flightEntity.setId_flight ( resultSet.getInt ( "Id_flight" ) );
                flightEntity.setId_airplane ( resultSet.getInt ( "Id_airplane" ) );
                flightEntity.setId_ticket ( resultSet.getInt ( "Id_ticket" ) );
                flightEntity.setId_destination ( resultSet.getInt ( "Id_destination" ) );
                flightEntity.setDeparture_data ( resultSet.getInt ( "Departure_data" ) );
                flightEntity.setDeparture_time ( resultSet.getInt ( "Departure_time" ) );
                flightEntity.setArrival_data ( resultSet.getInt ( "Arrival_data" ) );
                flightEntity.setArrival_time ( resultSet.getInt ( "Arrival_time" ) );
                flightEntity.setAircraft_number ( resultSet.getInt ( "Aircraft_number" ) );
                allFlight.add ( new FlightEntity () );
            }
        } catch (SQLException e) {
            System.out.println ( "Can not load" );
            e.printStackTrace ();
            return new ArrayList<> ();
        }
        return allFlight;
    }

    public FlightEntity getById(int id) {
        FlightEntity flightEntity = null;
        ResultSet resultSet = null;
        try (Connection connect = DriverManager.getConnection ( url, username, password );
             PreparedStatement preparedStatement = connect.prepareStatement ( "SELECT * FROM flight WHERE ID = ?" )) {
            preparedStatement.setInt ( 1, id );
            resultSet = preparedStatement.executeQuery ();
            flightEntity = new FlightEntity ();
            flightEntity.setId_flight ( resultSet.getInt ( "Id_flight" ) );
            flightEntity.setId_airplane ( resultSet.getInt ( "Id_airplane" ) );
            flightEntity.setId_ticket ( resultSet.getInt ( "Id_tocket" ) );
            flightEntity.setId_destination ( resultSet.getInt ( "Id_destination" ) );
            flightEntity.setDeparture_data ( resultSet.getInt ( "Departure_data" ) );
            flightEntity.setDeparture_time ( resultSet.getInt ( "Departure_time" ) );
            flightEntity.setArrival_data ( resultSet.getInt ( "Arrival_data" ) );
            flightEntity.setArrival_time ( resultSet.getInt ( "Arrival_time" ) );
            flightEntity.setAircraft_number ( resultSet.getInt ( "Aircraft_number" ) );
        } catch (SQLException e) {
            e.printStackTrace ();
        } finally {
            try {
                resultSet.close ();
            } catch (SQLException e) {
                e.printStackTrace ();
            }
        }
        return flightEntity;
    }


    public void save(FlightEntity flightEntity) {
        try (Connection connect = DriverManager.getConnection ( url, username, password );
             PreparedStatement preparedStatement = connect.prepareStatement ( "INSERT INTO flight VALUES (?,?,?,?,?,?,?,?,?)" )) {
            preparedStatement.setInt ( 1, flightEntity.getId_flight () );
            preparedStatement.setInt ( 2, flightEntity.getId_airplane () );
            preparedStatement.setInt ( 3, flightEntity.getId_ticket () );
            preparedStatement.setInt ( 4, flightEntity.getId_destination () );
            preparedStatement.setInt ( 5, flightEntity.getDeparture_data () );
            preparedStatement.setInt ( 6, flightEntity.getDeparture_time () );
            preparedStatement.setInt ( 7, flightEntity.getArrival_data () );
            preparedStatement.setInt ( 8, flightEntity.getArrival_time () );
            preparedStatement.setInt ( 9, flightEntity.getAircraft_number () );
            preparedStatement.executeQuery ();
            preparedStatement.close ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }

    public void update(FlightEntity flightEntity) {
        try (Connection connect = DriverManager.getConnection ( url, username, password );
             PreparedStatement preparedStatement = connect.prepareStatement ( "UPDATE flight SET id_flight=?,id_airplane=?,id_ticket=?," +
                     "id_destination=?,departure_data=?,departure_time=?,arrival_data=?,arrival_time=?,aircraft_number=? WHERE ID = ?" )) {
            preparedStatement.setInt ( 1, flightEntity.getId_flight () );
            preparedStatement.setInt ( 2, flightEntity.getId_airplane () );
            preparedStatement.setInt ( 3, flightEntity.getId_ticket () );
            preparedStatement.setInt ( 4, flightEntity.getId_destination () );
            preparedStatement.setInt ( 5, flightEntity.getDeparture_data () );
            preparedStatement.setInt ( 6, flightEntity.getDeparture_time () );
            preparedStatement.setInt ( 7, flightEntity.getArrival_data () );
            preparedStatement.setInt ( 8, flightEntity.getArrival_time () );
            preparedStatement.setInt ( 9, flightEntity.getAircraft_number () );

            preparedStatement.close ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }

}
