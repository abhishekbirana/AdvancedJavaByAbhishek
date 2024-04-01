package JDBC;

import java.util.Scanner;

public class SqlQueryWithDynamicInput1
{

	public static void main(String[] args)
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Employee Number:");
		int eno = sc.nextInt();
		System.out.println("Enter Employee Name:");
		String ename = sc.next();
		System.out.println("Enter Employee Salary:");
		double esal = sc.nextDouble();
		System.out.println("Enter Employee Address:");
		String eaddr = sc.next();
		
		/*
		 * We will use it but to avoid many comma double quotes etc. we will use String.format
		 * 
		String sqlQueryy = "insert into employees values("+eno+",'"+ename+"',"+esal+",'"+eaddr+"')";
		*/
		
		String sqlQuery = String.format("insert into employees values(%d,'%s',%f,'%s')", eno, ename, esal, eaddr);
		
		/*
		 * %d ==> Decimal Values
		 * %s ==> String Values
		 * %f ==> Float Values
		 */
		
		System.out.println("Hello Query with your Dynamic Input is:");
		System.out.println(sqlQuery);
	}

}
