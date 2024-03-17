package dao;

import model.CourseDefinition;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourseDefinitionDaoTest {

    @Test
    public void saveCourseDefinition() {
        CourseDefinitionDao courseDefinitionDao = new CourseDefinitionDao();
        CourseDefinition courseDefinition = new CourseDefinition();

        courseDefinition.setCode("Sft2020");
        courseDefinition.setName("software secutity");
        courseDefinition.setDescription("Course for software");

        String response=courseDefinitionDao.saveCourseDefinition(courseDefinition);
        assertEquals("saved",response);
    }
}