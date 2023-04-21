package dan.dao;

import dan.db.Jdbc;
import dan.models.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDao implements Dao<Student> {
    @Override
    public Student get(String id) {
        try {
            Connection connection = Jdbc.getConnection();
            String sql = "SELECT * FROM Student WHERE id = ?";
            if (connection != null) {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, id);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    Student student = new Student(resultSet.getString("id"), resultSet.getString("name"), resultSet.getInt("grade"), resultSet.getDate("birthday"), resultSet.getString("address"), resultSet.getString("notes"));
                    connection.close();
                    return student;
                }
                connection.close();
            }
        } catch (Exception ignored) {
        }
        return null;
    }

    @Override
    public List<Student> getAll() {
        try {
            Connection connection = Jdbc.getConnection();
            String sql = "SELECT * FROM Student";
            if (connection != null) {
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();
                List<Student> students = new ArrayList<>();
                while (resultSet.next()) {
                    students.add(new Student(resultSet.getString("id"), resultSet.getString("name"), resultSet.getInt("grade"), resultSet.getDate("birthday"), resultSet.getString("address"), resultSet.getString("notes")));
                }
                connection.close();
                return students;

            }
        } catch (Exception ignored) {
        }
        return null;
    }

    @Override
    public boolean insert(Student student) {
        try {
            Connection connection = Jdbc.getConnection();
            String sql = "INSERT INTO Student VALUES (?, ?, ?, ?, ?, ?)";
            if (connection != null) {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, student.getId());
                statement.setString(2, student.getName());
                statement.setInt(3, student.getGrade());
                statement.setDate(4, student.getBirthday());
                statement.setString(5, student.getAddress());
                statement.setString(6, student.getNotes());
                boolean isSuccessful = statement.executeUpdate() > 0;
                connection.close();
                return isSuccessful;
            }
        } catch (Exception ignored) {
        }
        return false;
    }

    @Override
    public boolean update(Student student) {
        try {
            Connection connection = Jdbc.getConnection();
            String sql = "UPDATE Student SET name = ?, grade = ?, birthday = " + "?, address = ?, notes = ? WHERE id = ?";
            if (connection != null) {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, student.getName());
                statement.setInt(2, student.getGrade());
                statement.setDate(3, student.getBirthday());
                statement.setString(4, student.getAddress());
                statement.setString(5, student.getNotes());
                statement.setString(6, student.getId());
                boolean isSuccessful = statement.executeUpdate() > 0;
                connection.close();
                return isSuccessful;
            }
        } catch (Exception ignored) {
        }
        return false;
    }

    @Override
    public boolean delete(Student student) {
        try {
            Connection connection = Jdbc.getConnection();
            String sql = "DELETE FROM Student WHERE id = ?";
            if (connection != null) {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, student.getId());
                boolean isSuccessful = statement.executeUpdate() > 0;
                connection.close();
                return isSuccessful;
            }
        } catch (Exception ignored) {
        }
        return false;
    }

    public List<Student> findByName(String name) {
        try {
            Connection connection = Jdbc.getConnection();
            String sql = "SELECT * FROM Student WHERE name LIKE ?";
            if (connection != null) {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, "%" + name + "%");
                ResultSet resultSet = statement.executeQuery();
                List<Student> students = new ArrayList<>();
                while (resultSet.next()) {
                    students.add(new Student(resultSet.getString("id"), resultSet.getString("name"), resultSet.getInt("grade"), resultSet.getDate("birthday"), resultSet.getString("address"), resultSet.getString("notes")));
                }
                connection.close();
                return students;
            }
        } catch (Exception ignored) {
        }
        return null;
    }

}
