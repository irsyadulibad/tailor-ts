package polije.ppl.tailor.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

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
    private static Integer accountId, customerId, transactionId;

    @BeforeAll
    public static void init() {
        accountId = accRepo.add(new Account(
            "Tailor", "tailor@test.com", "tailor", "tailor123"
        ));

        customerId = custRepo.add(new Customer(
            "Silvi", 20, "087238475673", "NYC"
        ));

        account = accRepo.get(accountId);
        customer = custRepo.get(customerId);
    }

    @AfterAll
    public static void tearDown() {
        accRepo.delete(accountId);
        custRepo.delete(customerId);
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

        transactionId = repo.add(trans);
        assertTrue(transactionId > 0);
    }

    @Test @Order(2)
    public void testGet() {
        Transaction trans = repo.get(transactionId);
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

        assertTrue(repo.add(trans) > 0);
        assertTrue(repo.get().size() > 1);
    }

    @Test @Order(4)
    public void testUpdate() {
        Transaction trans = repo.get(transactionId);
        trans.setNote("New note");

        assertTrue(repo.update(trans));
        trans = repo.get(transactionId);

        assertNotEquals("No Notes", trans.getNote());
        assertEquals("New note", trans.getNote());
    }

    @Test @Order(5)
    public void testDelete() {
        assertTrue(repo.delete(transactionId));
    }
}
