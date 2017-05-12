package top.yeaho.sql.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class PostgresqlDBConn {

	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	public String prompt[][];
	public Connection getConntion(){
		try {
			Class.forName(PostgresqlConfig.CLASS_NAME);
			String postgresqlUrl = PostgresqlConfig.DATABASE_URL +"/"+ PostgresqlConfig.DATABASE_PROMPT;
			connection = DriverManager.getConnection(postgresqlUrl, PostgresqlConfig.DATABASE_USER, PostgresqlConfig.DATABASE_PASSWORD);
			String sql = "select * from best";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			//取出提示信息的个数
			int promptNum = 0;
			while (resultSet.next()) {
				promptNum++;
			}
			resultSet = statement.executeQuery(sql);
			prompt = new String[promptNum][2];
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String promptValue = resultSet.getString(2);
				String secValue = Integer.toString(resultSet.getInt(3));
				prompt[id - 1][0] = secValue;
				prompt[id - 1][1] = promptValue;
			}
			
			//输出节点的时间

			for (int i = 0; i < promptNum; i++) {
				System.out.print(prompt[i][0] + ","+prompt[i][1]+"|");
			}
			//输出节点的内容
//			System.out.println();
//			for (int i = 0; i < promptNum; i++) {
//				System.out.print(prompt[i][1] + ",");
//			}	
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		}
		return connection;
	}
}