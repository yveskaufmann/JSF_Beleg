package de.htw_berlin.ai_bachelor.kbe.date.format;

import de.htw_berlin.ai_bachelor.kbe.date.Date;

public class DateFormatUS implements DateFormat {
	private Date date;
	
	public DateFormatUS() {
		this(null);
	}
	
	public DateFormatUS(Date _date) {
		date = _date;
	}
	
	@Override
	public void setDate(Date _date) {
		date = _date;
	}
	
	@Override
	public String toString() {
		return String.format("%d-%d-%d",
			date.getYear(),
			date.getMonth(), 
			date.getDay()
		);
	}
}