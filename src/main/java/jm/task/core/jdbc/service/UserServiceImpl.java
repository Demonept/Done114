package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    public void createUsersTable() {
        UserDaoJDBCImpl user = new UserDaoJDBCImpl();
        user.createUsersTable();
    }

    public void dropUsersTable() {
        UserDaoJDBCImpl user = new UserDaoJDBCImpl();
        user.dropUsersTable();

    }

    public void saveUser(String name, String lastName, byte age) {
        UserDaoJDBCImpl user = new UserDaoJDBCImpl();
        user.saveUser(name, lastName, age);

    }

    public void removeUserById(long id) {
        UserDaoJDBCImpl user = new UserDaoJDBCImpl();
        user.removeUserById(id);
    }

    public List<User> getAllUsers() {
        UserDaoJDBCImpl user = new UserDaoJDBCImpl();
        return user.getAllUsers();
    }

    public void cleanUsersTable() {
        UserDaoJDBCImpl user = new UserDaoJDBCImpl();
        user.cleanUsersTable();
    }
}
