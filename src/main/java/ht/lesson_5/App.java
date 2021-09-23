package ht.lesson_5;

import ht.lesson_5.dao.Student;
import ht.lesson_5.repository.Repository;
import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.DatabaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import org.hibernate.AnnotationException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.UUID;

public class App {
    private static SessionFactory factory;

    public static void main(String[] args) throws DatabaseException {
        List<Student> all = Repository.findAll();
        System.out.println(all.get(0));
    }
}
