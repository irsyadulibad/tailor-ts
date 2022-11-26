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

import polije.ppl.tailor.entity.Account;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AccountRepositoryTest {
    private static Account account;
    private static Map<String, Object> keywords = new HashMap<>() {{
        put("username", "john");
        put("password", "john123");
    }};

    @Test @Order(1)
    public void testAdd() {
        Account acc = new Account(
            1,
            "John",
            "test@gmail.com",
            "john",
            "john123"
        );

        account = acc;
        assertTrue(AccountRepository.add(acc));
    }

    @Test @Order(2)
    public void testGet() {
        Account acc = AccountRepository.get(keywords).get(0);
        assertEquals("John", acc.getFullname());
    }

    @Test @Order(3)
    public void testGetAll() {
        Account acc = new Account();
        acc.setUsername("aldea");
        acc.setFullname("Aldea");
        acc.setPassword("aldea123");
        acc.setEmail("aldea@test.com");

        AccountRepository.add(acc);
        List<Account> accounts = AccountRepository.get();

        assertEquals(2, accounts.size());
    }

    @Test @Order(4)
    public void testUpdate() {
        Account data = account;
        data.setFullname("John Wick");

        AccountRepository.update(account, data);
        account = AccountRepository.get(keywords).get(0);

        assertNotEquals("John", account.getFullname());
        assertEquals("John Wick", account.getFullname());
    }

    @Test @Order(5)
    public void testDelete() {
        int id = account.getId();
        assertTrue(AccountRepository.delete(id));
    }
}
