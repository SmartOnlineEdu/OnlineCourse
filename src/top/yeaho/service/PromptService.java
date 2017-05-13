package top.yeaho.service;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.yeaho.sql.postgresql.PostgresqlConfig;
import top.yeaho.sql.postgresql.PostgresqlDBConn;

public class PromptService{
	
	public static int promptS = 0;
	private String prompt[][];
	private Statement statement = null;
	private ResultSet resultSet = null;
	PostgresqlDBConn pd = new PostgresqlDBConn();

	public void serviceForPrompt(HttpServletRequest request ,HttpServletResponse response)
			throws IOException , ServletException {

		try {
		
			statement = pd.getConntion().createStatement();
			//System.out.println(statement);
			String sqlPrompt = "select * from best";
			resultSet = statement.executeQuery(sqlPrompt);
			
			int promptNum = 0;
			PrintWriter outp = response.getWriter();
			//取出提示信息的个数
			while (resultSet.next()) {
				promptNum++;
			}
			resultSet = statement.executeQuery(sqlPrompt);
			prompt = new String[promptNum][2];
			
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String promptValue = resultSet.getString(2);
				String secValue = Integer.toString(resultSet.getInt(3));
				prompt[id - 1][0] = secValue;
				prompt[id - 1][1] = promptValue;
			}

			//输出节点的内容
			
			outp.print("<div id='promptValue'>");
			for (int i = 0; i < promptNum; i++) {
				outp.print(prompt[i][0] + ","+prompt[i][1]+"|");
			}
			outp.print("</div>");
			for (int i = 0; i < promptNum; i++) {
				System.out.print(prompt[i][0] + ","+prompt[i][1]+"|");
			}

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
					pd.getConntion().close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		}
	}
}