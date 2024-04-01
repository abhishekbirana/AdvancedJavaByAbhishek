package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

// Execute method Loop : executeUpdate() Vs DDL

public class Prr08_ExecuteMethodLoopHoles {

	public static void main(String[] args) throws Exception
	{
		String jdbc_url = "jdbc:oracle:thin:@IN2-NOINB-ABBI.in2ittech.local:1521:orcl";
		String user = "scott";
		String pwd = "tiger";
		Connection con = DriverManager.getConnection(jdbc_url,user,pwd);
		Statement st = con.createStatement();
		int updateCount = st.executeUpdate("create table emp1(eno number)");
		System.out.println(updateCount);
		con.close();

	}

}
