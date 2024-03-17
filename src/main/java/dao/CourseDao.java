package dao;

import model.Course;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CourseDao {

    public String saveCourse(Course course) {
        Transaction transaction = null;
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(course);
            transaction.commit();
            session.close();
            return "saved";
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return "error";
        }
    }

    public Course getCourseByCode(Long code) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Course course = (Course) session
                    .createQuery("from Course where code = :code")
                    .setParameter("code", code)
                    .uniqueResult();
            session.close();
            return course;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
