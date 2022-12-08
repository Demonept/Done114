package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    private static String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String DB_URL = "jdbc:mysql://localhost:3306";
    private static String DB_USER = "root";
    private static String DB_PASS = "root";

    private static Connection connect;

    private static SessionFactory sessionFactory;


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

    public static SessionFactory getSession() {
        Properties prop = new Properties();
        prop.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/MySql?currentSchema=users");
        prop.setProperty("hibernate.connection.username", "root");
        prop.setProperty("hibernate.connection.password", "root");
        prop.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        prop.setProperty("hibernate.id.new_generator_mappings","false");
        prop.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
        prop.setProperty("Environment.HBM2DDL_AUTO", "");
        prop.setProperty("show_sql", "true");
        SessionFactory sessionFactory = new org.hibernate.cfg.Configuration()
                .addProperties(prop)
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
        return sessionFactory;
    }

}
