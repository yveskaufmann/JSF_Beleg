package de.htw_berlin.ai_bachelor.kbe.date;

import java.time.LocalDate;

public class Date {

	public static Date today() {
		LocalDate today = LocalDate.now();
		return new Date(
			today.getDayOfMonth(),
			today.getMonthValue(),
			today.getYear()
		);
	}

	private int day;
	private int month;
	private int year;

	public Date (int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return DateFormatterFactory.getInstance().format(this);
	}
}
