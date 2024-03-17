package model;

import javax.persistence.*;
@Entity
public class AcademicUnit {
    @Id
    @Column(length = 191)
    private String code;
    private String name;
    @Enumerated(EnumType.STRING)
    private EAcademicUnit academicType;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="parentcode", nullable = true)
    private AcademicUnit parentAcademic;

    public AcademicUnit() {
    }

    public AcademicUnit(String code, String name, EAcademicUnit academicType, AcademicUnit parentAcademic) {
        this.code = code;
        this.name = name;
        this.academicType = academicType;
        this.parentAcademic = parentAcademic;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EAcademicUnit getAcademicType() {
        return academicType;
    }

    public void setAcademicType(EAcademicUnit academicType) {
        this.academicType = academicType;
    }

    public AcademicUnit getParentAcademic() {
        return parentAcademic;
    }

    public void setParentAcademic(AcademicUnit parentAcademic) {
        this.parentAcademic = parentAcademic;
    }
}
