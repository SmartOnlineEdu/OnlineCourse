package top.yeaho.sql.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresqlDBConn {
	private Connection connection = null;
	//∑µªÿ¡¨Ω”
	public Connection getConntion(){
		try {
			Class.forName(PostgresqlConfig.CLASS_NAME);
			String postgresqlUrl = PostgresqlConfig.DATABASE_URL +"/"+ PostgresqlConfig.DATABASE_PROMPT;
			connection = DriverManager.getConnection(postgresqlUrl, PostgresqlConfig.DATABASE_USER, PostgresqlConfig.DATABASE_PASSWORD);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return connection;
	}
}