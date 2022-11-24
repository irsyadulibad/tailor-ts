package polije.ppl.tailor.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigUtil {
    private static Properties config;
    private static String path = Paths.get(".").toAbsolutePath().normalize().toString();

    static {
        try(InputStream input = new FileInputStream(path + "/config.properties")) {
            Properties props = new Properties();

            props.load(input);
            config = props;
        } catch (IOException e) { throw new Error(e.getMessage()); }
    }

    public static String get(String key) {
        return config.getProperty(key);
    }
}
