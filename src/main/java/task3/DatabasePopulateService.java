package task3;

import task1.Database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
Завдання №3 - створити клас для наповнення таблиць БД
Створи клас з назвою task3.DatabasePopulateService.
 У цьому класі має бути метод public static void main(String[] args), який зчитуватиме файл sql/populate_db.sql
 і виконуватиме запити з цього класу у БД.

Для роботи з БД використовуй написаний раніше тобою клас task1.Database.

Результат запуску цього класу - наповнені таблиці бази даних.
 */



public class DatabasePopulateService {
    public static void main(String[] args) {
        try {
            Connection connection = Database.getInstance().getConnection();

            String sql = new String(Files.readAllBytes(Paths.get("sql/populate_db.sql")));
            String[] queries = sql.split(";");

            for (String query : queries) {
                String trimmedQuery = query.trim();
                if (!trimmedQuery.isEmpty()) {
                    try (PreparedStatement preparedStatement = connection.prepareStatement(trimmedQuery)) {
                        preparedStatement.executeUpdate();
                    }
                }
            }

        } catch (IOException | SQLException ex) {
            System.out.println("Error occurred: " + ex.getMessage());
        }
    }
}