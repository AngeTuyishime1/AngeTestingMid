package dao;

import model.AcademicUnit;
import model.Teacher;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AcademicUnitDao {
    public String saveAcademicUnit(AcademicUnit academicUnit){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(academicUnit);
            transaction.commit();
            return "saved";
        }catch (Exception e){
            if(transaction!=null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return "error";
        }
    }

    public AcademicUnit getAcademicUnitByCode(String code){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            AcademicUnit academicUnit = (AcademicUnit) session
                    .createQuery("from AcademicUnit where code = :code")
                    .setParameter("code", code)
                    .uniqueResult();
            session.close();
            return academicUnit;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
