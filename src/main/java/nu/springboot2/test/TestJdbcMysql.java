package nu.springboot2.test;

import java.sql.*;

/**
 * @Program: spring-boot2-mybatis
 * @Author: 努力就是魅力
 * @Since: 2018-10-10 20:27
 * Description:
 * <p>
 * 测试mysql数据库连接是否正常
 **/


public class TestJdbcMysql {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "123456");
            String sql = "select * from t_city";
            rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
