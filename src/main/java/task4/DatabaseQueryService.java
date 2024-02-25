package task4;

import task1.Database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

public class DatabaseQueryService {
    public static final String SQL_ERROR_MESSAGE = "Error occurred while executing SQL query: ";


    public List<MaxProjectCountClient> findMaxProjectsClient() {
        List<MaxProjectCountClient> result = new ArrayList<>();

        try {
            Connection connection = Database.getInstance().getConnection();
            Statement statement = connection.createStatement();
            String sql = new String(Files.readAllBytes(Paths.get("sql/find_max_projects_client.sql")));
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String name = resultSet.getString("NAME");
                int projectCount = resultSet.getInt("PROJECT_COUNT");
                result.add(new MaxProjectCountClient(name, projectCount));

            }

        } catch (SQLException | IOException ex) {
            System.out.println(SQL_ERROR_MESSAGE + ex.getMessage());
        }

        return result;
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker() {
        List<MaxSalaryWorker> list = new ArrayList<>();

        try {
            Connection connection = Database.getInstance().getConnection();
            Statement statement = connection.createStatement();

            String sql = new String(Files.readAllBytes(Paths.get("sql/find_max_salary_worker.sql")));
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String name = resultSet.getString("NAME");
                long salary = resultSet.getLong("SALARY");
                list.add(new MaxSalaryWorker(name, salary));

            }

        } catch (SQLException | IOException ex) {
            System.out.println(SQL_ERROR_MESSAGE + ex.getMessage());
        }

        return list;
    }

    public List<LongestProject> findLongestProject() {
        List<LongestProject> list = new ArrayList<>();

        try {
            Connection connection = Database.getInstance().getConnection();
            Statement statement = connection.createStatement();
            String sql = new String(Files.readAllBytes(Paths.get("sql/find_longest_project.sql")));
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                long id = resultSet.getLong("ID");
                long monthCount = resultSet.getLong("MONTH_COUNT");
                list.add(new LongestProject(id, monthCount));

            }

        } catch (SQLException | IOException ex) {
            System.out.println(SQL_ERROR_MESSAGE + ex.getMessage());
        }

        return list;
    }

    public List<YoungestAndEldestWorker> findYoungestEldestWorkers() {
        List<YoungestAndEldestWorker> list = new ArrayList<>();

        try {
            Connection connection = Database.getInstance().getConnection();
            Statement statement = connection.createStatement();
            String sql = new String(Files.readAllBytes(Paths.get("sql/find_youngest_eldest_workers.sql")));
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String name = resultSet.getString("NAME");
                String birthday = resultSet.getString("BIRTHDAY");
                int age = resultSet.getInt("AGE");
                list.add(new YoungestAndEldestWorker(name, birthday, age));

            }

        } catch (SQLException | IOException ex) {
            System.out.println(SQL_ERROR_MESSAGE + ex.getMessage());
        }

        return list;
    }

    public List<PrintProjectPrices> printProjectPrices() {
        List<PrintProjectPrices> list = new ArrayList<>();

        try {
            Connection connection = Database.getInstance().getConnection();
            Statement statement = connection.createStatement();
            String sql = new String(Files.readAllBytes(Paths.get("sql/print_project_prices.sql")));
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String name = resultSet.getString("NAME");
                long price = resultSet.getLong("PRICE");
                list.add(new PrintProjectPrices(name, price));

            }

        } catch (SQLException | IOException ex) {
            System.out.println(SQL_ERROR_MESSAGE + ex.getMessage());
        }

        return list;
    }

    public static void main(String[] args) {
        task4.DatabaseQueryService databaseQueryService = new task4.DatabaseQueryService();
        List<MaxProjectCountClient> maxProjectCountClients = databaseQueryService.findMaxProjectsClient();
        maxProjectCountClients.forEach(client -> System.out.println("Name: " + client.getName() + ", Project Count: " + client.getProjectCount()));


        List<MaxSalaryWorker> workers = databaseQueryService.findMaxSalaryWorker();
        workers.forEach(work -> System.out.println("Name:  " + work.getName() + " , Salary : " + work.getSalary()));

        List<LongestProject> longestProjects = databaseQueryService.findLongestProject();
        longestProjects.forEach(longestProject -> System.out.println("ID:  " + longestProject.getId() + " , MONTH_COUNT : " + longestProject.getMonthCount()));

        List<YoungestAndEldestWorker> workerList = databaseQueryService.findYoungestEldestWorkers();
        workerList.forEach(worker -> System.out.println("NAME : " + worker.getName() + " BIRTHDAY : " + worker.getBirthday() + " AGE : " + worker.getAge()));


        List<PrintProjectPrices> projectPrices = databaseQueryService.printProjectPrices();
        projectPrices.forEach(prices -> System.out.println("NAME - " + prices.getName() + "  PRICE - " + prices.getPrice()));
    }

}