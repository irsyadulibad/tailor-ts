package polije.ppl.tailor.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtil {
    private static Properties config;

    static {
        try(InputStream input = ConfigUtil.class.getResource("/config/app.properties").openStream()) {
            Properties props = new Properties();

            props.load(input);
            config = props;
        } catch (IOException e) { throw new Error(e.getMessage()); }
    }

    public static String get(String key) {
        return config.getProperty(key);
    }
}
