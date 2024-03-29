//package dao;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import student.Student;
//import util.JdbcOp;
//
//public class StudentDao {
//    //添加
//    public boolean add(Student course) {
//        String sql = "insert into home(name,money,date) values('" + course.getName() + "','" + course.getMoney() + "','" + course.getDate() + "')";
//
//        JdbcOp jdbc = new JdbcOp();
//        jdbc.open("DB_database17");
//        boolean f = false;
//        int a = jdbc.executeUpdate(sql);
//        jdbc.close();
//        if (a != -1) {
//            f = true;
//        }
//        return f;
//    }
//
//
//    //删除
//    public boolean delete(int id) {
//        String sql = "delete from home where id='" + id + "'";
//        JdbcOp jdbc = new JdbcOp();
//        jdbc.open("DB_database17");
//        boolean f = false;
//        int a = jdbc.executeUpdate(sql);
//        jdbc.close();
//        if (a != -1) {
//            f = true;
//        }
//        return f;
//    }
//
//    //修改
//    public boolean update(Student course) {
//        String sql = "update home set name='" + course.getName() + "', money='" + course.getMoney() + "', date='" + course.getDate()
//                + "' where id='" + course.getId() + "'";
//        JdbcOp jdbc = new JdbcOp();
//        jdbc.open("DB_database17");
//        boolean f = false;
//        int a = jdbc.executeUpdate(sql);
//        jdbc.close();
//        if (a != -1) {
//            f = true;
//        }
//        return f;
//    }
//
//    //查找
//    public List<Student> search(String date, String name) {
//        String sql = "select * from home where ";
//        if (date != "") {
//            sql += "date like '%" + date + "%'";
//        }
//        if (name != "") {
//            if (date != "")
//                sql += " and name like '%" + name + "%'";
//            else
//                sql += "name like '%" + name + "%'";
//        }
//        List<Student> list = new ArrayList<>();
//        JdbcOp jdbc = new JdbcOp();
//        jdbc.open("DB_database17");
//        ResultSet rs = jdbc.executeQuery(sql);
//
//        try {
//            Student bean = null;
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String name1 = rs.getString("name");
//                String money = rs.getString("money");
//                String date1 = rs.getString("date");
//                bean = new Student(id, name1, money, date1);
//                list.add(bean);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//
//    //通过id找到某条信息
//    public Student getCourseById(int id) {
//        String sql = "select * from home where id ='" + id + "'";
//        JdbcOp jdbc = new JdbcOp();
//        jdbc.open("DB_database17");
//        ResultSet rs = jdbc.executeQuery(sql);
//        Student stu = null;
//        try {
//
//            while (rs.next()) {
//                String name = rs.getString("name");
//                String money = rs.getString("money");
//                String date = rs.getString("date");
//                stu = new Student(id, name, money, date);
//            }
//            jdbc.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return stu;
//    }
//
//    //全部数据
//    public List<Student> list() {
//        String sql = "select * from home";
//        List<Student> list = new ArrayList<>();
//        JdbcOp jdbc = new JdbcOp();
//        jdbc.open("DB_database17");
//        ResultSet rs = jdbc.executeQuery(sql);
//
//        try {
//            Student bean = null;
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                String money = rs.getString("money");
//                String date = rs.getString("date");
//                bean = new Student(id, name, money, date);
//                list.add(bean);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//}