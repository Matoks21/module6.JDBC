
import org.junit.jupiter.api.Test;
import task4.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class DatabaseQueryServiceTest {
    private final DatabaseQueryService databaseQueryService = new DatabaseQueryService();



    @Test
    void testFindMaxProjectsClient() {
        List<MaxProjectCountClient> maxProjectCountClients = databaseQueryService.findMaxProjectsClient();
        assertNotNull(maxProjectCountClients);
        assertFalse(maxProjectCountClients.isEmpty());
        for (MaxProjectCountClient client : maxProjectCountClients) {
            assertNotNull(client.getName());
            assertTrue(client.getProjectCount() >= 0);
            System.out.println("Name: " + client.getName() + ", Project Count: " + client.getProjectCount());
        }

    }

    @Test
    void testFindMaxSalaryWorker() {
        List<MaxSalaryWorker> workers = databaseQueryService.findMaxSalaryWorker();
        assertNotNull(workers);
        assertFalse(workers.isEmpty());
        for (MaxSalaryWorker work : workers) {
            assertNotNull(work.getName());
            assertTrue(work.getSalary() >= 0);
            System.out.println("Name:  " + work.getName() + " , Salary : " + work.getSalary());
        }
    }
    @Test
    void testFindLongestProject() {
        List<LongestProject> projects = databaseQueryService.findLongestProject();
        assertNotNull(projects);
        assertFalse(projects.isEmpty());
        for (LongestProject longestProject:projects) {
            assertTrue(longestProject.getId()>=0 && longestProject.getMonthCount()>=0);
            System.out.println("ID:  " + longestProject.getId() + " , MONTH_COUNT : " + longestProject.getMonthCount());
        }
    }

    @Test
    void testFindYoungestEldestWorkers() {
        List<YoungestAndEldestWorker> workers = databaseQueryService.findYoungestEldestWorkers();
        assertNotNull(workers);
        assertFalse(workers.isEmpty());
        for (YoungestAndEldestWorker worker:workers) {
            assertNotNull(worker);
            assertFalse(workers.isEmpty());
            assertTrue(worker.getAge()>=0);
            System.out.println("NAME : " + worker.getName() + " BIRTHDAY : " + worker.getBirthday() + " AGE : " + worker.getAge());
        }
    }

    @Test
    void testPrintProjectPrices() {
        List<PrintProjectPrices> projectPrices = databaseQueryService.printProjectPrices();
        assertNotNull(projectPrices);
        assertFalse(projectPrices.isEmpty());
        for (PrintProjectPrices prices :
                projectPrices) {
            assertNotNull(prices);
            assertFalse(projectPrices.isEmpty());
            System.out.println("NAME - " + prices.getName() + "  PRICE - " + prices.getPrice());
        }
    }
}

