package dao.impl;

import dao.DAO;
import entity.Student;
import entity.Team;
import utils.PropsReader;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentDAO extends DAO<Student> {
    private final String URL = "jdbc:postgresql://localhost/denanery";

    @Override
    public Optional<Student> get(long id) {
        Student student = new Student();

        try (Connection connection = DriverManager.getConnection(URL, PropsReader.read())) {
            PreparedStatement statement = connection.prepareStatement("select * from team where id = " + id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            student.setId(resultSet.getInt(1));
            student.setFirstName(resultSet.getString(2));
            student.setSecoundName(resultSet.getString(3));
            student.setPatronymic(resultSet.getString(4));
            student.setTeamId(resultSet.getInt(1));
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.of(student);
    }

    @Override
    public List<Student> getAll() {
        ArrayList<Student> students = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, PropsReader.read())) {
            PreparedStatement statement = connection.prepareStatement("select * from team");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt(1));
                student.setFirstName(resultSet.getString(2));
                student.setSecoundName(resultSet.getString(3));
                student.setPatronymic(resultSet.getString(4));
                student.setTeamId(resultSet.getInt(1));
                students.add(student);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public void save(Student student) {

        String insertQuery = "INSERT INTO team (first_name,secound_name,patronymic,team_id) " +
                "VALUES('" + student.getFirstName() + "','" + student.getSecoundName() + "','" + student.getSecoundName() + "')";
        try (Connection connection = DriverManager.getConnection(URL, PropsReader.read())) {
            PreparedStatement statement = connection.prepareStatement(insertQuery);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Student student, Student updateStudent) {
        String updateQuery = "update student set firstName =" + updateStudent.getFirstName() +
                ",secoundName =" + updateStudent.getSecoundName() +
                ",patronymic =" + updateStudent.getPatronymic() +
                ",team_id =" + updateStudent.getTeamId() + "\n" +
                "where first_name =" + student.getFirstName() +
                " and secoundName = " + student.getSecoundName() +
                " and patronymic =" + student.getPatronymic() +
                " and team_id =" + student.getTeamId() + ";";
        try (Connection connection = DriverManager.getConnection(URL, PropsReader.read())) {
            PreparedStatement statement = connection.prepareStatement(updateQuery);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Student student) {
        String deleteQuery = "DELETE FROM student where first_name =" + student.getFirstName() +
                " and secoundName = " + student.getSecoundName() +
                " and patronymic =" + student.getPatronymic() +
                " and team_id =" + student.getTeamId() + ";";
        try (Connection connection = DriverManager.getConnection(URL, PropsReader.read())) {
            PreparedStatement statement = connection.prepareStatement(deleteQuery);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
