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
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import org.hibernate.AnnotationException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class App {
    private static SessionFactory factory;

    public static void main(String[] args) throws DatabaseException {

        java.sql.Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/geekbrains", "login", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(connection));
        Liquibase liquibase = new liquibase.Liquibase("db/dbchangelog.xml", new ClassLoaderResourceAccessor(), database);
        try {
            liquibase.update(new Contexts(), new LabelExpression());
        } catch (LiquibaseException e) {
            e.printStackTrace();
        }


//        List<Student> all = Repository.findAll();
//        System.out.println("Студенты вначале:");
//        for (Student student1 : all) {
//            System.out.println(student1.getName());
//        }
//
//        Student student = new Student();
//        student.setName("testAdd");
//        student.setMark(4);
//        student.setId(UUID.randomUUID());
//        Repository.add(student);
//
//        System.out.println("Студенты после добавления:");
//        all = Repository.findAll();
//        for (Student student1 : all) {
//            System.out.println(student1.getName());
//        }
//
//        Student temp = all.get(0);
//        UUID id = temp.getId();
//        Student studentById = Repository.findById(id);
//        System.out.println("Студент по id: " + studentById.getName());
//
//        studentById.setName("Changed name");
//
//        Repository.update(studentById);
//        studentById = Repository.findById(id);
//        System.out.println("Студент по id после сохранения изменений: " + studentById.getName());
//
//        Repository.removeById(id);
//
//        all = Repository.findAll();
//        System.out.println("Студенты после удаления:");
//        for (Student student1 : all) {
//            System.out.println(student1.getName());
//        }
    }
}
