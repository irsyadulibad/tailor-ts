package polije.ppl.tailor.util;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

public class DatabaseUtilTest {
    @Test
    public void testConnection() throws SQLException {
        Connection conn = DatabaseUtil.getConnection();
        assertInstanceOf(Connection.class, conn);
    }
}
