package JDBC;



/*
 Firstly Create Table then execute this code
 
 create table from persons (name varchar2(10), image BLOB);
 */


import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Prr24_BLOBDemo1
{
	public static void main(String[] args) throws Exception
	{
		String driver = "oracle.jdbc.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@IN2-NOINB-ABBI.in2ittech.local:1521:orcl";
		String user = "scott";
		String pwd = "tiger";
		Connection con = DriverManager.getConnection(jdbc_url,user,pwd);
		String sqlQuery = "insert into persons values(?,?)";
		PreparedStatement ps = con.prepareStatement(sqlQuery);
		ps.setString(1,"CaptainAme");
		File f = new File(".\\src\\main\\resources\\captainAmerica.jpeg");
		FileInputStream fis = new FileInputStream(f);
		ps.setBinaryStream(2, fis,(int)f.length());
		System.out.println("Inserting image from : "+f.getAbsolutePath());
		int updateCount = ps.executeUpdate();
		if (updateCount==1)
		{
			System.out.println("Record Inserted");
			
		}
		else
		{
			System.out.println("Record Not Inserted");
		}
		con.close();
	}

}
