package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "Cookies",value = "/Cookies")
public class Cookies extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       Cookie cookie1=new Cookie("usename1","valuename1");
       Cookie cookie2=new Cookie("usename2","valuename2");
        response.getWriter().append("Served at: ").append(request.getContextPath());
        response.addCookie(cookie1);
        response.addCookie(cookie2);
    }
}
