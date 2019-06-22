package login;

import util.JdbcOp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 一般都会在doGet()方法中调用doPost()方法，或者在doPost()方法中调用doGet()方法
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 设置编码格式，可以防止乱码出现
        response.setContentType("text/html; charset=utf-8");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        // 获取用户提交过来的用户名和密码，是通过表单中input的name属性获取的
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String isSignUp = request.getParameter("isSignUp");
        PrintWriter out = response.getWriter();
        System.out.println(username + ": " + password + " isSignUp: " + isSignUp);
        // 获取输出流，用户显示信息，也可以用转发或者重定向
        PrintWriter pw = response.getWriter();


        //注册验证
        if ("注册".equals(isSignUp)) {
            try {
                JdbcOp jdbc = new JdbcOp();
                jdbc.open("usersdb");
                ResultSet rs = jdbc.executeQuery("select * from users");

                while (rs.next()) {
                    String nm = rs.getString("name");
                    String pd = rs.getString("password");
                    System.out.println("username: " + nm + " password: " + pd);

                    if (nm.equals(username)) {
                        out.print("<script language='javascript'>alert('该账户已存在！请重新注册！');window.location.href='test.jsp';</script>");
                        out.flush();
                        out.close();
                    }
                }
                //进行注册操作
                int i = jdbc.executeUpdate("insert into users values('" + username + "','" + password + "')");
                System.out.println(i);
                if (i == 0) {
                    out.print("<script language='javascript'>alert('账户创建失败！请重新注册！');window.location.href='index.jsp';</script>");
                    out.flush();
                    out.close();
                } else {
                    out.print("<script language='javascript'>alert('该账号已成功注册！请牢记密码！');window.location.href='test.jsp';</script>");
                    out.flush();
                    out.close();
                }
                jdbc.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            //登录验证
            try {
                JdbcOp jdbc = new JdbcOp();
                jdbc.open("usersdb");
                ResultSet rs = jdbc.executeQuery("select * from users");

                while (rs.next()) {
                    String nm = rs.getString("name");
                    String pd = rs.getString("password");
                    System.out.println("username: " + nm + " password: " + pd);

                    if (nm.equals(username) && pd.equals(password)) {
                        HttpSession session = request.getSession();
                        //将数据存储到session中
                        session.setAttribute("isLogin", "true");
                        session.setAttribute("username", username);

                        out.print("<script language='javascript'>alert('You login successful  ! 你已成功登录！out.print');window.location.href='test.jsp';</script>");
                        out.flush();
                        out.close();
                    }
                }
                jdbc.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            pw.write("login fail");
            out.print("<script language='javascript'>alert('please login first 登陆信息输入有误！');window.location.href='index.jsp';</script>");
            out.flush();
            out.close();
        }

    }
}