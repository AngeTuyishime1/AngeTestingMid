package dao;

import model.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourseDaoTest {

    @Test
    public void saveCourse() {
        AcademicUnitDao academicUnitDao = new AcademicUnitDao();
        CourseDefinitionDao courseDefinitionDao = new CourseDefinitionDao();
        TeacherDao teacherDao = new TeacherDao();
        CourseDao courseDao = new CourseDao();
        SemesterDao semesterDao = new SemesterDao();

        AcademicUnit academicUnit = academicUnitDao.getAcademicUnitByCode("soft124");
        CourseDefinition courseDefinition = courseDefinitionDao.getCourseDefinitionByCode("sft2020");
        Semester semester = semesterDao.getSemesterByCode(1L);
        Teacher teacher = teacherDao.getTeacherByCode("r2035");
        Course course = new Course();

        course.setAcademicunit(academicUnit);
        course.setCousedefinition(courseDefinition);
        course.setSemester(semester);
        course.setCode("Mgt111");
        course.setTeacher(teacher);

        String response = courseDao.saveCourse(course);
        assertEquals("saved", response);
    }
}