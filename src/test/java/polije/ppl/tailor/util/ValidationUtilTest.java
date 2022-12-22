package polije.ppl.tailor.util;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import polije.ppl.tailor.entity.Account;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidationUtilTest {
    @Test
    public void testValidator() {
        assertNotNull(ValidationUtil.getValidator());
    }

    @Test
    public void testAccountValidation() {
        Account acc = new Account();
        assertTrue(ValidationUtil.validate(acc).size() > 3);
    }
}
