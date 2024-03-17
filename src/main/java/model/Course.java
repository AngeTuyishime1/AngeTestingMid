package model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="course")
public class Course {

    @Id
    @Column(length = 100)
    private String code;
    @OneToOne
    @JoinColumn(name = "coursedefinition_code", nullable = true)
    private CourseDefinition cousedefinition;

    @ManyToOne
    @JoinColumn(name = "teacher_code", nullable = true)
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "semester_id", nullable = true)
    private Semester semester;

    @ManyToOne
    @JoinColumn(name = "academicunit_code", nullable = true)
    private AcademicUnit academicunit;

    @OneToMany(mappedBy = "course")
    private List<StudentCourse> studentCourses;

    public Course() {
        super();
    }

    public Course(String code, CourseDefinition cousedefinition, Teacher teacher, Semester semester,
                  AcademicUnit academicunit) {
        super();
        this.code = code;
        this.cousedefinition = cousedefinition;
        this.teacher = teacher;
        this.semester = semester;
        this.academicunit = academicunit;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public CourseDefinition getCousedefinition() {
        return cousedefinition;
    }

    public void setCousedefinition(CourseDefinition cousedefinition) {
        this.cousedefinition = cousedefinition;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public AcademicUnit getAcademicunit() {
        return academicunit;
    }

    public void setAcademicunit(AcademicUnit academicunit) {
        this.academicunit = academicunit;
    }

    public List<StudentCourse> getStudentCourses() {
        return studentCourses;
    }

    public void setStudentCourses(List<StudentCourse> studentCourses) {
        this.studentCourses = studentCourses;
    }
}


