package dao;

import model.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ResultDao {

    public List<StudentRegistration> getStudentsBySemesterWithJoin(Long semesterId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "SELECT sr FROM StudentRegistration sr " +
                "JOIN FETCH sr.regno student " +
                "JOIN FETCH sr.academicunit academicunit " +
                "WHERE sr.semester.id = :semesterId";

        Query<StudentRegistration> query = session.createQuery(hql, StudentRegistration.class);
        query.setParameter("semesterId", semesterId);

        List<StudentRegistration> students = query.getResultList();

        transaction.commit();
        session.close();

        return students;
    }

    public List<StudentRegistration> getStudentsInDifferentDepartments(Semester semester, AcademicUnit department) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "SELECT sr FROM StudentRegistration sr WHERE sr.semester = :semesterId AND sr.academicunit = :dep";

        Query<StudentRegistration> query = session.createQuery(hql, StudentRegistration.class);
        query.setParameter("semesterId", semester);
        query.setParameter( "dep", department );

        List<StudentRegistration> students = query.getResultList();

        transaction.commit();
        session.close();

        return students;
    }


        public List<Course> getCourseByDepartmentAndSemester(AcademicUnit department, Semester semester) {

        List<Course> courses=null;

            try (Session session = HibernateUtil.getSessionFactory().openSession()) {

                String hql1 = "SELECT c FROM Course c WHERE c.semester = :sem AND c.academicunit = :dep";
                Query<Course> query = session.createQuery(hql1, Course.class);
                query.setParameter("sem", semester);
                query.setParameter("dep", department);
                courses= query.getResultList();
                return courses;
            }
            catch (Exception e){
                e.printStackTrace();
                return null;
            }

            }


    public List<StudentRegistration> getStudentsWithCourses() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "SELECT sr FROM StudentRegistration sr " +
                "JOIN FETCH sr.regno student " +
                "JOIN FETCH sr.academicunit academicunit " +
                "JOIN FETCH sr.studentCourses studentCourse " + // Use "studentCourses" here
                "JOIN FETCH studentCourse.course course";


        Query<StudentRegistration> query = session.createQuery(hql, StudentRegistration.class);

        List<StudentRegistration> students = query.getResultList();

        transaction.commit();
        session.close();

        return students;
    }




}



