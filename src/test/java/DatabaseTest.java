import org.junit.jupiter.api.Test;
import task1.Database;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    @Test
    void testGetInstance() {
        Database database1 = Database.getInstance();
        Database database2 = Database.getInstance();
        assertNotNull(database1);
        assertNotNull(database2);
        assertSame(database1, database2);
    }

    @Test
    void testGetConnection() {
        Database database = Database.getInstance();
        Connection connection = database.getConnection();
        assertNotNull(connection);
        try {
            assertFalse(connection.isClosed());
        } catch (SQLException e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

}
