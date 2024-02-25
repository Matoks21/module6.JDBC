import org.junit.jupiter.api.*;
import task2.DatabaseInitService;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseInitServiceTest {
    @Test
    void testMain() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));


        try {
            DatabaseInitService.main(null);
        } catch (RuntimeException e) {

            assertEquals("Error occurred: null", e.getMessage());
        }

        System.setOut(originalOut);
    }
}



