package ht.lesson_5.repository;

import ht.lesson_5.dao.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Repository {
    private static final SessionFactory factory = new Configuration()
            .addAnnotatedClass(Student.class)
            .buildSessionFactory();

    public static List<Student> findAll() {
        try (Session session = factory.openSession()) {
            try {
                session.beginTransaction();
                List<Student> students = session.createQuery("select s from Student ", Student.class).getResultList();
                session.getTransaction().commit();
                return students;
            } catch (Exception e) {
                session.getTransaction().rollback();
                return null;
            }
        }
    }

}
