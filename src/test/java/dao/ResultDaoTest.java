package dao;

import model.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ResultDaoTest {

   // @Test
    public void getStudentsBySemesterWithJoin() {

        ResultDao resultDao = new ResultDao();
        SemesterDao semesterDao = new SemesterDao();
        List<StudentRegistration> students = resultDao.getStudentsBySemesterWithJoin(1L);

        if (students != null && !students.isEmpty()) {
            System.out.println("======================");
            for (StudentRegistration student : students) {
                System.out.println(student.getRegno().getRegno() + " - " + student.getRegno().getFullname() + " - " + student.getSemester().getName());
            }
            assertFalse(students.isEmpty());
        } else {
            assertTrue(students.isEmpty());
            System.out.println("No students found!");
        }
    }

    //@Test
    public void getStudentsInDifferentDepartments() {
        ResultDao resultDao = new ResultDao();
        SemesterDao semesterDao = new SemesterDao();
        AcademicUnitDao academicUnitDao = new AcademicUnitDao();

        Semester semester = semesterDao.getSemesterByCode(1L);
        AcademicUnit academicUnit = academicUnitDao.getAcademicUnitByCode("soft124");

        List<StudentRegistration> students = resultDao.getStudentsInDifferentDepartments(semester, academicUnit);
        if (students != null && !students.isEmpty()) {
            System.out.println("======================");
            for (StudentRegistration student : students) {
                System.out.println(student.getRegno().getRegno() +
                        " - " + student.getRegno().getFullname() +
                        " - " + student.getSemester().getName() +
                        " - " + student.getAcademicunit().getName());
            }
            assertFalse(students.isEmpty());
        } else {
            assertTrue(students.isEmpty());
            System.out.println("No students found!");
        }
    }
        @Test
        public void getCourseBySemesterAndDepartment(){
            ResultDao resultDao = new ResultDao();
            SemesterDao semesterDao = new SemesterDao();
            AcademicUnitDao academicUnitDao = new AcademicUnitDao();

            Semester semester = semesterDao.getSemesterByCode(1L);
            AcademicUnit department = academicUnitDao.getAcademicUnitByCode("soft124");

            List<Course> courses = resultDao.getCourseByDepartmentAndSemester(department,semester);
            if (courses != null && !courses.isEmpty()) {
                System.out.println("======================");
                for (Course course : courses) {
                    System.out.println(course.getCousedefinition().getCode()+
                            " - " + course.getCousedefinition().getName() +
                            " - " + department.getName());
                }
                assertFalse(courses.isEmpty());
            } else {
                assertTrue(courses.isEmpty());
                System.out.println("No courses found!");
            }
        }


        }

