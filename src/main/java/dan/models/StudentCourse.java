package dan.models;

public class StudentCourse {
    private String studentId;
    private String courseId;
    private float score;

    public StudentCourse(String studentId, String courseId, float score) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.score = score;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String toString() {
        return "StudentCourse [studentId=" + studentId + ", courseId=" + courseId + ", score=" + score + "]";
    }
}
