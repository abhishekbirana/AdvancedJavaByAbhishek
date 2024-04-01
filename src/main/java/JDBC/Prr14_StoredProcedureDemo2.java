package JDBC;


/*
	create or replace procedure addProc(num1 IN number, num2 IN number,num3 OUT number) as
	BEGIN
	num3 := num1+num2;
	END;
	/


O/P:= Procedure create

SQL>  commit;
O/P:= Commit competed

 */



import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class Prr14_StoredProcedureDemo2 {

	public static void main(String[] args) throws Exception
	{
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@IN2-NOINB-ABBI.in2ittech.local:1521:orcl","scott","tiger");
		CallableStatement cst = con.prepareCall("{call addProc(?,?,?)}");
		cst.setInt(1, 100);
		cst.setInt(2, 200);
		cst.registerOutParameter(3, Types.INTEGER);
		cst.execute();
		System.out.println("Result :"+cst.getInt(3));
		con.close();

	}

}
