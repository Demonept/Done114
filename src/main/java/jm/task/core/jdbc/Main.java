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

        UserService userS = new UserServiceImpl();
        userS.createUsersTable();

        User user1 = new User("Имя","Фамилия", (byte) 12);
        User user2 = new User("Дмитрий","Савченко", (byte) 28);
        User user3 = new User("Василий","Непобежденный", (byte) 44);
        User user4 = new User("Кирилл","Дверьзапилил", (byte) 24);

        userS.saveUser(user1.getName(), user1.getLastName(), user1.getAge());
        userS.saveUser(user2.getName(), user2.getLastName(), user2.getAge());
        userS.saveUser(user3.getName(), user3.getLastName(), user3.getAge());
        userS.saveUser(user4.getName(), user4.getLastName(), user4.getAge());

        System.out.println(userS.getAllUsers().toString());

        userS.cleanUsersTable();

        userS.dropUsersTable();



    }


    }
