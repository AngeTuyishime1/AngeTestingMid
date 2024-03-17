package dao;

import model.Equalification;
import model.Teacher;
import org.junit.Test;

import static org.junit.Assert.*;

public class TeacherDaoTest {

    @Test
    public void saveTeacher() {
        Teacher teacher = new Teacher();
        TeacherDao teacherDao = new TeacherDao();

        teacher.setCode("r2035");
        teacher.setNames("condo");
        teacher.setQualification(Equalification.PHD);

        String response = teacherDao.saveTeacher(teacher);
        assertEquals("saved", response);
    }
}