package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Prr01_JdbcDemo {

	public static void main(String[] args) throws Exception
	{
		Class.forName("oracle.jdbc.OdbcDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@IN2-NOINB-ABBI.in2ittech.local:1521:orcl","scott","tiger");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from emp");
		while (rs.next())
		{
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
		}
		con.close();
		
	}

}
