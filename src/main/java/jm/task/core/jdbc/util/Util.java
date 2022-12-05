package jm.task.core.jdbc.util;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String DB_URL = "jdbc:mysql://localhost:3306";
    private static String DB_USER = "root";
    private static String DB_PASS = "root";

    private static Connection connect;

    public static Connection getConnection() {
        connect = null;
        try {
            Class.forName(DB_DRIVER);
            connect = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (SQLException | RuntimeException | ClassNotFoundException e) {
            return null;
        }
        return connect;
    }

}
