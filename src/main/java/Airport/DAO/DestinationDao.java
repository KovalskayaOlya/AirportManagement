package Airport.DAO;

import Airport.Entity.CityEntity;
import Airport.Entity.DestinationEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Olechka on 13.04.2017.
 */
public class DestinationDao {
    private static final String url = "jdbc:mysql://localhost:3306/airport";
    private static final String username = "root";
    private static final String password = "123654";


    public void deleteById(int id) {
        try (Connection connect = DriverManager.getConnection ( url, username, password );
             PreparedStatement preparedStatement = connect.prepareStatement ( "DELETE FROM destination WHERE ID = ?" )) {
            preparedStatement.setInt ( 1, id );
            preparedStatement.executeUpdate ();
            preparedStatement.close ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }

    public List<DestinationEntity> getAll() {
        List<DestinationEntity> allDestination= new ArrayList<> ( );
        try (Connection connect = DriverManager.getConnection ( url, username, password );
             PreparedStatement preparedStatement = connect.prepareStatement ( "SELECT * FROM destination" );
             ResultSet resultSet = preparedStatement.executeQuery ()) {

            while (resultSet.next ()) {
                DestinationEntity destinationEntity = new DestinationEntity ();
                destinationEntity.setId_destination ( resultSet.getInt ( "Id_destination" ) );
                destinationEntity.setId_flight ( resultSet.getInt ( "Id_flight" ) );
                destinationEntity.setId_city (resultSet.getInt ( "Id_city" )  );
                destinationEntity.setAirport_name ( resultSet.getString ( "Airport_name" ) );

                allDestination.add ( new DestinationEntity () );
            }
        } catch (SQLException e) {
            System.out.println ( "Can not load" );
            e.printStackTrace ();
            return new ArrayList<> ();
        }
        return allDestination;
    }

    public DestinationEntity getById(int id) {
        DestinationEntity destinationEntity = null;
        ResultSet resultSet = null;
        try (Connection connect = DriverManager.getConnection ( url, username, password );
             PreparedStatement preparedStatement = connect.prepareStatement ("SELECT * FROM destination WHERE ID = ?" )){
            preparedStatement.setInt (1,id);
            resultSet = preparedStatement.executeQuery ();
            destinationEntity = new DestinationEntity ();
            destinationEntity.setId_destination ( resultSet.getInt ( "Id_destination" ) );
            destinationEntity.setId_flight ( resultSet.getInt ( "Id_flight" ) );
            destinationEntity.setId_city ( resultSet.getInt ( "Id_city" ) );
            destinationEntity.setAirport_name ( resultSet.getString ( "Airport_name" ) );
        } catch (SQLException e) {
            e.printStackTrace ();
        } finally {
            try {
                resultSet.close ();
            } catch (SQLException e) {
                e.printStackTrace ();
            }
        }
        return destinationEntity;
    }


    public void save(DestinationEntity destinationEntity) {
        try(Connection connect = DriverManager.getConnection ( url, username, password );
            PreparedStatement preparedStatement = connect.prepareStatement ( "INSERT INTO destination VALUES (?,?,?,?)" )){
            preparedStatement.setInt ( 1,destinationEntity.getId_destination () );
            preparedStatement.setInt ( 2,destinationEntity.getId_flight () );
//            preparedStatement.setInt ( 3,destinationEntity.getId_city (  ) );
            preparedStatement.setString ( 4,destinationEntity.getAirport_name () );
            preparedStatement.executeQuery ();
            preparedStatement.close ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }

    public void update(DestinationEntity destinationEntity) {
        try (Connection connect = DriverManager.getConnection ( url, username, password );
             PreparedStatement preparedStatement = connect.prepareStatement ( "UPDATE destination SET Voyage_id=?," +
                     "Class = ?, Passenger_id = ?, Seat_number = ? WHERE ID = ?" )){
            preparedStatement.setInt ( 1,destinationEntity.getId_destination () );
            preparedStatement.setInt ( 2,destinationEntity.getId_flight () );
//            preparedStatement.setInt ( 3,destinationEntity.getId_city ( ) );
            preparedStatement.setString ( 4,destinationEntity.getAirport_name () );
            preparedStatement.close ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }
}
