package JDBC;

/*
  create or replace function getAvg(id1 IN number, id2 IN number) return number
  as
  sal1 number;
  sal2 number;
  BEGIN
  select esal into sal1 from employees where eno=id1;
  select esal into sal2 from employees where eno=id2;
  return (sal1+sal2)/2;
  END;
  /
   
   CREATE OR REPLACE FUNCTION getAvg(id1 IN NUMBER, id2 IN NUMBER) RETURN NUMBER
AS
  sal1 NUMBER;
  sal2 NUMBER;
  avg_sal NUMBER;
BEGIN
  SELECT esal INTO sal1 FROM employees WHERE eno = id1;
  SELECT esal INTO sal2 FROM employees WHERE eno = id2;
  
  avg_sal := (sal1 + sal2) / 2;
  
  RETURN avg_sal;
END;
/

   
  
 */


import java.sql.*;

public class Prr13_StoredProcedureDemo1 {

	public static void main(String[] args) throws Exception
	{
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@IN2-NOINB-ABBI.in2ittech.local:1521:orcl","scott","tiger");
		CallableStatement cst = con.prepareCall("{?=call getAvg(?,?)}");
		cst.setInt(2, 100);
		cst.setInt(3, 300);
		cst.registerOutParameter(1, Types.FLOAT);
		cst.execute();
		System.out.println("Average Salary :"+cst.getFloat(1));
		con.close();

	}

}
