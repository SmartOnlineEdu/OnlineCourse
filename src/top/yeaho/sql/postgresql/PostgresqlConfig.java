package top.yeaho.sql.postgresql;

import java.io.IOException;
import java.util.Properties;

public class PostgresqlConfig {
	private static Properties prop = new Properties();	
	static{		
		try {
			//加载dbconfig.properties配置文件
			prop.load(PostgresqlConfig.class.getResourceAsStream("progresqlConfig.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//设置常量
	public static final String CLASS_NAME = prop.getProperty("CLASS_NAME");
	public static final String DATABASE_URL = prop.getProperty("DATABASE_URL");
	public static final String DATABASE_USER = prop.getProperty("DATABASE_USER");
	public static final String DATABASE_PASSWORD = prop.getProperty("DATABASE_PASSWORD");
	public static final String DATABASE_PROMPT = prop.getProperty("DATABASE_PROMPT");
	
}
