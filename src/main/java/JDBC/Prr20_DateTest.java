package JDBC;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class Prr20_DateTest {

	public static void main(String[] args)
	{
		Date uDate = new Date();
		System.out.println("Util Date: "+uDate);
		long l = uDate.getTime();
		
		java.sql.Date sDate = new java.sql.Date(l);
		System.out.println("SQL Date: "+sDate);
		
		Time t = new Time(l);
		System.out.println("Using Time Class: "+t);
		
		Timestamp ts = new Timestamp(l);
		System.out.println("Using Timestamp Class: "+ts);

	}

}
