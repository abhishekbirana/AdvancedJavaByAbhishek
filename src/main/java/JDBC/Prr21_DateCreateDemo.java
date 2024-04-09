package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Prr21_DateCreateDemo
{
	public static void main(String[] args) throws Exception
	{
		String driver = "oracle.jdbc.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@IN2-NOINB-ABBI.in2ittech.local:1521:orcl";
		String user = "scott";
		String pwd = "tiger";
		String sql_query = "create table usersdate(name varchar2(10), dop date)";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(jdbc_url,user,pwd);
		Statement st = con.createStatement();
		st.executeUpdate(sql_query);
		
		System.out.println("Table Created Succesfully");
		con.close();

	}

}
