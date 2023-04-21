package dan.models;

import java.sql.Date;
import java.util.Calendar;
import java.util.Objects;

public class Student {
    private String id;
    private String name;
    private int grade;
    private Date birthday;
    private String address;
    private String notes;

    public Student(String id, String name, int grade, Date birthday, String address, String notes) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.birthday = birthday;
        this.address = address;
        this.notes = Objects.requireNonNullElse(notes, "");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", grade=" + grade + ", birthday=" + birthday + ", address=" + address + ", notes=" + notes + "]";
    }
}
