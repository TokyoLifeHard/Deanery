import com.fasterxml.jackson.core.JsonProcessingException;

import dao.impl.TeamDAO;

import entity.Team;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException, JsonProcessingException {

        Team team = new Team(0,"GG-43","4");
        TeamDAO teamDAO = new TeamDAO();
        //System.out.println(teamDAO.getAll().toString());
        teamDAO.save(team);
    }
}
