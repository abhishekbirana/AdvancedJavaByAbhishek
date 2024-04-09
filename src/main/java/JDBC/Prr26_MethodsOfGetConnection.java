package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Prr26_MethodsOfGetConnection
{
	public static void main(String[] args) throws Exception {
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:scott/tiger@IN2-NOINB-ABBI.in2ittech.local:1521:orcl"); // For Oracle DB
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/abhishekdb?user=root&password=root"); // For MySQL DB
		Statement st = con.createStatement();
		String sqlQuery = "select * from employees";
		ResultSet rs = st.executeQuery(sqlQuery);
		boolean flag = false;
		System.out.println("ENO\tENAME\tESAL\tEADDR");
		System.out.println("=====================================");
		while (rs.next())
		{
			flag = true;
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3)+"\t"+rs.getString(4));
		}
		if (flag==false)
		{
			System.out.println("No Matched Records Found");
		}
		
		con.close();
	}

}
