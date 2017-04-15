package Airport.DAO;



import Airport.Entity.CityEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Olechka on 13.04.2017.
 */
public class CityDao {

    private static final String url = "jdbc:mysql://localhost:3306/airport";
    private static final String username = "root";
    private static final String password = "123654";


    public void deleteById(int id) {
        try (Connection connect = DriverManager.getConnection ( url, username, password );
             PreparedStatement preparedStatement = connect.prepareStatement ( "DELETE FROM city WHERE ID = ?" )) {
            preparedStatement.setInt ( 1, id );
            preparedStatement.executeUpdate ();
            preparedStatement.close ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }

    public List<CityEntity> getAll() {
        List<CityEntity> allCity = new ArrayList<> ( );
        try (Connection connect = DriverManager.getConnection ( url, username, password );
             PreparedStatement preparedStatement = connect.prepareStatement ( "SELECT * FROM city" );
             ResultSet resultSet = preparedStatement.executeQuery ()) {

             while (resultSet.next ()) {
                 CityEntity cityEntity = new CityEntity ();
                 cityEntity.setId_city ( resultSet.getInt ( "Id_city" ) );
                 cityEntity.setId_destination ( resultSet.getInt ( "Id_destination" ) );
                 cityEntity.setCode_country ( resultSet.getInt ( "Code_country" ) );
                 cityEntity.setCity ( resultSet.getString ( "City" ) );
                 allCity.add ( new CityEntity () );
             }
        } catch (SQLException e) {
            System.out.println ( "Can not load" );
            e.printStackTrace ();
            return new ArrayList<> ();
        }
        return allCity;
    }

    public CityEntity getById(int id) {
        CityEntity cityEntity = null;
        ResultSet resultSet = null;
        try (Connection connect = DriverManager.getConnection ( url, username, password );
             PreparedStatement preparedStatement = connect.prepareStatement ("SELECT * FROM city WHERE ID = ?" )){
             preparedStatement.setInt (1,id);
             resultSet = preparedStatement.executeQuery ();
             cityEntity= new CityEntity ();
             cityEntity.setId_city (resultSet.getInt ( "Id_city" ));
             cityEntity.setId_destination ( resultSet.getInt ( "Id_destination" ) );
             cityEntity.setCode_country ( resultSet.getInt ( "Code_country" ) );
             cityEntity.setCity ( resultSet.getString ( "City" ) );

        } catch (SQLException e) {
            e.printStackTrace ();
        } finally {
            try {
                resultSet.close ();
            } catch (SQLException e) {
                e.printStackTrace ();
            }
        }
        return cityEntity;
    }


    public void save(CityEntity cityEntity) {
        try(Connection connect = DriverManager.getConnection ( url, username, password );
            PreparedStatement preparedStatement = connect.prepareStatement ( "INSERT INTO city VALUES (?,?,?,?)" )){
            preparedStatement.setInt ( 1,cityEntity.getId_city () );
            preparedStatement.setInt ( 2,cityEntity.getId_destination () );
            preparedStatement.setInt ( 3,cityEntity.getCode_country () );
            preparedStatement.setString ( 4,cityEntity.getCity () );
            preparedStatement.executeQuery ();
            preparedStatement.close ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }

    public void update(CityEntity cityEntity) {
        try (Connection connect = DriverManager.getConnection ( url, username, password );
             PreparedStatement preparedStatement = connect.prepareStatement ( "UPDATE city SET Voyage_id=?," +
                     "Class = ?, Passenger_id = ?, Seat_number = ? WHERE ID = ?" )){
            preparedStatement.setInt ( 1,cityEntity.getId_city () );
            preparedStatement.setInt ( 2,cityEntity.getId_destination () );
            preparedStatement.setInt ( 3,cityEntity.getCode_country () );
            preparedStatement.setString ( 4,cityEntity.getCity () );
            preparedStatement.close ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }


}


