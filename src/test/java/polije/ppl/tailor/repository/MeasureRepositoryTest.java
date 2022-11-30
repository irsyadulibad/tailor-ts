package polije.ppl.tailor.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import polije.ppl.tailor.data.MeasureItem;
import polije.ppl.tailor.entity.Customer;
import polije.ppl.tailor.entity.Measure;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MeasureRepositoryTest {
    private static Customer customer;
    private static Repository<Measure> repo = new MeasureRepository();
    private static Map<String, Object> keywords = new HashMap<>() {{
        put("cloth_type", "Gown");
    }};

    private static Map<String, Object> custKey = new HashMap<>(){{
        put("fullname", "Rosa");
    }};

    @BeforeAll
    public static void init() {
        Repository<Customer> custRepo = new CustomerRepository();
        Customer cust = new Customer(
            "Rosa",
            21,
            "087654799084",
            "Jember"
        );

        assertTrue(custRepo.add(cust));
        customer = custRepo.get(custKey).get(0);
    }

    @AfterAll
    public static void tearDown() {
        Customer cust = new CustomerRepository().get(custKey).get(0);
        new CustomerRepository().delete(cust.getId());
    }

    @Test @Order(1)
    public void testAdd() {
        Measure meas = new Measure(
            customer,
            "Gown",
            new MeasureItem[] {
                new MeasureItem("P", 200)
            }
        );

        assertTrue(repo.add(meas));
    }

    @Test @Order(2)
    public void testGet() {
        Measure meas = repo.get(keywords).get(0);

        assertEquals("Gown", meas.getClothType());
        assertEquals(1, meas.getItems().length());
    }

    @Test @Order(3)
    public void testGetAll() {
        Measure meas = new Measure(
            customer,
            "Uniform",
            new MeasureItem[] {
                new MeasureItem("BDAN", 30),
                new MeasureItem("UJL", 40)
            }
        );

        assertTrue(repo.add(meas));
        assertTrue(repo.get().size() > 1);
    }

    @Test @Order(4)
    public void testUpdate() {
        Measure meas = repo.get(keywords).get(0);
        List<MeasureItem> items = meas.getItemsCollection();

        items.get(0).setValue(300);
        meas.setItems(items);

        assertTrue(repo.update(meas));
        meas = repo.get(keywords).get(0);
        int value = meas.getItemsCollection().get(0).getValue();

        assertNotEquals(200, value);
        assertEquals(300, value);
    }

    @Test @Order(5)
    public void testDelete() {
        int id = repo.get(keywords).get(0).getId();
        assertTrue(repo.delete(id));
    }
}
