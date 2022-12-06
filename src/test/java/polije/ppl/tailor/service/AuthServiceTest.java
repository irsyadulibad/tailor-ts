package polije.ppl.tailor.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import polije.ppl.tailor.data.AccountRole;
import polije.ppl.tailor.entity.Account;
import polije.ppl.tailor.repository.AccountRepository;
import polije.ppl.tailor.repository.Repository;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AuthServiceTest {
    private static Repository<Account> repo = new AccountRepository();
    private static AuthService srv = new AuthService();
    private static Account account;

    @BeforeAll
    public static void init() {
        Integer id = repo.add(new Account(
            "Admin",
            "ahmadirsyadulibad7@gmail.com",
            "admin",
            "admin123",
            AccountRole.admin
        ));

        account = repo.get(id);
    }

    @AfterAll
    public static void tearDown() {
        repo.delete(account.getId());
    }

    @Test @Order(1)
    public void testLogin() {
        assertTrue(srv.login(account.getUsername(), account.getPassword()));
        assertFalse(srv.login("adm00n", "admin123"));
    }

    @Test @Order(2)
    public void testForgot() {
        assertFalse(srv.forgotPassword("adm00n", "admin123"));
        assertTrue(srv.forgotPassword(account.getUsername(), account.getEmail()));
    }
}
