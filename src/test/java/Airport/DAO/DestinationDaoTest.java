package Airport.DAO;

import Airport.Entity.DestinationEntity;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Olechka on 15.04.2017.
 */
public class DestinationDaoTest {

    DestinationDao destinationDao;

    @Before
    public void init(){
        destinationDao = new DestinationDao ();
    }

    @Test
    public void deleteById()throws Exception{
    }
    @Test
    public void getAll()throws Exception{
        List<DestinationEntity> list = destinationDao.getAll ();
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