package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws SQLException {
//        Util connect = new Util();
        UserService userS = new UserServiceImpl();
        UserDao userDao = new UserDaoJDBCImpl();
//        Connection con = connect.getConnection();
//        con.close();
        User user1 = new User("Имя","Фамилия", (byte) 12);
        User user2 = new User("Дмитрий","Савченко", (byte) 28);
        User user3 = new User("Василий","Непобежденный", (byte) 44);
        User user4 = new User("Кирилл","Дверьзапилил", (byte) 24);



//        userS.createUsersTable();

        userS.saveUser(user1.getName(),user1.getLastName(),user1.getAge());
        userS.saveUser(user2.getName(),user2.getLastName(),user2.getAge());
        userS.saveUser(user3.getName(),user3.getLastName(),user3.getAge());
        userS.saveUser(user4.getName(),user4.getLastName(),user4.getAge());
        userS.saveUser(user1.getName(),user1.getLastName(),user1.getAge());


        System.out.print(userS.getAllUsers().toString());
//        System.out.println(userS.getAllUsers().


//        userS.removeUserById(2);
//        userS.removeUserById(1);
//        userS.cleanUsersTable();
//        userS.removeUserById(1);
//        userS.removeUserById(1);
//        userS.dropUsersTable();




//        try(Connection con = new Util().getConnection()){
//            Statement statement = con.createStatement();
//            statement.executeUpdate("DROP TABLE new_schema.users");
//        }catch (SQLException e){
//            throw e;
////            System.out.println("Произошла ошибка при удалении базы данных!");
        }

//        try{
//            Statement statement = con.createStatement();
//            ResultSet resultSet = statement.executeQuery(query);
//            preparedStatement.executeUpdate();
//            System.out.println("Персона добавлена");
//            while(resultSet.next()){
//                String id = resultSet.getString("name");
//                System.out.println(id);
//            }
//        }
//        catch (SQLException e){
//            throw e;
////            System.out.println("Не вышло");
//        }

//        Statement statement = util.createStatement();
    }
