package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Prr22_DateInsertDemo
{
	public static void main(String[] args) throws Exception
	{
		String driver = "oracle.jdbc.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@IN2-NOINB-ABBI.in2ittech.local:1521:orcl";
		String user = "scott";
		String pwd = "tiger";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(jdbc_url,user,pwd);
		PreparedStatement pst = con.prepareStatement("insert into usersdate values(?,?)");
		Scanner sc = new Scanner(System.in);
		while (true)
		{
			System.out.println("Enter Person Name:");
			String uname = sc.next();
			System.out.println("Enter DOP(dd-mm-yyyy):");
			String dop = sc.next();
			
			// Convert String Form to Util Form
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			java.util.Date uDate = sdf.parse(dop);
			// Convert Util form to SQL form
			long l = uDate.getTime();
			java.sql.Date sDate = new java.sql.Date(l);
			
			pst.setString(1, uname);
			pst.setDate(2, sDate);
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
