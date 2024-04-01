package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Prr10_OracleToMySQL
{
	public static void main(String[] args) throws Exception
	{
		int count = 0;
		Connection con1 = DriverManager.getConnection("jdbc:oracle:thin:@IN2-NOINB-ABBI.in2ittech.local:1521:orcl","scott","tiger");
		Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/abhishekdb","root","root");
		Statement st1 = con1.createStatement();
		Statement st2 = con2.createStatement();
		String sqlQuery1 = "select * from employees";
		ResultSet rs = st1.executeQuery(sqlQuery1);
		
		while (rs.next())
		{
			count++;
			int eno=rs.getInt(1);
			String ename=rs.getString(2);
			double esal=rs.getDouble(3);
			String eaddr=rs.getString(4);
			String sqlQuery2 = String.format("insert into employees values(%d,'%s',%f,'%s')", eno,ename,esal,eaddr);
			st2.executeUpdate(sqlQuery2);
		}
		
		System.out.println("Total Data copied from Oracle to MySQL and number of records:"+count);
		con1.close();
		con2.close();
	}
}
