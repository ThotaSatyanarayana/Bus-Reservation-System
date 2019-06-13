package com.badri.util;

import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DateUtil {
	public static List<String> getMonthNames() {
		List<String> monthnames = new ArrayList<String>();
		for (int i = 1; i <= 12; i++) {
			monthnames.add(Month.of(i).toString());
		}
		return monthnames;
	}

	public static List<Integer> getYears() {
		List<Integer> year = new ArrayList<Integer>();
		year.add(currentYear());
		year.add(currentYear() + 1);
		return year;
	}

	public static final int currentMonth() {
		return Integer.parseInt(new SimpleDateFormat("MM").format(Calendar.getInstance().getTime()));
	}

	public static final int currentYear() {
		return Integer.parseInt(new SimpleDateFormat("yyyy").format(Calendar.getInstance().getTime()));
	}

	public static final int currentDay() {
		return Integer.parseInt(new SimpleDateFormat("dd").format(Calendar.getInstance().getTime()));
	}

	public static final int maxDaysOfAMonth(int year, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, 1);
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	public static final String currentDate() {
		return new SimpleDateFormat("dd/MMM/yyyy").format(Calendar.getInstance().getTime());
	}

	public static final String getTimeStamp() {
		return new SimpleDateFormat("dd/MMM/yyyy").format(Calendar.getInstance().getTime());
	}

}
