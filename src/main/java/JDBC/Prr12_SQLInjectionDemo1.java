package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Prr12_SQLInjectionDemo1 {

	public static void main(String[] args) throws Exception
	{
		String jdbc_url = "jdbc:oracle:thin:@IN2-NOINB-ABBI.in2ittech.local:1521:orcl";
		String user = "scott";
		String pwd = "tiger";
		Connection con = DriverManager.getConnection(jdbc_url,user,pwd);
		Statement st = con.createStatement();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Username:");
		String uname = sc.next();
		System.out.println("Enter Password:");
		String upwd = sc.next();
		String sqlQuery = "select count(*) from users where uname='"+uname+"' and upwd='"+upwd+"'";
		
		ResultSet rs = st.executeQuery(sqlQuery);
		int c=0;
		if(rs.next())
		{
			c=rs.getInt(1);
		}
		if(c==0)
			System.out.println("Invalid Credentials");
		else
			System.out.println("Valid Credentials");
		
		
		
		con.close();

	}

}
