package database;

import util.JdbcOp;

import java.sql.ResultSet;

public class JdbcTest {
    public static void main(String[] args) {
        try {
            JdbcOp jdbc = new JdbcOp();
            // JDBC 驱动名及数据库 URL
            // 数据库的用户名与密码，需要根据自己的设置
            jdbc.open("usersdb");
            // 执行查询
            ResultSet rs = jdbc.executeQuery("SELECT id, name, url FROM websites");
            // 展开结果集数据库
            while (rs.next()) {
                // 通过字段检索
                int id  = rs.getInt("id");
                String name = rs.getString("name");
                String url = rs.getString("url");
                // 输出数据
                System.out.print("ID: " + id);
                System.out.print(", 站点名称: " + name);
                System.out.print(", 站点 URL: " + url);
                System.out.print("\n");
            }
            // 完成后关闭
            jdbc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}