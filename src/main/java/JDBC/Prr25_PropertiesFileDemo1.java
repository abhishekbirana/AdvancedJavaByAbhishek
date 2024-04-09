package JDBC;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class Prr25_PropertiesFileDemo1
{
	public static void main(String[] args) throws Exception
	{
		Properties p =new Properties();
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\db.properties");
		p.load(fis);
		String jdbc_url = p.getProperty("url");
		String user = p.getProperty("user");
		String pwd = p.getProperty("pwd");
		Connection con = DriverManager.getConnection(jdbc_url,user,pwd);
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
