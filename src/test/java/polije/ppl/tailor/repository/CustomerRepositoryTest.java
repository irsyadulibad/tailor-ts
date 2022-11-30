package polije.ppl.tailor.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import polije.ppl.tailor.entity.Customer;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomerRepositoryTest {
    private static Repository<Customer> repo = new CustomerRepository();
    private static Map<String, Object> keywords = new HashMap<>() {{
        put("age", 20);
        put("phone", "086543789098");
    }};

    @Test @Order(1)
    public void testAdd() {
        Customer cust = new Customer(
            "Belva",
            20,
            "086543789098",
            "Jember"
        );

        assertTrue(repo.add(cust));
    }

    @Test @Order(2)
    public void testGet() {
        Customer cust = repo.get(keywords).get(0);
        assertEquals("Belva", cust.getFullname());
    }

    @Test @Order(3)
    public void testGetAll() {
        Customer cust = new Customer();
        cust.setAge(21);
        cust.setFullname("Aldo");
        cust.setPhone("087654567890");
        cust.setAddress("Bondowoso");

        repo.add(cust);
        assertTrue(repo.get().size() > 1);
    }

    @Test @Order(4)
    public void testUpdate() {
        Customer customer = repo.get(keywords).get(0);
        customer.setFullname("Belva Devara");

        repo.update(customer);
        customer = repo.get(keywords).get(0);

        assertNotEquals("Belva", customer.getFullname());
        assertEquals("Belva Devara", customer.getFullname());
    }

    @Test @Order(5)
    public void testDelete() {
        int id = repo.get(keywords).get(0).getId();
        assertTrue(repo.delete(id));
    }
}
