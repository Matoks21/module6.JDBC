import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import task1.Database;
import task3.DatabasePopulateService;

class DatabasePopulateServiceTest {


    private ByteArrayOutputStream outContent;
    private PrintStream originalOut;

    @BeforeEach
    void setUp() {
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);

        resetAutoIncrement("worker");
        resetAutoIncrement("client");
        resetAutoIncrement("project");
        rollbackChanges();


    }

    private void resetAutoIncrement(String tableName) {
        try {
            Connection connection = Database.getInstance().getConnection();
            Statement statement = connection.createStatement();
            String resetQuery = String.format("ALTER TABLE %s ALTER COLUMN %s RESTART WITH 1", tableName, "ID");
            statement.executeUpdate(resetQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Test
    void testMain() {

        try {
            DatabasePopulateService.main(null);
        } catch (RuntimeException e) {
            assertEquals("Error occurred: null", outContent.toString().trim());
        }
    }

    private void rollbackChanges() {
        String user = "";
        String password = "";
        String url = "jdbc:h2:mem:megasoftDB;DB_CLOSE_DELAY=-1";
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
