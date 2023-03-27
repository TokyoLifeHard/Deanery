import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Direction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws SQLException, JsonProcessingException {
//        String url = "jdbc:postgresql://localhost/denanery";
//        Properties props = new Properties();
//        props.setProperty("user", "postgres");
//        props.setProperty("password", "");
//        props.setProperty("ssl", "false");
//        Connection conn = DriverManager.getConnection(url, props);
//
//        System.out.println(conn.getSchema());
//        String insertQuery = "INSERT INTO direction" +
//                "  (departmen,specialization) VALUES " +
//                " (?, ?);";
//        PreparedStatement prepareStatement = conn.prepareStatement(insertQuery);
//        prepareStatement.setString(1,"IT");
//        prepareStatement.setString(2,"Programming");
//        prepareStatement.executeUpdate();
//        conn.close();
        Direction direction = new Direction();
        direction.setId(1);
        direction.setDepartmen("test");
        direction.setSpecialization("test");
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(direction);
        System.out.println(s);
    }
}
