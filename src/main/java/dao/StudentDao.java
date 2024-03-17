package dao;

import model.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDao {

    public String saveStudent(Student student) {
        Transaction transaction = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(student);
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
    public Student getStudentById(String studentId) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Student student = (Student) session
                    .createQuery("from Student where id = :studentId")
                    .setParameter("studentId", studentId)
                    .uniqueResult();
            session.close();
            return student;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}


