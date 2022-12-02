package polije.ppl.tailor.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import polije.ppl.tailor.data.AccountRole;
import polije.ppl.tailor.entity.Account;
import polije.ppl.tailor.entity.Verification;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class VerificationRepositoryTest {
    private static VerificationRepository repo = new VerificationRepository();
    private static AccountRepository accRepo = new AccountRepository();
    private static Map<String, Object> keywords;

    private static Account account;
    private static Integer accountId;
    private static String code = "087653";

    @BeforeAll
    public static void init() {
        accountId = accRepo.add(new Account(
            "Ahkam", "ahkam@test.com", "ahkam", "ahkam123", AccountRole.admin
        ));

        account = accRepo.get(accountId);
        keywords = new HashMap<String, Object>() {{
            put("account_id", accountId);
            put("code", code);
        }};
    }

    @AfterAll
    public static void tearDown() {
        accRepo.delete(accountId);
    }

    @Test @Order(1)
    public void testAdd() {
        Verification verify = new Verification(
            account,
            "087653"
        );

        assertTrue(repo.add(verify) != 0);
    }

    @Test @Order(2)
    public void testGet() {
        Verification verify = repo.get(keywords).get(0);

        assertEquals(code, verify.getCode());
    }

    @Test @Order(3)
    public void testGetAll() {
        String code = "087654";
        Verification verify = new Verification(account, code);

        repo.add(verify);
        List<Verification> verifies = repo.get();

        assertTrue(verifies.size() > 1);
        assertEquals(code, verifies.get(1).getCode());
    }

    @Test @Order(4)
    public void testUpdate() {
        String codeNew = "087656";
        Verification verify = repo.get(keywords).get(0);

        verify.setCode(codeNew);
        keywords.put("code", codeNew);
        repo.update(verify);
        verify = repo.get(keywords).get(0);

        assertEquals(codeNew, verify.getCode());
        code = codeNew;
    }

    @Test @Order(5)
    public void testDelete() {
        Verification verify = repo.get(keywords).get(0);
        assertTrue(repo.delete(verify));
    }
}
