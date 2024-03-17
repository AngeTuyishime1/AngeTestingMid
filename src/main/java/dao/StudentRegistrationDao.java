package dao;

import model.Eregistration;
import model.StudentRegistration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentRegistrationDao {

    public String saveStudentRegistration(StudentRegistration studentRegistration) {

        Transaction transaction = null;
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.save(studentRegistration);
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
    public void updateStudentRegistrationStatus(Integer registrationId, Eregistration newStatus) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            StudentRegistration studentRegistration = session.get(StudentRegistration.class, registrationId);
            if (studentRegistration != null) {
                studentRegistration.setStatus(newStatus);
                session.update(studentRegistration);
            }

            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


    public void deleteStudentRegistration(StudentRegistration studentRegistration) {

        Transaction transaction = null;
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.delete(studentRegistration);
            transaction.commit();
            session.close();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }

    public StudentRegistration getStudentRegistrationByCode(Integer code) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            StudentRegistration studentRegistration = (StudentRegistration) session
                    .createQuery("from StudentRegistration where id = :code")
                    .setParameter("code", code)
                    .uniqueResult();
            session.close();
            return studentRegistration;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

