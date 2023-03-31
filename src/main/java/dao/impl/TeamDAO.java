package dao.impl;

import dao.DAO;
import entity.Team;
import utils.PropsReader;

import java.sql.*;
import java.util.*;

public class TeamDAO extends DAO<Team> {
    private final String URL = "jdbc:postgresql://localhost/denanery";


    @Override
    public Optional<Team> get(long id) {
        Team team = new Team();

        try (Connection connection = DriverManager.getConnection(URL, PropsReader.read())){
            PreparedStatement statement = connection.prepareStatement("select * from team where id = "+id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            team.setId(resultSet.getInt(1));
            team.setName(resultSet.getString(2));
            team.setCourseName(resultSet.getString(3));
            resultSet.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return Optional.of(team);
    }

    @Override
    public List<Team> getAll() {
        ArrayList<Team> teams = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, PropsReader.read())){
            PreparedStatement statement = connection.prepareStatement("select * from team");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Team team = new Team();
                team.setId(resultSet.getInt(1));
                team.setName(resultSet.getString(2));
                team.setCourseName(resultSet.getString(3));
                teams.add(team);
            }
            resultSet.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return teams;
    }

    @Override
    public void save(Team team) {
        String insertQuery = "INSERT INTO team (name,course_name) VALUES('"+team.getName()+"','"+team.getCourseName()+"')";
        try (Connection connection = DriverManager.getConnection(URL, PropsReader.read())){
            PreparedStatement statement = connection.prepareStatement(insertQuery);
            statement.executeUpdate();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Team team, Team updateTeam) {
        String updateQuery = "UPDATE team SET name = "+updateTeam.getName()+","+"course_name = "+ updateTeam.getCourseName()+"" +
                "where name = "+team.getName()+"and course_name ="+team.getCourseName()+";";
        try (Connection connection = DriverManager.getConnection(URL, PropsReader.read())){
            PreparedStatement statement = connection.prepareStatement(updateQuery);
            statement.executeUpdate();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Team team) {
        String deleteQuery = "DELETE FROM team where name = "+team.getName()+"and course_name ="+team.getCourseName()+";";
        try (Connection connection = DriverManager.getConnection(URL, PropsReader.read())){
            PreparedStatement statement = connection.prepareStatement(deleteQuery);
            statement.executeUpdate();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
