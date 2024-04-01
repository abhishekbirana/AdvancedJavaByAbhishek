package JDBC;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class Prr20_DateTest {

	public static void main(String[] args)
	{
		Date uDate = new Date();
		System.out.println("Util Date: "+uDate);		// Util Date: Mon Apr 01 12:37:57 IST 2024
		long l = uDate.getTime();
		
		java.sql.Date sDate = new java.sql.Date(l);
		System.out.println("SQL Date: "+sDate);		// SQL Date: 2024-04-01
		
		Time t = new Time(l);
		System.out.println("Using Time Class: "+t);		// Using Time Class: 12:37:57
		
		Timestamp ts = new Timestamp(l);
		System.out.println("Using Timestamp Class: "+ts);		// Using Timestamp Class: 2024-04-01 12:37:57.159

	}

}
