package JDBC;

/*
Stored procedure
======================
create or replace procedure getAllEmpInfo2(initchars IN varchar, emps OUT SYS_REFCURSOR) as
BEGIN
open emps for
select * from employees where ename like initchars;
END;
/

*/




import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import oracle.jdbc.OracleTypes;    // for OracleTypes.CURSOR and it is presented in ojdbc6.jar

public class Prr18_StoredProcedureDemo5
{
	public static void main(String[] args) throws Exception
	{
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@IN2-NOINB-ABBI.in2ittech.local:1521:orcl","scott","tiger");
		CallableStatement cst = con.prepareCall("{call getAllEmpInfo2(?,?)}");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter initial character of the name : ");
		String initialchars =  sc.next()+"%";
		cst.setString(1, initialchars);
		cst.registerOutParameter(2, OracleTypes.CURSOR);
		cst.execute();
		ResultSet rs = (ResultSet)cst.getObject(2);
		boolean flag = false;
		System.out.println("ENO\tENAME\tESAL\tEADDR");
		System.out.println("=============================");
		while(rs.next())
		{
			flag = true;
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+rs.getString(4));
		}
		if (flag==false)
		{
			System.out.println("No Records Available");
		}
		con.close();

	}
}
