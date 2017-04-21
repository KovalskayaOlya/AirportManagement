package Airport.DAO;

import Airport.Entity.TicketEntity;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Olechka on 21.04.2017.
 */
public class TicketDaoTest {

    private TicketDao ticketDao;
    private FlightDao flightDao;

    @Before
    public void init(){
        ticketDao = new TicketDao ();
    }

    @Test
    public void deleteById()throws Exception{
    }
    @Test
    public void getAll()throws Exception{
        List<TicketEntity> list = ticketDao.getAll ();
        System.out.println (list);
    }
    @Test
    public void getById()throws Exception{
//        TicketEntity ticketEntity = ticketDao.getById ( 1 );
//        assertEquals ( "111XA",ticketEntity.getId_flight () );
//        System.out.println (ticketEntity);
    }
    @Test
    public void save()throws Exception{
//        TicketEntity ticketEntity = ticketDao.getById ( 1 );
//        assertEquals("01",ticketEntity.getPlace ());
    }
    @Test
    public void update()throws Exception{
    }
}


