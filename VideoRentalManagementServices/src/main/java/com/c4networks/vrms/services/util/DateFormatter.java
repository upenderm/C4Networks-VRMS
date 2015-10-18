package com.c4networks.vrms.services.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {
	
	public static Date convertStringToDate(String dateString){
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date convertedDate = null;
		try {
			convertedDate = (Date) formatter.parse(dateString);
			System.out.println("Date from yyyy-MM-dd String in Java : " + convertedDate);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		return convertedDate;
	}
	
	public static long getNoofDays(Date date1,Date date2) throws ParseException{
//		SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String currentTime = sdf.format(date1);
//		sqlDate = sdf.parse(currentTime);
		long diff = date1.getTime() - date2.getTime();
		 
		long diffSeconds = diff / 1000 % 60;
		long diffMinutes = diff / (60 * 1000) % 60;
		long diffHours = diff / (60 * 60 * 1000) % 24;
		long diffDays = diff / (24 * 60 * 60 * 1000);

		System.out.print(diffDays + " days, ");
		System.out.print(diffHours + " hours, ");
		System.out.print(diffMinutes + " minutes, ");
		System.out.print(diffSeconds + " seconds.");
		
		if(diffDays<=0 && diffHours>=0 && diffMinutes>0){
			diffDays=1;
		}else if(diffDays>0 && diffHours>=6){
			diffDays=diffDays+1;
		}
		
		 return diffDays;
	}

}
