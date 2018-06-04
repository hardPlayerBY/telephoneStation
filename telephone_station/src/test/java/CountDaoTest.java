import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import com.telephone_station.api.dao.CountDao;
import com.telephone_station.dao.CountDaoImpl;
import com.telephone_station.datamodel.Count;

import static com.telephone_station.datamodel.CountState.ClOSE;
import static com.telephone_station.datamodel.CountState.OPEN;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class CountDaoTest {
    private static CountDao dao;
    @BeforeClass
    public static void init(){
        dao = new CountDaoImpl();
    }

    @AfterClass
    public static void finish(){
        dao = null;
    }

    @Test
    public void testDelete() {
        final Count team = dao.getAll().get(0);
        dao.delete(team);
        assertNull(dao.get(team.getId()));
    }

    @Test
    public void testGetAll() {
        final int initialRowsCount = dao.getAll().size();
        dao.add(getNewCount());
        assertEquals(dao.getAll().size(), initialRowsCount + 1);
    }

    @Test
    public void testGetByState(){
        Count count = dao.getCountsByState("state");
        assertTrue(count.getId() == 1);
    }

    private Count getNewTeam() {
        Count count = new Count();
        count.setState(ClOSE);
        count.setUser("user");
        return count;
    }
}


