package Airport.DAO;


import Airport.Entity.AirplaneEntity;
import Airport.Entity.CityEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Olechka on 13.04.2017.
 */
public class AirplaneDao {
    private static final String url = "jdbc:mysql://localhost:3306/airport";
    private static final String username = "root";
    private static final String password = "123654";


    public void deleteById(int id) {
        try (Connection connect = DriverManager.getConnection ( url, username, password );
             PreparedStatement preparedStatement = connect.prepareStatement ( "DELETE FROM airplane WHERE ID = ?" )) {
            preparedStatement.setInt ( 1, id );
            preparedStatement.executeUpdate ();
            preparedStatement.close ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }

    public List<AirplaneEntity> getAll() {
        List<AirplaneEntity> allAirplane= new ArrayList<> ( );
        try (Connection connect = DriverManager.getConnection ( url, username, password );
             PreparedStatement preparedStatement = connect.prepareStatement ( "SELECT * FROM airplane" );
             ResultSet resultSet = preparedStatement.executeQuery ()) {

            while (resultSet.next ()) {
                AirplaneEntity airplaneEntity = new AirplaneEntity ();
                airplaneEntity.setId_airplane ( resultSet.getInt ( "Id_airplane" ));
                airplaneEntity.setModel ( resultSet.getString ( "Model" ) );
                airplaneEntity.setAirline ( resultSet.getString ( "Airline" ) );
                allAirplane.add ( new AirplaneEntity () );
            }
        } catch (SQLException e) {
            System.out.println ( "Can not load" );
            e.printStackTrace ();
            return new ArrayList<> ();
        }
        return allAirplane;
    }

    public AirplaneEntity getById(int id) {
        AirplaneEntity airplaneEntity = null;
        ResultSet resultSet = null;
        try (Connection connect = DriverManager.getConnection ( url, username, password );
             PreparedStatement preparedStatement = connect.prepareStatement ("SELECT * FROM airplane WHERE ID = ?" )){
            preparedStatement.setInt (1,id);
            resultSet = preparedStatement.executeQuery ();
            airplaneEntity = new AirplaneEntity ();
            airplaneEntity.setId_airplane (resultSet.getInt ( "Id_airplane" )  );
            airplaneEntity.setModel ( resultSet.getString ( "Model" ) );
            airplaneEntity.setAirline ( resultSet.getString ( "Airline" ) );
        } catch (SQLException e) {
            e.printStackTrace ();
        } finally {
            try {
                resultSet.close ();
            } catch (SQLException e) {
                e.printStackTrace ();
            }
        }
        return airplaneEntity;
    }


    public void save(AirplaneEntity airplaneEntity) {
        try(Connection connect = DriverManager.getConnection ( url, username, password );
            PreparedStatement preparedStatement = connect.prepareStatement ( "INSERT INTO airplane VALUES (?,?,?,?)" )){
            preparedStatement.setInt ( 1,airplaneEntity.getId_airplane () );
            preparedStatement.setString ( 2,airplaneEntity.getModel () );
            preparedStatement.setString ( 3,airplaneEntity.getAirline () );
            preparedStatement.executeQuery ();
            preparedStatement.close ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }

    public void update(AirplaneEntity airplaneEntity) {
        try (Connection connect = DriverManager.getConnection ( url, username, password );
             PreparedStatement preparedStatement = connect.prepareStatement ( "UPDATE airplane SET Voyage_id=?," +
                     "Class = ?, Passenger_id = ?, Seat_number = ? WHERE ID = ?" )){
            preparedStatement.setInt ( 1,airplaneEntity.getId_airplane () );
            preparedStatement.setString ( 2,airplaneEntity.getModel () );
            preparedStatement.setString ( 3,airplaneEntity.getAirline () );
            preparedStatement.close ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }


}
