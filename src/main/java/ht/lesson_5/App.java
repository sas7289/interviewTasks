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
import java.util.Random;
import java.util.UUID;

public class App {
    private static SessionFactory factory;

    public static void main(String[] args) throws DatabaseException {

        liquibaseInit();
        List<Student> all = Repository.findAll();
        if (all.isEmpty()) {
            fillTable();
        }


        System.out.println("Студенты вначале:");
        showAll(all);

        Student student = new Student();
        student.setName("testAdd");
        student.setMark(4);
        UUID testId = UUID.randomUUID();
        student.setId(testId);
        Repository.add(student);

        System.out.println("Студенты после добавления:");
        all = Repository.findAll();
        showAll(all);


        Student studentById = Repository.findById(testId);
        System.out.println("Студент по id: " + studentById.getName());


        studentById.setName("Changed name");
        Repository.update(studentById);
        studentById = Repository.findById(testId);
        System.out.println("Студент по id после сохранения изменений: " + studentById.getName());


        Repository.removeById(testId);


        studentById = Repository.findById(testId);
        if(studentById == null) {
            System.out.println("Студент не найден");
        }

        all = Repository.findAll();
        showAll(all);
    }

    private static void showAll(List<Student> all) {
        int count = 0;
        for (Student student1 : all) {
                System.out.print(student1.getName() + " ");
                count++;
                if(count == 15) {
                    System.out.println();
                    count = 0;
                }
        }
    }

    private static void liquibaseInit() throws DatabaseException {
        java.sql.Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/geekbrains", "login", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(connection));
        Liquibase liquibase = new Liquibase("db/dbchangelog.xml", new ClassLoaderResourceAccessor(), database);
        try {
            liquibase.update(new Contexts(), new LabelExpression());
        } catch (LiquibaseException e) {
            e.printStackTrace();
        }
    }


    private static void fillTable() {
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            Student student = new Student();
            student.setName("student_" + i + 1);
            student.setMark(Math.abs(random.nextInt() % 5) + 1);
            student.setId(UUID.randomUUID());
            Repository.add(student);
        }
    }
}
