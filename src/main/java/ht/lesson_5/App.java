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
        System.out.println("Студенты вначале:");
        for (Student student1 : all) {
            System.out.println(student1.getName());
        }

        Student student = new Student();
        student.setName("testAdd");
        student.setMark(4);
        student.setId(UUID.randomUUID());
        Repository.add(student);

        System.out.println("Студенты после добавления:");
        all = Repository.findAll();
        for (Student student1 : all) {
            System.out.println(student1.getName());
        }

        Student temp = all.get(0);
        UUID id = temp.getId();
        Student studentById = Repository.findById(id);
        System.out.println("Студент по id: " + studentById.getName());

        studentById.setName("Changed name");

        Repository.update(studentById);
        studentById = Repository.findById(id);
        System.out.println("Студент по id после сохранения изменений: " + studentById.getName());

        Repository.removeById(id);

        all = Repository.findAll();
        System.out.println("Студенты после удаления:");
        for (Student student1 : all) {
            System.out.println(student1.getName());
        }
    }
}
