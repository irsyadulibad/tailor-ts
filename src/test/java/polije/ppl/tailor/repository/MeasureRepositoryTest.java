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
    private static Integer customerId, measureId;

    @BeforeAll
    public static void init() {
        Repository<Customer> custRepo = new CustomerRepository();
        Customer cust = new Customer(
            "Rosa",
            21,
            "087654799084",
            "Jember"
        );

        customerId = custRepo.add(cust);
        customer = custRepo.get(customerId);
    }

    @AfterAll
    public static void tearDown() {
        new CustomerRepository().delete(customerId);
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

        measureId = repo.add(meas);
        assertTrue(measureId > 0);
    }

    @Test @Order(2)
    public void testGet() {
        Measure meas = repo.get(measureId);

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

        assertTrue(repo.add(meas) > 0);
        assertTrue(repo.get().size() > 1);
    }

    @Test @Order(4)
    public void testUpdate() {
        Measure meas = repo.get(measureId);
        List<MeasureItem> items = meas.getItemsCollection();

        items.get(0).setValue(300);
        meas.setItems(items);

        assertTrue(repo.update(meas));
        meas = repo.get(measureId);
        int value = meas.getItemsCollection().get(0).getValue();

        assertNotEquals(200, value);
        assertEquals(300, value);
    }

    @Test @Order(5)
    public void testDelete() {
        assertTrue(repo.delete(measureId));
    }
}
