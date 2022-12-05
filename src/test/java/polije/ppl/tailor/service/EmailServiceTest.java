package polije.ppl.tailor.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmailServiceTest {
    @Test @Order(1)
    public void testSendMail() {
        EmailService service = new EmailService();
        assertTrue(service.sendVerificationEMail("ahmadirsyadulibad7@gmail.com", "786543"));
    }
}
