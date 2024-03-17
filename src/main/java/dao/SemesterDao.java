package dao;


import model.Semester;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SemesterDao {

    public String saveSemester(Semester semester) {

        Transaction transaction = null;
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.save(semester);
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
    public Semester getSemesterByCode(Long code) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Semester semester = (Semester) session
                    .createQuery("from Semester where id = :code")
                    .setParameter("code", code)
                    .uniqueResult();
            session.close();
            return semester;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}

