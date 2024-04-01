package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Prr03_InsertMultipleRowsDemo
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
		while (true)
		{
			System.out.println("Enter Employee Number:");
			int eno = sc.nextInt();
			System.out.println("Enter Employee Name:");
			String ename = sc.next();
			System.out.println("Enter Employee Salary:");
			double esal = sc.nextDouble();
			System.out.println("Enter Employee Address:");
			String eaddr = sc.next();
			String sqlQuery = String.format("insert into employees values(%d,'%s',%f,'%s')", eno, ename, esal, eaddr);
			st.executeUpdate(sqlQuery);
			System.out.println("Record Inserted Successfully");
			System.out.println("Do you want to Insert one more record [Yes/No]:");
			String option = sc.next();
			if (option.equalsIgnoreCase("No"))
			{
				break;
			}
		}
		con.close();
	}

}
