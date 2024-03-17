package dao;

import model.AcademicUnit;
import model.EAcademicUnit;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class AcademicUnitDaoTest {

    //@Test
    public void saveAcademicUnit() {
        AcademicUnit academicUnit = new AcademicUnit();
        AcademicUnitDao academicUnitDao = new AcademicUnitDao();

        academicUnit.setCode("NG11");
        academicUnit.setName("Undergraduate");
        academicUnit.setAcademicType(EAcademicUnit.PROGRAMME);

        String response = academicUnitDao.saveAcademicUnit(academicUnit);
        assertEquals("saved",response);
    }
    //@Test
    public void saveFaculty(){
        AcademicUnit academicUnit = new AcademicUnit();
        AcademicUnitDao academicUnitDao = new AcademicUnitDao();

        AcademicUnit parent = academicUnitDao.getAcademicUnitByCode("NG11");

        academicUnit.setCode("IT01");
        academicUnit.setName("IT");
        academicUnit.setAcademicType(EAcademicUnit.FACULTY);
        academicUnit.setParentAcademic(parent);

        String response = academicUnitDao.saveAcademicUnit(academicUnit);
        assertEquals("saved",response);
    }
    //@Test
    public void saveDepartment(){
        AcademicUnit academicUnit = new AcademicUnit();
        AcademicUnitDao academicUnitDao = new AcademicUnitDao();

        AcademicUnit parent = academicUnitDao.getAcademicUnitByCode("IT01");

        academicUnit.setCode("soft124");
        academicUnit.setName("software");
        academicUnit.setAcademicType(EAcademicUnit.DEPARTMENT);
        academicUnit.setParentAcademic(parent);

        String response = academicUnitDao.saveAcademicUnit(academicUnit);
        assertEquals("saved",response);
    }

}