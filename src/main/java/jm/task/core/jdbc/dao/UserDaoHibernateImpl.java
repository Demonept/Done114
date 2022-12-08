package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class UserDaoHibernateImpl implements UserDao {

    SessionFactory sesF = Util.getSession();
    public UserDaoHibernateImpl() {

    }
    @Override
    public void createUsersTable() {
        try(Session ses = sesF.openSession()) {
            Query query = ses.createSQLQuery("CREATE TABLE IF NOT EXISTS new_schema.users (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(30), lastname VARCHAR(30), age INT)");
            ses.beginTransaction();
            query.executeUpdate();
            ses.getTransaction().commit();
        }
    }
    @Override
    public void dropUsersTable() {
        try(Session ses = sesF.openSession()) {
            Query query = ses.createSQLQuery("DROP TABLE new_schema.users");
            ses.beginTransaction();
            query.executeUpdate();
            ses.getTransaction().commit();
        }
    }
    @Override
    public void saveUser(String name, String lastName, byte age) {
        try(Session ses = sesF.openSession()){
            ses.beginTransaction();
            ses.save(new User(name, lastName, age));
            ses.getTransaction().commit();
            System.out.println("Юзер с именем " + name + " добавлен в таблицу.");

        }
    }

    @Override
    public void removeUserById(long id) {
        try(Session ses = sesF.openSession()){
            ses.beginTransaction();
            User us = ses.get(User.class, id);
            ses.delete(us);
            ses.getTransaction().commit();
        }
    }

    @Override
    public List<User> getAllUsers() {
        try(Session ses = sesF.openSession()) {
            ses.beginTransaction();
            List<User> query = ses.createQuery("from User").getResultList();
            ses.getTransaction().commit();
            return query;
        }
    }

    @Override
    public void cleanUsersTable() {
        try(Session ses = sesF.openSession()){
            ses.beginTransaction();
            ses.createQuery("delete User").executeUpdate();
            ses.getTransaction().commit();
        }

    }
}
