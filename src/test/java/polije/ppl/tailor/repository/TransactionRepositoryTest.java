package polije.ppl.tailor.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private static Transaction transaction;
    private static Account account = AccountRepository.get().get(0);
    private static Customer customer = CustomerRepository.get().get(0);
    private static Map<String, Object> keywords = new HashMap<>() {{
        put("transaction_id", 1);
        put("customer_id", customer.getId());
        put("account_id", account.getId());
    }};

    @Test @Order(1)
    public void testAdd() {
        Transaction trans = new Transaction(
            1,
            20000,
            account,
            customer,
            LocalDate.now(),
            "No Notes",
            TransactionStatus.finish
        );

        transaction = trans;
        assertTrue(TransactionRepository.add(trans));
    }

    @Test @Order(2)
    public void testGet() {
        Transaction trans = TransactionRepository.get(keywords).get(0);
        assertEquals(transaction.getStatus(), trans.getStatus());
        assertEquals(transaction.getDate(), trans.getDate());
    }

    @Test @Order(3)
    public void testGetAll() {
        Transaction trans = new Transaction();
        trans.setDate(LocalDate.now());
        trans.setNote("Bayar DP");
        trans.setStatus(TransactionStatus.unfinish);
        trans.setTotal(40000);
        trans.setAccount(account);
        trans.setCustomer(customer);

        assertTrue(TransactionRepository.add(trans));
        List<Transaction> transes = TransactionRepository.get();

        assertEquals(2, transes.size());
    }

    @Test @Order(4)
    public void testUpdate() {
        Transaction data = transaction;
        data.setStatus(TransactionStatus.unfinish);

        assertTrue(TransactionRepository.update(transaction, data));
        transaction = TransactionRepository.get(keywords).get(0);

        assertNotEquals(TransactionStatus.finish, transaction.getStatus());
        assertEquals(TransactionStatus.unfinish, transaction.getStatus());
    }

    @Test @Order(5)
    public void testDelete() {
        int id = transaction.getId();
        assertTrue(TransactionRepository.delete(id));
    }
}
