package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import student.Student;
import java.io.PrintWriter;

/**
 * Servlet implementation class ShangServlet
 */
@WebServlet("/ShangServlet")
public class StudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    StudentDao dao = new StudentDao();

    //复写service方法，实现一个Servlet处理多个请求
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String method = req.getParameter("method");
        if ("add".equals(method)) {
            add(req, resp);
        } else if ("del".equals(method)) {
            del(req, resp);
        } else if ("update".equals(method)) {
            update(req, resp);
        } else if ("search".equals(method)) {
            search(req, resp);
        } else if ("getcoursebyid".equals(method)) {
            getCourseById(req, resp);
        } else if ("list".equals(method)) {
            list(req, resp);
        }else if ("show".equals(method)) {
            show(req, resp);
        }else if ("delete".equals(method)) {
            delete(req, resp);
        }
    }

    //添加
    private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String money = req.getParameter("money");
        String date = req.getParameter("date");
        Student course = new Student(name,money,date);
        //添加后消息显示
        if(dao.add(course)) {
            req.setAttribute("message", "添加成功");
            req.getRequestDispatcher("add.jsp").forward(req,resp);
        } else {
            req.setAttribute("message", "添加失败");
            req.getRequestDispatcher("add.jsp").forward(req,resp);
        }
    }


    //显示全部信息
    private void show(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        req.setCharacterEncoding("utf-8");
        List<Student> courses = dao.list();
        req.setAttribute("courses", courses);
        req.getRequestDispatcher("show.jsp").forward(req,resp);
    }

    //显示全部信息+删除（jsp)
    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        req.setCharacterEncoding("utf-8");
        List<Student> courses = dao.list();
        req.setAttribute("courses", courses);
        req.getRequestDispatcher("del.jsp").forward(req,resp);
    }
    //显示全部信息+修改（jsp)
    private void list(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        req.setCharacterEncoding("utf-8");
        List<Student> courses = dao.list();
        req.setAttribute("courses", courses);
        req.getRequestDispatcher("list.jsp").forward(req,resp);
    }

    //通过id得到某条具体信息
    private void getCourseById(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        req.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(req.getParameter("id"));
        Student stu = dao.getCourseById(id);
        req.setAttribute("stu", stu);
        req.getRequestDispatcher("detail2.jsp").forward(req,resp);
    }

    //删除
    private void del(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        req.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(req.getParameter("id"));
        if(dao.delete(id)) {
            req.setAttribute("message", "删除成功！");
            resp.sendRedirect("/ServletDemo/ShangServlet?method=delete");
        }
    }

    //修改
    private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        req.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String money = req.getParameter("money");
        String date = req.getParameter("date");
        Student stu = new Student(id,name,money,date);

        if(dao.update(stu)){
            req.setAttribute("message", "修改成功");
            resp.sendRedirect("/ServletDemo/ShangServlet?method=list");
        }
        else{
            req.setAttribute("message", "修改失败");
            resp.sendRedirect("/ServletDemo/ShangServlet?method=list");
        }
    }

    //查找
    private void search(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String date = req.getParameter("date");
        List<Student> courses = dao.search(date,name);
        req.setAttribute("courses", courses);
        req.getRequestDispatcher("searchlist.jsp").forward(req,resp);
    }

}