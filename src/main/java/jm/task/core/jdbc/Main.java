package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import org.hibernate.SessionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws SQLException {
        long im = 2;
        User user1 = new User("Имя","Фамилия", (byte) 12);
        User user2 = new User("Дмитрий","Савченко", (byte) 28);
        User user3 = new User("Василий","Непобежденный", (byte) 44);
        User user4 = new User("Кирилл","Дверьзапилил", (byte) 24);

        UserDaoHibernateImpl userH = new UserDaoHibernateImpl();
        userH.createUsersTable();

        userH.saveUser(user1.getName(),user1.getLastName(),user1.getAge());
        userH.saveUser(user2.getName(),user2.getLastName(),user2.getAge());
        userH.saveUser(user3.getName(),user3.getLastName(),user3.getAge());
        userH.saveUser(user4.getName(),user4.getLastName(),user4.getAge());
        userH.removeUserById(im);

        System.out.println((userH.getAllUsers()).toString());

        userH.dropUsersTable();
        userH.createUsersTable();
        userH.cleanUsersTable();

    }
    }
