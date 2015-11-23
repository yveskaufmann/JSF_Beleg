package de.htw_berlin.ai_bachelor.kbe.date.format;

import de.htw_berlin.ai_bachelor.kbe.date.Date;

public class DateFormatCH implements DateFormat {
	private Date date;
	
	public DateFormatCH() {
		this(null);
	}
	
	public DateFormatCH(Date _date) {
		date = _date;
	}
	
	@Override
	public void setDate(Date _date) {
		date = _date;
	}
	
	@Override
	public String toString() {
		return String.format("%d.%d.%d", 
			date.getDay(),
			date.getMonth(),
			date.getYear()
		);
	}
}