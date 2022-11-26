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

import polije.ppl.tailor.entity.Customer;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomerRepositoryTest {
    private static Customer customer;
    private static Map<String, Object> keywords = new HashMap<>() {{
        put("customer_id", 1);
        put("phone", "086543789098");
    }};

    @Test @Order(1)
    public void testAdd() {
        Customer cust = new Customer(
            1,
            20,
            "Belva",
            "086543789098",
            "Jember"
        );

        customer = cust;
        assertTrue(CustomerRepository.add(cust));
    }

    @Test @Order(2)
    public void testGet() {
        Customer cust = CustomerRepository.get(keywords).get(0);
        assertEquals("Belva", cust.getFullname());
    }

    @Test @Order(3)
    public void testGetAll() {
        Customer cust = new Customer();
        cust.setAge(21);
        cust.setFullname("Aldo");
        cust.setPhone("087654567890");
        cust.setAddress("Bondowoso");

        CustomerRepository.add(cust);
        List<Customer> customers = CustomerRepository.get();

        assertEquals(2, customers.size());
    }

    @Test @Order(4)
    public void testUpdate() {
        Customer data = customer;
        data.setFullname("Belva Devara");

        CustomerRepository.update(customer, data);
        customer = CustomerRepository.get(keywords).get(0);

        assertNotEquals("Belva", customer.getFullname());
        assertEquals("Belva Devara", customer.getFullname());
    }

    @Test @Order(5)
    public void testDelete() {
        int id = customer.getId();
        assertTrue(CustomerRepository.delete(id));
    }
}
