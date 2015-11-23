package de.htw_berlin.ai_bachelor.kbe.date.format;

import de.htw_berlin.ai_bachelor.kbe.date.Date;

public class DateFormatISO implements DateFormat {
	private Date date;
	
	public DateFormatISO() {
		this(null);
	}
	
	public DateFormatISO(Date _date) {
		date = _date;
	}
	
	@Override
	public void setDate(Date _date) {
		date = _date;
	}
	
	@Override
	public String toString() {
		return String.format("%d/%d/%d",
			date.getMonth(), 
			date.getDay(),
			date.getYear()
		);
	}
}