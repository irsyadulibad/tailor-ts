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

import polije.ppl.tailor.entity.Account;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AccountRepositoryTest {
    private static Repository<Account> repo = new AccountRepository();
    private static Map<String, Object> keywords = new HashMap<>() {{
        put("username", "john");
        put("password", "john123");
    }};

    @Test @Order(1)
    public void testAdd() {
        Account acc = new Account(
            "John",
            "test@gmail.com",
            "john",
            "john123"
        );

        assertTrue(repo.add(acc));
    }

    @Test @Order(2)
    public void testGet() {
        Account acc = repo.get(keywords).get(0);
        assertEquals("John", acc.getFullname());
    }

    @Test @Order(3)
    public void testGetAll() {
        Account acc = new Account(
            "Aldea",
            "aldea@test.com",
            "aldea",
            "aldea123"
        );

        assertTrue(repo.add(acc));
        assertTrue(repo.get().size() > 1);
    }

    @Test @Order(4)
    public void testUpdate() {
        Account account = repo.get(keywords).get(0);
        account.setFullname("John Wick");

        repo.update(account);
        account = repo.get(keywords).get(0);

        assertNotEquals("John", account.getFullname());
        assertEquals("John Wick", account.getFullname());
    }

    @Test @Order(5)
    public void testDelete() {
        int id = repo.get(keywords).get(0).getId();
        assertTrue(repo.delete(id));
    }
}
