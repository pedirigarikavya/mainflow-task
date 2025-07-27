import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCONNECTION {
    private static final String URL = "jdbc:mysql://localhost:3306/userdb";
    private static final String USER = "root";
    private static final String PASSWORD = "pass123";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to MySQL database!");
        } catch (ClassNotFoundException e) {
            System.out.println("Connection error: Driver not found - " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Connection error: SQL Exception - " + e.getMessage());
        }
        return connection;
    }

    // Optional: Main method to test the connection
    public static void main(String[] args) {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                conn.close(); // Close the connection after testing
                System.out.println("Connection closed.");
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}