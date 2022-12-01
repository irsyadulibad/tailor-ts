package polije.ppl.tailor.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import polije.ppl.tailor.data.AccountRole;
import polije.ppl.tailor.entity.Account;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AccountRepositoryTest {
    private static Repository<Account> repo = new AccountRepository();
    private static Integer accountId;

    @Test @Order(1)
    public void testAdd() {
        Account acc = new Account(
            "John",
            "test@gmail.com",
            "john",
            "john123",
            AccountRole.admin
        );

        accountId = repo.add(acc);
        assertTrue(accountId > 0);
    }

    @Test @Order(2)
    public void testGet() {
        Account acc = repo.get(accountId);
        Account acc2 = repo.get(new HashMap<String, Object>() {{
            put("account_id", accountId);
        }}).get(0);

        assertEquals("John", acc.getFullname());
        assertEquals(AccountRole.admin, acc.getRole());
        assertEquals("john123", acc2.getPassword());
    }

    @Test @Order(3)
    public void testGetAll() {
        Account acc = new Account(
            "Aldea",
            "aldea@test.com",
            "aldea",
            "aldea123",
            AccountRole.tailor
        );

        assertTrue(repo.add(acc) > 0);
        assertTrue(repo.get().size() > 1);
    }

    @Test @Order(4)
    public void testUpdate() {
        Account account = repo.get(accountId);
        account.setFullname("John Wick");

        repo.update(account);
        account = repo.get(accountId);

        assertNotEquals("John", account.getFullname());
        assertEquals("John Wick", account.getFullname());
    }

    @Test @Order(5)
    public void testDelete() {
        assertTrue(repo.delete(accountId));
    }
}
