package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "GetCookies",value = "/GetCookies")
public class GetCookies extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.getWriter().append("Served at: ").append(request.getContextPath());
            Cookie[] cookies = request.getCookies();
            for (Cookie c : cookies) {
                //if (c.getName().equals("username"))
                    System.out.println(c.getValue());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
