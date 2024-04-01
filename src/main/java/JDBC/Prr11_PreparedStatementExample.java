package JDBC;

// Prepared Statement --> precompiled query only once
// pst.executeQuery(); may executed many times

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Prr11_PreparedStatementExample {

	public static void main(String[] args) throws Exception
	{
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@IN2-NOINB-ABBI.in2ittech.local:1521:orcl","scott","tiger");
		String sqlQuery = "insert into employees values(?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(sqlQuery);
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			System.out.println("Enter Employee Number:");
			int eno = sc.nextInt();
			System.out.println("Enter Employee Name:");
			String ename = sc.next();
			System.out.println("Enter Employee Salary:");
			double esal = sc.nextDouble();
			System.out.println("Enter Employee Address:");
			String eaddr = sc.next();
			pst.setInt(1, eno);
			pst.setString(2, ename);
			pst.setDouble(3, esal);
			pst.setString(4, eaddr);
			pst.executeUpdate();
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
