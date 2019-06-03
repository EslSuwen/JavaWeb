package database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

@WebServlet(name = "DB2Servlet", value = "/db2")
public class DB2Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            JdbcOp jdbc = new JdbcOp();
            jdbc.open("usersdb");
            ResultSet rs = jdbc.executeQuery("select * from users");

            while (rs.next()) {
                PrintWriter out = response.getWriter();
                String name = rs.getString("name");
                String password = rs.getString("password");
                System.out.println("username: " + name + " password: " + password);
                out.println("username: " + name + " password: " + password);
            }
            jdbc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
