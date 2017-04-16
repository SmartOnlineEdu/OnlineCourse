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
     * �õ����ݿ�����
     */



    public Connection getConn(String server, String dbname, String user,
                              String pwd) throws ClassNotFoundException, SQLException,
            InstantiationException, IllegalAccessException {
        String DRIVER = "com.mysql.jdbc.Driver";
        String URL = "jdbc:mysql://" + server + ":3306/" + dbname + "?user="
                + user + "&password=" + pwd+"&useUnicode=true&characterEncoding=utf8";
        Class.forName(DRIVER).newInstance();
        conn = DriverManager.getConnection(URL);
        //System.out.print("���ӳɹ�");
        return conn;
    }

    public Connection getConnPas() throws ClassNotFoundException, SQLException,
            InstantiationException, IllegalAccessException {
        String server = "localhost";
    	//String server = "[2001::1]";
        String dbname = "smartcourse";
        String user = "root";
        String pwd = "JeffGAOfeng0532!@";
        String DRIVER = "com.mysql.jdbc.Driver";
        String URL = "jdbc:mysql://" + server + ":3306/" + dbname + "?user="
                + user + "&password=" + pwd+"&useUnicode=true&characterEncoding=utf8";
        Class.forName(DRIVER).newInstance();
        conn = DriverManager.getConnection(URL);
        return conn;
    }

    /**
     * �ͷ���Դ
     */
    public void closeAll() {
        // ���rs���գ��ر�rs
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //���pstmt���գ��ر�pstmt
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //���conn���գ��ر�conn
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * ִ��SQL��䣬���Խ��в�ѯ
     */
    public ResultSet executeQuery(String preparedSql, String[] param) {
        //����SQL,ִ��SQL
        try {
            // �õ�PreparedStatement����
            pstmt = conn.prepareStatement(preparedSql);
            if (param != null) {
                for (int i = 0; i < param.length; i++) {
                    // ΪԤ����sql���ò���
                    pstmt.setString(i + 1, param[i]);
                }
            }
            // ִ��SQL���
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            // ����SQLException�쳣
            e.printStackTrace();
        }
        return rs;
    }

    /**
     * ִ��SQL��䣬���Խ�������ɾ���ĵĲ���������ִ�в�ѯ
     */
    public int executeUpdate(String preparedSql, String[] param) {

        int num = 0;

        //����SQL,ִ��SQL
        try {
            // �õ�PreparedStatement����
            pstmt = conn.prepareStatement(preparedSql);
            if (param != null) {
                for (int i = 0; i < param.length; i++) {
                    // ΪԤ����sql���ò���
                    pstmt.setString(i + 1, param[i]);
                }
            }
            // ִ��SQL���
            //System.out.print(preparedSql);
            num = pstmt.executeUpdate();
        } catch (SQLException e) {
            // ����SQLException�쳣
            e.printStackTrace();
        }
        return num;
    }
    public static void main(String[] args) {
        Properties p = System.getProperties();
        for(Entry<Object, Object> e:p.entrySet()){
            System.out.println(e.getKey()+"= "+e.getValue());
        }
    }
}