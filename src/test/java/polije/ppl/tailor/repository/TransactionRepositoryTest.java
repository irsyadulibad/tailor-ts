package polije.ppl.tailor.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import polije.ppl.tailor.data.TransactionStatus;
import polije.ppl.tailor.entity.Account;
import polije.ppl.tailor.entity.Customer;
import polije.ppl.tailor.entity.Transaction;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TransactionRepositoryTest {
    private static Account account;
    private static Customer customer;
    private static Repository<Transaction> repo = new TransactionRepository();
    private static Repository<Account> accRepo = new AccountRepository();
    private static Repository<Customer> custRepo = new CustomerRepository();
    private static Map<String, Object> keywords;

    private static Map<String, Object> accKey = new HashMap<>() {{
        put("fullname", "Tailor");
    }};

    private static Map<String, Object> custKey = new HashMap<>() {{
        put("fullname", "Silvi");
    }};

    @BeforeAll
    public static void init() {
        accRepo.add(new Account(
            "Tailor", "tailor@test.com", "tailor", "tailor123"
        ));

        custRepo.add(new Customer(
            "Silvi", 20, "087238475673", "NYC"
        ));

        account = accRepo.get(accKey).get(0);
        customer = custRepo.get(custKey).get(0);
        keywords = new HashMap<>() {{
            put("customer_id", customer.getId());
            put("status", TransactionStatus.finish);
        }};
    }

    @AfterAll
    public static void tearDown() {
        accRepo.delete(account.getId());
        custRepo.delete(customer.getId());
    }

    @Test @Order(1)
    public void testAdd() {
        Transaction trans = new Transaction(
            20000,
            account,
            customer,
            LocalDate.now(),
            "No Notes",
            TransactionStatus.finish
        );

        assertTrue(repo.add(trans));
    }

    @Test @Order(2)
    public void testGet() {
        Transaction trans = repo.get(keywords).get(0);
        assertEquals(TransactionStatus.finish, trans.getStatus());
    }

    @Test @Order(3)
    public void testGetAll() {
        Transaction trans = new Transaction(
            25000,
            account,
            customer,
            LocalDate.now(),
            "No Notes",
            TransactionStatus.unfinish
        );

        assertTrue(repo.add(trans));
        assertTrue(repo.get().size() > 1);
    }

    @Test @Order(4)
    public void testUpdate() {
        Transaction trans = repo.get(keywords).get(0);
        trans.setNote("New note");

        assertTrue(repo.update(trans));
        trans = repo.get(keywords).get(0);

        assertNotEquals("No Notes", trans.getNote());
        assertEquals("New note", trans.getNote());
    }

    @Test @Order(5)
    public void testDelete() {
        int id = repo.get(keywords).get(0).getId();
        assertTrue(repo.delete(id));
    }
}
