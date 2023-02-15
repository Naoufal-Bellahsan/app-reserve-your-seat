package com.app.rys.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {
	
	public static Date convertStringToDate(String dateToconvert) throws ParseException {
		Date date= new SimpleDateFormat("yyyy-MM-dd").parse(dateToconvert); 
		return date;
	}

}
