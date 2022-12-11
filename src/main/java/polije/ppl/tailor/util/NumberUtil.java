package polije.ppl.tailor.util;

public class NumberUtil {
    public static String formatDec(int val) {
        return String.format("%,d", val).replace(',', '.');
    }
}
