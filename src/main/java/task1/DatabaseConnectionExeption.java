package task1;

public class DatabaseConnectionExeption extends RuntimeException{

    public DatabaseConnectionExeption(String message, Throwable cause) {
        super(message, cause);
    }
}
