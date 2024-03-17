package dao;

import model.AcademicUnit;
import model.EAcademicUnit;
import model.Student;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentDaoTest {

    @Test
    public void saveStudent() {
        Student student = new Student();
        StudentDao studentDao = new StudentDao();

        student.setFullname("ruth Muranga");
        student.setDateofbirth("2000-11-11");
        student.setRegno("24430");

        String response = studentDao.saveStudent(student);
        assertEquals("saved",response);
    }
}