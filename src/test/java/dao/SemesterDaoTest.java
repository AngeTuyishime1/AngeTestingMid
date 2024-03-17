package dao;

import model.Semester;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class SemesterDaoTest {

    @Test
    public void saveSemester() {
        SemesterDao semesterDao = new SemesterDao();
        Semester semester = new Semester();

        semester.setName("semester one");
        Date startDate = Date.valueOf("2024-01-21");
        Date endDate = Date.valueOf("2024-05-24");
        semester.setStartDate(startDate);
        semester.setEndDate(endDate);

        String response=semesterDao.saveSemester(semester);
        assertEquals("saved",response);
    }
}