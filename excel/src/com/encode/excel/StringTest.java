package com.encode.excel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class StringTest {
	public static void main(String[] args) {
		String str1 = "hello";
		String str2 = new String("hello");
		System.out.println(str1.equals(str2));
		System.out.println(str1.intern() == str2.intern());
		
		Date now = new Date();
		
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.getMinimalDaysInFirstWeek());
//		calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTime(now);
        
        
        
        calendar.add(Calendar.DATE, 144);
        System.out.println(calendar.getTime());
        String burepayDay = new SimpleDateFormat("YYYYƒÍMM‘¬dd»’").format(calendar.getTime());
        
        System.out.println(calendar.getTime().toLocaleString());
        System.out.println(burepayDay);
        
        System.out.println(calendar.getWeeksInWeekYear());
        
        String str = "hjjk";
        System.out.println(str.substring(0, 4));
        
	}
}
