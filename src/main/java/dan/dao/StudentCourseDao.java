package dan.dao;

import dan.db.Jdbc;
import dan.models.StudentCourse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentCourseDao implements Dao<StudentCourse> {
    @Override
    public StudentCourse get(String id) {
        return null;
    }

    public StudentCourse get(String studentId, String courseId) {
        try {
            Connection connection = Jdbc.getConnection();
            String sql = "SELECT * FROM StudentCourse WHERE studentId = ? AND courseId = ?";
            if (connection != null) {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, studentId);
                statement.setString(2, courseId);
                ResultSet resultSet = statement.executeQuery();
                StudentCourse studentCourse = new StudentCourse(resultSet.getString("studentId"), resultSet.getString("courseId"), resultSet.getInt("grade"));
                connection.close();
                return studentCourse;
            }
        } catch (Exception ignored) {
        }
        return null;
    }

    @Override
    public List<StudentCourse> getAll() {
        try {
            Connection connection = Jdbc.getConnection();
            String sql = "SELECT * FROM StudentCourse";
            if (connection != null) {
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();
                List<StudentCourse> studentCourses = new ArrayList<>();
                while (resultSet.next()) {
                    studentCourses.add(new StudentCourse(resultSet.getString("studentId"), resultSet.getString("courseId"), resultSet.getInt("grade")));
                }
                connection.close();
                return studentCourses;
            }
        } catch (Exception ignored) {
        }
        return null;
    }

    @Override
    public boolean insert(StudentCourse studentCourse) {
        try {
            Connection connection = Jdbc.getConnection();
            String sql = "INSERT INTO StudentCourse VALUES (?, ?, ?)";
            if (connection != null) {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, studentCourse.getStudentId());
                statement.setString(2, studentCourse.getCourseId());
                statement.setFloat(3, studentCourse.getScore());
                boolean isSuccessful = statement.executeUpdate() > 0;
                connection.close();
                return isSuccessful;
            }
        } catch (Exception ignored) {
        }
        return false;
    }

    @Override
    public boolean update(StudentCourse studentCourse) {
        try {
            Connection connection = Jdbc.getConnection();
            String sql = "UPDATE StudentCourse SET score = ? WHERE studentId = ? AND courseId = ?";
            if (connection != null) {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setFloat(1, studentCourse.getScore());
                statement.setString(2, studentCourse.getStudentId());
                statement.setString(3, studentCourse.getCourseId());
                boolean isSuccessful = statement.executeUpdate() > 0;
                connection.close();
                return isSuccessful;
            }
        } catch (Exception ignored) {
        }
        return false;
    }

    @Override
    public boolean delete(StudentCourse studentCourse) {
        try {
            Connection connection = Jdbc.getConnection();
            String sql = "DELETE FROM StudentCourse WHERE studentId = ? AND courseId = ?";
            if (connection != null) {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, studentCourse.getStudentId());
                statement.setString(2, studentCourse.getCourseId());
                boolean isSuccessful = statement.executeUpdate() > 0;
                connection.close();
                return isSuccessful;
            }
        } catch (Exception ignored) {
        }
        return false;
    }
}
