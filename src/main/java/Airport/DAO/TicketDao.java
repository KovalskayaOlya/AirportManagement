package Airport.DAO;

import Airport.Entity.TicketEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Olechka on 13.04.2017.
 */
public class TicketDao {
    private static final String url = "jdbc:mysql://localhost:3306/airport";
    private static final String username = "root";
    private static final String password = "123654";


    public void deleteById(TicketEntity idTicket) {
        try (Connection connect = DriverManager.getConnection ( url, username, password );
             PreparedStatement preparedStatement = connect.prepareStatement ( "DELETE FROM ticket WHERE ID = ?" )) {
            preparedStatement.setInt (idTicket.getId_ticket (),1);
            preparedStatement.executeUpdate ();
            preparedStatement.close ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }

    public List<TicketEntity> getAll() {
        List<TicketEntity> allTicket= new ArrayList<> ( );
        try (Connection connect = DriverManager.getConnection ( url, username, password );
             PreparedStatement preparedStatement = connect.prepareStatement ( "SELECT * FROM ticket" );
             ResultSet resultSet = preparedStatement.executeQuery ()) {

            while (resultSet.next ()) {
                TicketEntity ticketEntity = new TicketEntity ();
                ticketEntity.setId_ticket ( resultSet.getInt ( "Id_ticket") );
                ticketEntity.setId_flight ( resultSet.getInt ( "Id_flight" ) );
                ticketEntity.setCost ( resultSet.getInt ( "Cost" ) );
                ticketEntity.setPlace ( resultSet.getInt ( "Place" ) );
                allTicket.add ( new TicketEntity () );
            }
        } catch (SQLException e) {
            System.out.println ( "Can not load" );
            e.printStackTrace ();
            return new ArrayList<> ();
        }
        return allTicket;
    }

    public TicketEntity getById(int id) {
       TicketEntity ticketEntity = null;
        ResultSet resultSet = null;
        try (Connection connect = DriverManager.getConnection ( url, username, password );
             PreparedStatement preparedStatement = connect.prepareStatement ("SELECT * FROM ticket WHERE ID = ?" )){
            preparedStatement.setInt (1,id);
            resultSet = preparedStatement.executeQuery ();
            ticketEntity = new TicketEntity ();
            ticketEntity.setId_ticket ( resultSet.getInt ( "Id_ticket" ) );
            ticketEntity.setId_flight ( resultSet.getInt (  "Id_flight") );
            ticketEntity.setCost ( resultSet.getInt ( "Cost" ) );
            ticketEntity.setPlace ( resultSet.getInt ( "Place" ) );

        } catch (SQLException e) {
            e.printStackTrace ();
        } finally {
            try {
                resultSet.close ();
            } catch (SQLException e) {
                e.printStackTrace ();
            }
        }
        return ticketEntity;
    }


    public void save(TicketEntity ticketEntity) {
        try(Connection connect = DriverManager.getConnection ( url, username, password );
            PreparedStatement preparedStatement = connect.prepareStatement ( "INSERT INTO ticket VALUES (?,?,?,?)" )){
            preparedStatement.setInt ( 1,ticketEntity.getId_ticket () );
            preparedStatement.setInt ( 2,ticketEntity.getId_flight () );
            preparedStatement.setInt ( 3,ticketEntity.getCost () );
            preparedStatement.setInt ( 4,ticketEntity.getPlace () );
            preparedStatement.executeQuery ();
            preparedStatement.close ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }

    public void update(TicketEntity ticketEntity) {
        try (Connection connect = DriverManager.getConnection ( url, username, password );
             PreparedStatement preparedStatement = connect.prepareStatement ( "UPDATE ticket SET Voyage_id=?," +
                     "Class = ?, Passenger_id = ?, Seat_number = ? WHERE ID = ?" )){
            preparedStatement.setInt ( 1,ticketEntity.getId_ticket () );
            preparedStatement.setInt ( 2,ticketEntity.getId_flight () );
            preparedStatement.setInt ( 3,ticketEntity.getCost () );
            preparedStatement.setInt ( 4,ticketEntity.getPlace () );
            preparedStatement.close ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }


}
