package database;

import java.sql.ResultSet;

public class JdbcClient {
    public static void main(String[] args) {
        try {
            JdbcOp jdbc = new JdbcOp();
            jdbc.open("usersdb");
            ResultSet rs = jdbc.executeQuery("select * from users");

            while (rs.next()) {
                String name = rs.getString("name");
                String password=rs.getString("password");
                System.out.println("username: "+name+" password: "+password);

            }
            jdbc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
