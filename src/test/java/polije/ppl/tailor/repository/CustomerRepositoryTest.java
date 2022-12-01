package polije.ppl.tailor.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import polije.ppl.tailor.entity.Customer;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomerRepositoryTest {
    private static Repository<Customer> repo = new CustomerRepository();
    private static Integer customerId;

    @Test @Order(1)
    public void testAdd() {
        Customer cust = new Customer(
            "Belva",
            20,
            "086543789098",
            "Jember"
        );

        customerId = repo.add(cust);
        assertTrue(customerId > 0);
    }

    @Test @Order(2)
    public void testGet() {
        Customer cust = repo.get(customerId);
        Customer cust2 = repo.get(new HashMap<String, Object>() {{
            put("customer_id", customerId);
        }}).get(0);

        assertEquals("Belva", cust.getFullname());
        assertEquals("Belva", cust2.getFullname());
    }

    @Test @Order(3)
    public void testGetAll() {
        Customer cust = new Customer();
        cust.setAge(21);
        cust.setFullname("Aldo");
        cust.setPhone("087654567890");
        cust.setAddress("Bondowoso");

        assertTrue(repo.add(cust) > 0);
        assertTrue(repo.get().size() > 1);
    }

    @Test @Order(4)
    public void testUpdate() {
        Customer customer = repo.get(customerId);
        customer.setFullname("Belva Devara");

        repo.update(customer);
        customer = repo.get(customerId);

        assertNotEquals("Belva", customer.getFullname());
        assertEquals("Belva Devara", customer.getFullname());
    }

    @Test @Order(5)
    public void testDelete() {
        assertTrue(repo.delete(customerId));
    }
}
