
package org.example;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseManager {

    private final String URL = "jdbc:mysql://localhost:3306/school"; // CHANGED
    private final String USER = "root";
    private final String PASSWORD = "anurag@23";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void addStudent(Student student) {
        String sql = "INSERT INTO students(name, course) VALUES(?, ?)";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, student.getName());
            ps.setString(2, student.getCourse());
            ps.executeUpdate();

            System.out.println("Student added successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students";

        try (Connection con = getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("course")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public void updateStudent(int id, String name, String course) {
        String sql = "UPDATE students SET name=?, course=? WHERE id=?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, course);
            ps.setInt(3, id);

            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Student updated!");
            else
                System.out.println("Student not found!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id=?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Student deleted!");
            else
                System.out.println("Student not found!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
