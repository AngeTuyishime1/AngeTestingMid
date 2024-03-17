package dao;

import model.StudentCourse;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentCourseDao {

    public void saveStudentCourse(StudentCourse studentCourse) {

        Transaction transaction = null;

        try {

            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(studentCourse);
            transaction.commit();
            session.close();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }

}


