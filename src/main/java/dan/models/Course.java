package dan.models;

import java.util.Objects;

public class Course {
    private String id;
    private String name;
    private String lecturer;
    private int year;
    private String notes;

    public Course(String id, String name, String lecturer, int year, String notes) {
        this.id = id;
        this.name = name;
        this.lecturer = lecturer;
        this.year = year;
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

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String toString() {
        return "Course [id=" + id + ", name=" + name + ", lecturer=" + lecturer + ", year=" + year + ", notes=" + notes + "]";
    }

}
