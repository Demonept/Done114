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
        try(Connection con = Util.getConnection()){
            Statement statement = con.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS new_schema.users (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(30), lastname VARCHAR(30), age INT)");
        }catch (SQLException e){
        }
    }

    public void dropUsersTable() {
        try(Connection con = Util.getConnection()){
            Statement statement = con.createStatement();
            statement.executeUpdate("DROP TABLE new_schema.users");
        }catch (SQLException e){
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try(Connection con = Util.getConnection()){
            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO new_schema.users VALUES (id ,?,?,?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, age);
            preparedStatement.executeUpdate();
            System.out.println("User с именем - " + name + " добавлен в таблицу.");
        }
        catch (SQLException e){
        }
    }
    public void removeUserById(long id) {
        try(Connection con = Util.getConnection()){
            PreparedStatement statement = con.prepareStatement("DELETE FROM new_schema.users WHERE id =" + id);
            statement.executeUpdate();
        }
        catch (SQLException e){
        }

    }
    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        try(Connection con = Util.getConnection())
        {
            PreparedStatement statement = con.prepareStatement("SELECT * FROM new_schema.users");
            ResultSet resultSet = statement.executeQuery();
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
        }
        return null;
    }

    public void cleanUsersTable() {
        try(Connection con = Util.getConnection()) {
            Statement statement = con.createStatement();
            statement.executeUpdate("TRUNCATE TABLE new_schema.users");
            System.out.println("Таблица успешно удалена");
        }catch (SQLException e){
        }
    }
}
