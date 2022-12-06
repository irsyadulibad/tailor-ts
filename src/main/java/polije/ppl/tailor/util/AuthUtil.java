package polije.ppl.tailor.util;

import java.util.Random;

public class AuthUtil {
    public static String generateCode() {
        return String.format("%06d", new Random().nextInt(999999));
    }
}
