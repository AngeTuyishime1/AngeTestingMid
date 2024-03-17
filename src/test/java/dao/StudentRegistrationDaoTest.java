package dao;

import model.*;
import org.junit.Test;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class StudentRegistrationDaoTest {

    //@Test
    public void saveStudentRegistration() {
        StudentRegistrationDao studentRegistrationDao = new StudentRegistrationDao();
        AcademicUnitDao academicUnitDao = new AcademicUnitDao();
        SemesterDao semesterDao = new SemesterDao();
        StudentDao studentDao = new StudentDao();

        StudentRegistration studentRegistration = new StudentRegistration();
        AcademicUnit academicUnit = academicUnitDao.getAcademicUnitByCode("soft124");
        Semester semester = semesterDao.getSemesterByCode(1L);
        Student student = studentDao.getStudentById("24430");



        studentRegistration.setId(24430);
        studentRegistration.setAcademicunit(academicUnit);
        studentRegistration.setSemester(semester);

        LocalDate currentDate = LocalDate.now();
        Date date = Date.valueOf(currentDate);

        studentRegistration.setRegistrationDate(date);
        studentRegistration.setRegno(student);
        studentRegistration.setStatus(Eregistration.PENDING);

        String response = studentRegistrationDao.saveStudentRegistration(studentRegistration);

        assertEquals("saved", response);
    }
}