package Airport.DAO;

import Airport.Entity.AirplaneEntity;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by Olechka on 15.04.2017.
 */
public class AirplaneDaoTest {
    AirplaneDao airplaneDao;

    @Before
    public void init(){
        airplaneDao = new AirplaneDao ();
    }

    @Test
    public void deleteById()throws Exception{
            }
    @Test
    public void getAll()throws Exception{
        List<AirplaneEntity> list = airplaneDao.getAll ();
        System.out.println (list);
    }
    @Test
    public void getById()throws Exception{
    }
    @Test
    public void save()throws Exception{
        AirplaneEntity airplaneEntity = airplaneDao.getById ( 1 );

    }
    @Test
    public void update()throws Exception{
    }
    }