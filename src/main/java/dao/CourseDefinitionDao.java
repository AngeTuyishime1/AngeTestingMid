package dao;


import model.CourseDefinition;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class CourseDefinitionDao {

    public String saveCourseDefinition(CourseDefinition courseDefinition) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            session.save(courseDefinition);
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
    public CourseDefinition getCourseDefinitionByCode(String code) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            CourseDefinition courseDefinition = (CourseDefinition) session
                    .createQuery("from CourseDefinition where code = :code")
                    .setParameter("code", code)
                    .uniqueResult();
            session.close();
            return courseDefinition;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

