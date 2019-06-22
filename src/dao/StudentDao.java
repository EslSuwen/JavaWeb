package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import student.Student;
import util.DBUtil;

public class StudentDao {
    //添加
    public boolean add(Student course) {
        String sql = "insert into home(name,money,date) values('"+ course.getName() + "','" + course.getMoney()+"','" + course.getDate() +  "')";
        Connection conn = DBUtil.getConn();
        Statement state = null;
        boolean f = false;
        int a = 0;

        try {
            state = conn.createStatement();
            a=state.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(state, conn);
        }

        if (a > 0) {
            f = true;
        }
        return f;
    }


    //删除
    public boolean delete (int id) {
        boolean f = false;
        String sql = "delete from home where id='" + id + "'";
        Connection conn = DBUtil.getConn();
        Statement state = null;
        int a = 0;

        try {
            state = conn.createStatement();
            a = state.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(state, conn);
        }

        if (a > 0) {
            f = true;
        }
        return f;
    }

    //修改
    public boolean update(Student course) {
        String sql = "update home set name='" + course.getName() + "', money='" + course.getMoney()+"', date='" + course.getDate()
                + "' where id='" + course.getId() + "'";
        Connection conn = DBUtil.getConn();
        Statement state = null;
        boolean f = false;
        int a = 0;

        try {
            state = conn.createStatement();
            a = state.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(state, conn);
        }

        if (a > 0) {
            f = true;
        }
        return f;
    }

    //查找
    public List<Student> search(String date, String name) {
        String sql = "select * from home where ";
        if (date != "") {
            sql += "date like '%" + date + "%'";
        }
        if (name != "") {
            sql += "name like '%" + name + "%'";
        }
        List<Student> list = new ArrayList<>();
        Connection conn = DBUtil.getConn();
        Statement state = null;
        ResultSet rs = null;

        try {
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            Student bean = null;
            while (rs.next()) {
                int id = rs.getInt("id");
                String name1 = rs.getString("name");
                String money = rs.getString("money");
                String date1 = rs.getString("date");
                bean = new Student(id,name1,money,date1);
                list.add(bean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, state, conn);
        }

        return list;
    }

    //通过id找到某条信息
    public Student getCourseById(int id) {
        String sql = "select * from home where id ='" + id + "'";
        Connection conn = DBUtil.getConn();
        Statement state = null;
        ResultSet rs = null;
        Student stu = null;

        try {
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString("name");
                String money = rs.getString("money");
                String date = rs.getString("date");
                stu = new Student(id,name,money,date);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, state, conn);
        }

        return stu;
    }

    //全部数据
    public List<Student> list() {
        String sql = "select * from home";
        List<Student> list = new ArrayList<>();
        Connection conn = DBUtil.getConn();
        Statement state = null;
        ResultSet rs = null;

        try {
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            Student bean = null;
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String money = rs.getString("money");
                String date = rs.getString("date");
                bean = new Student(id,name,money,date);
                list.add(bean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs, state, conn);
        }

        return list;
    }


}