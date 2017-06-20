package top.yeaho.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Map.Entry;

public class DBOper {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    /**
     * 得到数据库连接
     */
    public Connection getConn(String server, String dbname, String user,
                              String pwd) throws ClassNotFoundException, SQLException,
            InstantiationException, IllegalAccessException {
        String DRIVER = "com.mysql.jdbc.Driver";
        String URL = "jdbc:mysql://" + server + ":3306/" + dbname + "?user="
                + user + "&password=" + pwd+"&useUnicode=true&characterEncoding=utf8";
        Class.forName(DRIVER).newInstance();
        conn = DriverManager.getConnection(URL);
        return conn;
    }

    /**
     * 
     * @return 返回数据库的链接，开发时修改数据库的链接属性
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public Connection getConnPas() throws ClassNotFoundException, SQLException,
            InstantiationException, IllegalAccessException {
        String server = "114.115.203.28";
        String user = "postgres";
        String pwd = "postgresADMIN";
        String dbname = "windward";
        String DRIVER = "org.postgresql.Driver";
        String URL = "jdbc:postgresql://" + server + ":5432/" + dbname + "?user="
                + user + "&password=" + pwd+"&useUnicode=true&characterEncoding=utf8";
        Class.forName(DRIVER).newInstance();
        conn = DriverManager.getConnection(URL);
        return conn;
    }

    /**
     * 释放资源
     */
    public void closeAll() {
        // 如果rs不空，关闭rs
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //如果pstmt不空，关闭pstmt
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //如果conn不空，关闭conn
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 执行SQL语句，可以进行查询
     */
    public ResultSet executeQuery(String preparedSql, String[] param) {
        //处理SQL,执行SQL
        try {
            // 得到PreparedStatement对象
            pstmt = conn.prepareStatement(preparedSql);
            if (param != null) {
                for (int i = 0; i < param.length; i++) {
                    // 为预编译sql设置参数
                    pstmt.setString(i + 1, param[i]);
                }
            }
            // 执行SQL语句
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            // 处理SQLException异常
            e.printStackTrace();
        }
        return rs;
    }

    /**
     * 执行SQL语句，可以进行增、删、改的操作，不能执行查询
     */
    public int executeUpdate(String preparedSql, String[] param) {

        int num = 0;

        //处理SQL,执行SQL
        try {
            // 得到PreparedStatement对象
            pstmt = conn.prepareStatement(preparedSql);
            if (param != null) {
                for (int i = 0; i < param.length; i++) {
                    // 为预编译sql设置参数
                    pstmt.setString(i + 1, param[i]);
                }
            }
            // 执行SQL语句
            //System.out.print(preparedSql);
            num = pstmt.executeUpdate();
        } catch (SQLException e) {
            // 处理SQLException异常
            e.printStackTrace();
        }
        return num;
    }
}