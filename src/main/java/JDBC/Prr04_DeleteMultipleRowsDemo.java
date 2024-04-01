package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Prr04_DeleteMultipleRowsDemo
{

	public static void main(String[] args) throws Exception
	{
		String driver = "oracle.jdbc.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@IN2-NOINB-ABBI.in2ittech.local:1521:orcl";
		String user = "scott";
		String pwd = "tiger";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(jdbc_url,user,pwd);
		Statement st = con.createStatement();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter CutOff Salary:");
		double cutOff = sc.nextDouble();
		String sqlQuery = String.format("delete from employees1 where esal>=%f", cutOff);
		int updateCount = st.executeUpdate(sqlQuery);
		System.out.println("The number of rows deleted : "+updateCount);
		con.close();

	}

}
