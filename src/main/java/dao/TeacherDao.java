package dao;

import model.Teacher;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TeacherDao {

    public String saveTeacher(Teacher teacher) {

        Transaction transaction = null;
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(teacher);
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
    public Teacher getTeacherByCode(String code) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Teacher teacher = (Teacher) session
                    .createQuery("from Teacher where code = :code")
                    .setParameter("code", code)
                    .uniqueResult();
            session.close();
            return teacher;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

