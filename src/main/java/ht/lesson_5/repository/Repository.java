package ht.lesson_5.repository;

import ht.lesson_5.dao.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.UUID;

public class Repository {
    private static final SessionFactory factory = new Configuration()
            .addAnnotatedClass(Student.class)
            .buildSessionFactory();

    public static List<Student> findAll() {
        try (Session session = factory.getCurrentSession()) {
            try {
                session.beginTransaction();
                List<Student> students = session.createQuery("select s from Student s", Student.class).getResultList();
                session.getTransaction().commit();
                return students;
            } catch (Exception e) {
                session.getTransaction().rollback();
                return null;
            }
        }
    }

    public static Student findById(UUID uuid) {
        try (Session session = factory.getCurrentSession()) {
            try {
                session.beginTransaction();
                Student student = session.get(Student.class, uuid);
                session.getTransaction().commit();
                return student;
            } catch (Exception e) {
                session.getTransaction().rollback();
                return null;
            }
        }
    }

    public static boolean add(Student student) {
        try (Session session = factory.getCurrentSession()) {
            try {
                session.beginTransaction();
                session.persist(student);
                session.getTransaction().commit();
                return true;
            } catch (Exception e){
                session.getTransaction().rollback();
                return false;
            }
        }
    }

    public static boolean removeById(UUID uuid) {
        try (Session session = factory.getCurrentSession()){
            try {
                session.beginTransaction();
                Student student = session.get(Student.class, uuid);
                session.delete(student);
                session.getTransaction().commit();
                return true;
            } catch (Exception e) {
                session.getTransaction().rollback();
                return false;
            }
        }
    }

    public static Student update(Student student) {
        try (Session session = factory.getCurrentSession()){
            try {
                session.beginTransaction();
                session.update(student);
                session.getTransaction().commit();
                return student;
            } catch (Exception e) {
                session.getTransaction().commit();
                return null;
            }
        }
    }

}
