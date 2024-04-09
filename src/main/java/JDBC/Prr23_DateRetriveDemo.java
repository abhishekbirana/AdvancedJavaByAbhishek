package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class Prr23_DateRetriveDemo
{
	public static void main(String[] args) throws Exception
	{
		String driver = "oracle.jdbc.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@IN2-NOINB-ABBI.in2ittech.local:1521:orcl";
		String user = "scott";
		String pwd = "tiger";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(jdbc_url,user,pwd);
		PreparedStatement pst = con.prepareStatement("select * from usersdate");
		ResultSet rs = pst.executeQuery();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		while(rs.next())
		{
			String name = rs.getString(1);
			java.sql.Date sDate = rs.getDate(2);
			String s = sdf.format(sDate);
			System.out.println(name+"..."+s);
		}
		con.close();
	}
}
