
import org.junit.jupiter.api.Test;
import task4.*;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseQueryServiceTest {


    private final DatabaseQueryService databaseQueryService = new DatabaseQueryService();


    @Test
    void testMainMethod() {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        DatabaseQueryService.main(new String[0]);
        List<String> list = List.of("Name:", "Project Count:", "Name:", "Salary :", "ID:", "MONTH_COUNT :", "NAME :", "BIRTHDAY :", "AGE :", "NAME -", "PRICE -");
        String consoleOutput = outputStream.toString();
        for (String str :
                list) {
            assertTrue(consoleOutput.contains(str));
        }

    }

    @Test
    void testFindMaxProjectsClient() {
        List<MaxProjectCountClient> clients = databaseQueryService.findMaxProjectsClient();
        assertNotNull(clients);
        assertFalse(clients.isEmpty());

    }

    @Test
    void testFindMaxSalaryWorker() {
        List<MaxSalaryWorker> workers = databaseQueryService.findMaxSalaryWorker();
        assertNotNull(workers);
        assertFalse(workers.isEmpty());

    }

    @Test
    void testFindLongestProject() {
        List<LongestProject> projects = databaseQueryService.findLongestProject();
        assertNotNull(projects);
        assertFalse(projects.isEmpty());

    }

    @Test
    void testFindYoungestEldestWorkers() {
        List<YoungestAndEldestWorker> workers = databaseQueryService.findYoungestEldestWorkers();
        assertNotNull(workers);
        assertFalse(workers.isEmpty());

    }

    @Test
    void testPrintProjectPrices() {
        List<PrintProjectPrices> prices = databaseQueryService.printProjectPrices();
        assertNotNull(prices);
        assertFalse(prices.isEmpty());
    }

}
