package top.yeaho.service;

import top.yeaho.sql.postgresql.PostgresqlDBConn;

public class ConnectionSer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PostgresqlDBConn pd = new PostgresqlDBConn();
		pd.getConntion();
	}

}
