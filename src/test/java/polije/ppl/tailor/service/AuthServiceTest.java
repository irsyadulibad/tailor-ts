package polije.ppl.tailor.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    private static AuthService srv = new AuthService();

    @Test @Order(1)
    public void testLogin() {
        Repository<Account> repo = new AccountRepository();
        Integer id = repo.add(new Account(
            "Admin",
            "admin@gmail.com",
            "admin",
            "admin123",
            AccountRole.admin
        ));

        Account acc = repo.get(id);
        assertTrue(srv.login(acc.getUsername(), acc.getPassword()));
        assertFalse(srv.login("adm00n", "admin123"));

        repo.delete(id);
    }
}
