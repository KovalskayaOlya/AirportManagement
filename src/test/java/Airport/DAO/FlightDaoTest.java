package Airport.DAO;

import Airport.Entity.FlightEntity;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Olechka on 15.04.2017.
 */
public class FlightDaoTest {
    FlightDao flightDao;
    @Before
    public void init(){
        flightDao = new FlightDao ();
    }

    @Test
    public void deleteById()throws Exception{
    }
    @Test
    public void getAll()throws Exception{
        List<FlightEntity> list = flightDao.getAll ();
        System.out.println (list);
    }
    @Test
    public void getById()throws Exception{
    }
    @Test
    public void save()throws Exception{
    }
    @Test
    public void update()throws Exception{
    }

}