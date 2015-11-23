package de.htw_berlin.ai_bachelor.kbe.date;

public class Date {
	private int day, month, year;
	
	public void setDay (int _day) {
		day = _day;
	}
	
	public int getDay () {
		return day;
	}
	
	public void setMonth (int _month) {
		month = _month;
	}
	
	public int getMonth () {
		return month;
	}
	
	public void setYear (int _year) {
		year = _year;
	}
	
	public int getYear () {
		return year;
	}
	
	public Date () {
		this(0, 0, 0);
	}
	
	public Date (int _day, int _month, int _year) {
		day = _day;
		month = _month;
		year = _year;
	}
}