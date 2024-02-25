package task1;/*
Завдання №1 - створити утилітний клас для роботи з БД
Створи клас-сінглтон task1.Database, який інкапсулює у собі логіку для роботи з БД.
Під час створення екземпляру цього класу має відбуватись підключення до СУБД та зберігатись екземпляр Connection.
 Має бути можливість отримати Connection викликом методу getConnection(). Наприклад, ось так:

Connection conn = task1.Database.getInstance().getConnection();
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Database {
    private static final Database INSTANCE = new Database();
    private final Connection connection;

    private Database() {
        try {
            connection = DriverManager.getConnection("jdbc:h2:./megasoftDB");
        } catch (SQLException e) {
            throw new DatabaseConnectionExeption("Failed to connect to the database.", e);
        }
    }


    public static Database getInstance() {

        return INSTANCE;
    }

    public Connection getConnection() {

        return connection;
    }


    public static void main(String[] args) {
    }
}
