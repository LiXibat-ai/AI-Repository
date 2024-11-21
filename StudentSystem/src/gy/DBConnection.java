package gy;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static final String URL = "jdbc:mysql://1.94.104.154:3306/examination_system?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
    private static final String USER = "admin";
    private static final String PASSWORD = "Aa@123456"; // Ìæ»»ÎªÄãµÄMySQLÃÜÂë

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
