package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Prr05_AggregateFunctions {

	public static void main(String[] args) throws Exception {
		String driver = "oracle.jdbc.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@IN2-NOINB-ABBI.in2ittech.local:1521:orcl";
		String user = "scott";
		String pwd = "tiger";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(jdbc_url,user,pwd);
		Statement st = con.createStatement();
//		String sqlQuery = "select count(*) from employees";
//		String sqlQuery = "select max(esal) from employees";
		String sqlQuery = "select min(esal) from employees";
		ResultSet rs = st.executeQuery(sqlQuery);
		if (rs.next())
		{
//			System.out.println("The no of Employees : "+rs.getInt(1));
//			System.out.println("The maximum salary : "+rs.getDouble(1));
			System.out.println("The minimum salary : "+rs.getDouble(1));
		}
		con.close();

	}

}
