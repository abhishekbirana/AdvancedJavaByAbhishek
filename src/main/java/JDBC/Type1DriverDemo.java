package JDBC;

import java.sql.*;

public class Type1DriverDemo {

	public static void main(String[] args) throws Exception
	{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con = DriverManager.getConnection("jdbc:odbc://IN2-NOINB-ABBI.in2ittech.local:1158/em","scott","tiger");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from movies");
		while (rs.next())
		{
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
		}
		con.close();

	}

}
