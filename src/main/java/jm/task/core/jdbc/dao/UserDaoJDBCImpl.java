package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try(Connection con = new Util().getConnection()){
            String customerTableQuery = "CREATE TABLE customers " +
                    "(id INTEGER PRIMARY KEY, name TEXT, age INTEGER)";
            Statement statement = con.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS new_schema.users (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(30), lastname VARCHAR(30), age INT)");
//            System.out.println("Таблица успешно создана");
        }catch (SQLException e){
//            System.out.println("Произошла ошибка при создании базы данных!");
        }
    }

    public void dropUsersTable() {
        try(Connection con = new Util().getConnection()){
            Statement statement = con.createStatement();
            statement.executeUpdate("DROP TABLE new_schema.users");
//            System.out.println("Таблица успешно удалена");
        }catch (SQLException e){
//            System.out.println("Произошла ошибка при удалении базы данных!");
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try(Connection con = new Util().getConnection()){
            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO new_schema.users VALUES (id ,?,?,?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, age);
            preparedStatement.executeUpdate();
//                System.out.println("Пользователь успешно добавлен");
        }
        catch (SQLException e){
//                System.out.println("Произошла ошибка при добавлении пользователя!");
        }
    }
    public void removeUserById(long id) {
        try(Connection con = new Util().getConnection()){
            Statement statement = con.createStatement();
            statement.executeUpdate("DELETE FROM new_schema.users WHERE id =" + id);
//            System.out.println("Пользователь с номером " + id + " успешно удален");
        }
        catch (SQLException e){
//            System.out.println("Ошибка при удалении пользователя!");
        }

    }
    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        try(Connection con = new Util().getConnection()) {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM new_schema.users");
            while(resultSet.next()){
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastname"));
                user.setAge((byte) resultSet.getInt("age"));
                list.add(user);
            }
            return list;
        }catch (SQLException e){
//            System.out.println("Получить список всех пользователей не удалось");
        }
        return null;
    }

    public void cleanUsersTable() {
        try(Connection con = new Util().getConnection()) {
            Statement statement = con.createStatement();
            statement.executeUpdate("TRUNCATE TABLE new_schema.users");
            System.out.println("Данные удалены");
        }catch (SQLException e){
//            System.out.println("Почистить таблицу не удалось!");
        }
    }
}
