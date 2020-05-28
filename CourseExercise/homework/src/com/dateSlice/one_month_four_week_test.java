package com.dateSlice;

import java.util.Calendar;

public class one_month_four_week_test {
	
	public static void main(String[] args) {
		
		Calendar cal = Calendar.getInstance();

		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		
		one_month_four_week showList = new one_month_four_week();
		showList.one_month_four_week_method(year,month);
	}

}

