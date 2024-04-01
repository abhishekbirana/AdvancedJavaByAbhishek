package JDBC;


/*
Stored procedure
======================
create or replace procedure getEmpInfo(id IN number, name OUT varchar2,sal OUT number) as
BEGIN
select ename, esal into name, sal from employees where eno=id;
END;
/

*/

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class Prr15_StoredProcedureDemo3
{
	public static void main(String[] args) throws Exception
	{
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@IN2-NOINB-ABBI.in2ittech.local:1521:orcl","scott","tiger");
		CallableStatement cst = con.prepareCall("{call getEmpInfo(?,?,?)}");
		cst.setInt(1, 600);
		cst.registerOutParameter(2, Types.VARCHAR);
		cst.registerOutParameter(3, Types.FLOAT);
		cst.execute();
		System.out.println("Employee Name :"+cst.getString(2));
		System.out.println("Employee Salary :"+cst.getFloat(3));
		con.close();

	}

}
