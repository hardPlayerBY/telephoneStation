import com.telephone_station.api.dao.UserDao;
import com.telephone_station.dao.UserDaoImpl;
import com.telephone_station.datamodel.Authority;
import com.telephone_station.datamodel.User;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {
    private static UserDao dao;

    @BeforeClass
    public static void init(){
        dao = new UserDaoImpl();
    }

    @AfterClass
    public static void finish(){
        dao = null;
    }

    @Test
    public void testAdd() {
        final User user = getNewUser();
        dao.add(user);
        assertNotNull(dao.get(user.getLogin(), user.getPassword()));
    }


    @Test
    public void testUpdate(){
        final User user = dao.get("biba", "biba");
        user.setAuthority(Authority.ADMIN);
        dao.update(user);
        assertTrue(dao.get("biba", "biba").getAuthority() == Authority.ADMIN);
    }

    @Test
    public void testDelete() {
        final User user = getNewUser();
        dao.delete(user);
        assertNull(dao.get(user.getLogin(), user.getPassword()));
    }

    @Test
    public void testGetAll() {
        final int initialRowsCount = dao.getAll().size();
        dao.add(getNewUser());
        assertEquals(dao.getAll().size(), initialRowsCount + 1);
    }

    private User getNewUser() {
        User user = new User();
        user.setLogin("biba");
        user.setPassword("biba");
        user.setAuthority(Authority.USER);
        return user;
    }
}
