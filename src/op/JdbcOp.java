package op;

import java.sql.*;

public class JdbcOp {

    private Connection conn = null;
    private Statement statement = null;
    // JDBC 驱动名及数据库 URL
    private final String driver="com.mysql.cj.jdbc.Driver";
    private final String jdbcUrl="jdbc:mysql://localhost:3306/";
    private final String UrlParam = "?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    // 数据库的用户名与密码，需要根据自己的设置
    private final String userName="root";
    private final String userPwd="19988824";
    public void open(String Url) {
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(jdbcUrl+Url+UrlParam, userName, userPwd);
            statement = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int executeUpdate(String sql) {
        try {
            return statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public ResultSet executeQuery(String sql) {
        try {
            return statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void close() {
        try {
            conn.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
