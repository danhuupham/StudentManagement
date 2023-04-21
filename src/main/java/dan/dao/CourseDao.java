package dan.dao;

import dan.db.Jdbc;
import dan.models.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CourseDao implements Dao<Course> {
    @Override
    public Course get(String id) {
        try {
            Connection connection = Jdbc.getConnection();
            String sql = "SELECT * FROM Course WHERE id = ?";
            if (connection != null) {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, id);
                ResultSet resultSet = statement.executeQuery();
                Course course = new Course(resultSet.getString("id"), resultSet.getString("name"), resultSet.getString("lecturer"), resultSet.getInt("year"), resultSet.getString("notes"));
                connection.close();
                return course;
            }
        } catch (Exception ignored) {
        }
        return null;
    }

    @Override
    public List<Course> getAll() {
        try {
            Connection connection = Jdbc.getConnection();
            String sql = "SELECT * FROM Course";
            if (connection != null) {
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();
                List<Course> courses = new ArrayList<>();
                while (resultSet.next()) {
                    courses.add(new Course(resultSet.getString("id"), resultSet.getString("name"), resultSet.getString("lecturer"), resultSet.getInt("year"), resultSet.getString("notes")));
                }
                connection.close();
                return courses;
            }
        } catch (Exception ignored) {
        }
        return null;
    }

    @Override
    public boolean insert(Course course) {
        try {
            Connection connection = Jdbc.getConnection();
            String sql = "INSERT INTO Course VALUES (?, ?, ?, ?, ?)";
            if (connection != null) {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, course.getId());
                statement.setString(2, course.getName());
                statement.setString(3, course.getLecturer());
                statement.setInt(4, course.getYear());
                statement.setString(5, course.getNotes());
                boolean isSuccessful = statement.executeUpdate() > 0;
                connection.close();
                return isSuccessful;
            }
        } catch (Exception ignored) {
        }
        return false;
    }

    @Override
    public boolean update(Course course) {
        try {
            Connection connection = Jdbc.getConnection();
            String sql = "UPDATE Course SET name = ?, lecturer = ?, year = ?, notes = ? WHERE id = ?";
            if (connection != null) {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, course.getName());
                statement.setString(2, course.getLecturer());
                statement.setInt(3, course.getYear());
                statement.setString(4, course.getNotes());
                statement.setString(5, course.getId());
                boolean isSuccessful = statement.executeUpdate() > 0;
                connection.close();
                return isSuccessful;
            }
        } catch (Exception ignored) {
        }
        return false;
    }

    @Override
    public boolean delete(Course course) {
        try {
            Connection connection = Jdbc.getConnection();
            String sql = "DELETE FROM Course WHERE id = ?";
            if (connection != null) {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, course.getId());
                boolean isSuccessful = statement.executeUpdate() > 0;
                connection.close();
                return isSuccessful;
            }
        } catch (Exception ignored) {
        }
        return false;
    }
}
