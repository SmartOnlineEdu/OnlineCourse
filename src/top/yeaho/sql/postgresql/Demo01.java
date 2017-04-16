package top.yeaho.sql.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo01 {
	public static void main(String args[]) {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			//c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "postgres", "root");
			c = DriverManager.getConnection("jdbc:postgresql://114.115.203.28:5432/best", "postgres", "postgresADMIN");
			c.setAutoCommit(false); // ���Զ��ύ
			System.out.println("Զ�����ݿ����ӳɹ���Opened database successfully");

			stmt = c.createStatement(); 
	        /*String sql = "CREATE TABLE STUDENTS " + 
	                     "(ID TEXT PRIMARY KEY     NOT NULL ," + 
	                     " NAME            TEXT    NOT NULL, " + 
	                     " SEX             TEXT    NOT NULL, " + 
	                     " AGE             TEXT    NOT NULL)"; */
			String createTable = "CREATE TABLE information "+ 
                    "(id SERIAL PRIMARY KEY NOT NULL ," + 
                    " info JSONB NOT NULL)" ;
			System.out.println(createTable);
			//String sql = "INSERT INTO information (info) VALUES ( '{\"age\":20,\"name\":\"jeff\"}')";
			String sql = "INSERT INTO information (info) VALUES ( '{\"age\":19,\"name\":\"apple\"}')";
	        //stmt.executeUpdate(createTable);
	        //System.out.println("�������ݿ�ɹ���successfully");
			//stmt.executeUpdate(sql); 
	        System.out.println("�����¼�ɹ���successfully");
	        ResultSet rSet = stmt.executeQuery("select '[{\"a\":\"foo\"},{\"b\":\"bar\"},{\"c\":\"baz\"}]'::json->2");
	        if(rSet.next()){
	        	System.out.println("has next!");
	        	System.out.println(rSet.getString(1));
	        	
	        }
			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}
}