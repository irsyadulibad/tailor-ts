package polije.ppl.tailor.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

public class DatabaseUtilTest {
    @Test
    public void testConnection() throws SQLException {
        Connection conn = DatabaseUtil.getConnection();
        conn.close();
    }
}
