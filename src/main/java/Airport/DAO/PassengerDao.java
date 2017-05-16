package Airport.DAO;


import Airport.Entity.PassengerEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Olechka on 07.05.2017.
 */
public class PassengerDao {
    private static final String url = "jdbc:mysql://localhost:3306/airport";
    private static final String username = "root";
    private static final String password = "123654";


    public void deleteById(int id_passenger) {
        try (Connection connect = DriverManager.getConnection ( url, username, password );
             PreparedStatement preparedStatement = connect.prepareStatement ( "DELETE FROM passenger WHERE ID = ?" )) {
            preparedStatement.setInt ( 1, id_passenger );
            preparedStatement.executeUpdate ();
            preparedStatement.close ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }

    public List<PassengerEntity> getAll() {
        List<PassengerEntity> allPassenger = new ArrayList<> ();
        try (Connection connect = DriverManager.getConnection ( url, username, password );
             PreparedStatement preparedStatement = connect.prepareStatement ( "SELECT * FROM passenger" );
             ResultSet resultSet = preparedStatement.executeQuery ()) {

            while (resultSet.next ()) {
                PassengerEntity passengerEntity = new PassengerEntity ();
                passengerEntity.setId_passenger ( resultSet.getInt ( "id_passenger" ) );
                passengerEntity.setId_ticket ( resultSet.getInt ( "id_ticket" ) );
                passengerEntity.setSurname ( resultSet.getString ( "surname" ) );
                passengerEntity.setName ( resultSet.getString ( "name" ) );
                passengerEntity.setMiddle_name ( resultSet.getString ( "middle_name" ) );
                passengerEntity.setSex ( resultSet.getString ( "sex" ) );
                passengerEntity.setData_of_birthday ( resultSet.getString ( "data_of_birthday" ) );
                passengerEntity.setResidense ( resultSet.getString ( "residense" ) );
                passengerEntity.setPassport_data ( resultSet.getString ( "passport_data" ) );

                allPassenger.add ( new PassengerEntity () );
            }
        } catch (SQLException e) {
            System.out.println ( "Can not load" );
            e.printStackTrace ();
            return new ArrayList<> ();
        }
        return allPassenger;
    }

    public PassengerEntity getById(int id) {
        PassengerEntity passengerEntity = null;
        ResultSet resultSet = null;
        try (Connection connect = DriverManager.getConnection ( url, username, password );
             PreparedStatement preparedStatement = connect.prepareStatement ( "SELECT * FROM passenger WHERE ID = ?" )) {
            preparedStatement.setInt ( 1, id );
            resultSet = preparedStatement.executeQuery ();
            passengerEntity = new PassengerEntity ();
            passengerEntity.setId_passenger ( resultSet.getInt ( "id_passenger" ) );
            passengerEntity.setId_ticket ( resultSet.getInt ( "id_ticket" ) );
            passengerEntity.setSurname ( resultSet.getString ( "surname" ) );
            passengerEntity.setName ( resultSet.getString ( "name" ) );
            passengerEntity.setMiddle_name ( resultSet.getString ( "middle_name" ) );
            passengerEntity.setSex ( resultSet.getString ( "sex" ) );
            passengerEntity.setData_of_birthday ( resultSet.getString ( "data_of_birthday" ) );
            passengerEntity.setResidense ( resultSet.getString ( "residense" ) );
            passengerEntity.setPassport_data ( resultSet.getString ( "passport_data" ) );

        } catch (SQLException e) {
            e.printStackTrace ();
        } finally {
            try {
                resultSet.close ();
            } catch (SQLException e) {
                e.printStackTrace ();
            }
        }
        return passengerEntity;
    }


    public void save(PassengerEntity passengerEntity) {
        try (Connection connect = DriverManager.getConnection ( url, username, password );
             PreparedStatement preparedStatement = connect.prepareStatement ( "INSERT INTO passenger VALUES (?,?,?,?,?,?,?,?,?)" )) {
            preparedStatement.setInt ( 1, passengerEntity.getId_passenger () );
            preparedStatement.setInt ( 2, passengerEntity.getId_ticket () );
            preparedStatement.setString ( 3, passengerEntity.getSurname () );
            preparedStatement.setString ( 4, passengerEntity.getName () );
            preparedStatement.setString ( 5, passengerEntity.getMiddle_name () );
            preparedStatement.setString ( 6, passengerEntity.getSex () );
            preparedStatement.setString ( 7, passengerEntity.getData_of_birthday () );
            preparedStatement.setString ( 8, passengerEntity.getResidense () );
            preparedStatement.setString ( 9, passengerEntity.getPassport_data () );
            preparedStatement.executeQuery ();
            preparedStatement.close ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }

    public void update(PassengerEntity passengerEntity) {
        try (Connection connect = DriverManager.getConnection ( url, username, password );
             PreparedStatement preparedStatement = connect.prepareStatement ( "UPDATE passenger SET id_passenger = ?,id_ticket = ?," +
                     "surname = ?, name=?,middle_name = ?, sex=?,data_of_birthday=?, residense = ?,passport_data=? WHERE ID = ?" )) {
            preparedStatement.setInt ( 1, passengerEntity.getId_passenger () );
            preparedStatement.setInt ( 2, passengerEntity.getId_ticket () );
            preparedStatement.setString ( 3, passengerEntity.getSurname () );
            preparedStatement.setString ( 4, passengerEntity.getName () );
            preparedStatement.setString ( 5, passengerEntity.getMiddle_name () );
            preparedStatement.setString ( 6, passengerEntity.getSex () );
            preparedStatement.setString ( 7, passengerEntity.getData_of_birthday () );
            preparedStatement.setString ( 8, passengerEntity.getResidense () );
            preparedStatement.setString ( 9, passengerEntity.getPassport_data () );

            preparedStatement.close ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }

}
