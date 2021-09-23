package ht.lesson_5;

import ht.lesson_5.dao.Student;
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

import java.util.UUID;

public class App {
    private static SessionFactory factory;

    public static void main(String[] args) throws DatabaseException {
        factory = new Configuration().addAnnotatedClass(ht.lesson_5.dao.Student.class).buildSessionFactory();
        Session session = factory.openSession();
        Student student = new Student();
        student.setId(UUID.randomUUID());
        student.setMark(5);
        student.setName("Albert");
        session.beginTransaction();
        session.persist(student);
        session.getTransaction().commit();
    }
}
