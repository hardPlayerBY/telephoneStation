import com.telephone_station.api.dao.ServiceDao;
import com.telephone_station.dao.ServiceDaoImpl;
import com.telephone_station.datamodel.Service;
import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class ServiceDaoTest {
    private static ServiceDao dao;

    @BeforeClass
    public static void init(){
        dao = new ServiceDaoImpl(Service.class);
    }

    @AfterClass
    public static void finish(){
        dao = null;
    }

    @Test
    public void testAdd() {
        final Service service = getNewService();
        dao.add(service);
        assertNotNull(dao.get(service.getId()));
    }

    @Test
    public void testDelete() {
        final Service service = dao.getByName("mms");
        dao.delete(service);
        assertNull(dao.get(service.getId()));
    }

    @Test
    public void testGetAll() {
        final int initialRowsCount = dao.getAll().size();
        dao.add(getNewService());
        assertEquals(dao.getAll().size(), initialRowsCount + 1);
    }

    private Service getNewService() {
        Service service = new Service();
        service.setPrice(12);
        service.setName("mms");

        return service;
    }
}
