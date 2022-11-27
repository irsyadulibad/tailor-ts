package polije.ppl.tailor.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import polije.ppl.tailor.data.MeasureItem;
import polije.ppl.tailor.entity.Customer;
import polije.ppl.tailor.entity.Measure;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MeasureRepositoryTest {
    private static Measure measure;
    private static Customer customer = CustomerRepository.get().get(0);
    private static Map<String, Object> keywords = new HashMap<>() {{
        put("measure_id", 1);
    }};

    @Test @Order(1)
    public void testAdd() {
        Measure meas = new Measure(
            1,
            customer,
            "Gown",
            new MeasureItem[] {
                new MeasureItem("P", 200)
            }
        );

        measure = meas;
        assertTrue(MeasureRepository.add(meas));
    }

    @Test @Order(2)
    public void testGet() {
        Measure meas = MeasureRepository.get(keywords).get(0);
        assertEquals("Gown", meas.getClothType());
    }

    @Test @Order(3)
    public void testGetAll() {
        Measure meas = new Measure();
        meas.setClothType("Uniform");
        meas.setCustomer(customer);
        meas.setItems(new MeasureItem[] {
            new MeasureItem("BDAN", 30)
        });

        MeasureRepository.add(meas);
        List<Measure> measses = MeasureRepository.get();

        assertEquals(2, measses.size());
    }

    @Test @Order(4)
    public void testUpdate() {
        Measure data = measure;
        data.setClothType("T-Shirt");

        assertTrue(MeasureRepository.update(measure, data));
        measure = MeasureRepository.get(keywords).get(0);

        assertNotEquals("Gown", measure.getClothType());
        assertEquals("T-Shirt", measure.getClothType());
    }

    @Test @Order(5)
    public void testDelete() {
        int id = measure.getId();
        assertTrue(MeasureRepository.delete(id));
    }
}
