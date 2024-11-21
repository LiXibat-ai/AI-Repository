package ExpFour2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL =  "jdbc:mysql://1.94.104.154:3306/examination_system?useSSL=false&serverTimezone=UTC";
    private static final String USER = "admin";
    private static final String PASSWORD = "Aa@123456";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
