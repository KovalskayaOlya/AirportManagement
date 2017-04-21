package Airport.DAO;

import Airport.Entity.CityEntity;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Olechka on 15.04.2017.
 */
public class CityDaoTest {
    CityDao cityDao;
    @Before
    public void init(){
        cityDao = new CityDao ();
    }

    @Test
    public void deleteById()throws Exception{
    }
    @Test
    public void getAll()throws Exception{
        List<CityEntity> list = cityDao.getAll ();
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
