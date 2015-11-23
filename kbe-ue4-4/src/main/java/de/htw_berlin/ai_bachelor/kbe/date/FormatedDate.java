package de.htw_berlin.ai_bachelor.kbe.date;

import de.htw_berlin.ai_bachelor.kbe.date.format.DateFormat;
import de.htw_berlin.ai_bachelor.kbe.date.format.DateFormatCH;

public class FormatedDate {
	private Date date;
	private DateFormat dateFormat;
	
	public void setDate (Date _date) {
		date = _date;
		dateFormat.setDate(getDate());
	}
	
	public Date getDate () {
		return date;
	}
	
	public void setDateFormat (DateFormat _dateFormat) {
		dateFormat = _dateFormat;
		dateFormat.setDate(getDate());
	}
	
	public DateFormat getDateFormat () {
		return dateFormat;
	}
	
	public FormatedDate () {
		this(0, 0, 0);
	}
	
	public FormatedDate (int _day, int _month, int _year) {
		this(new DateFormatCH(), _day, _month, _year);
	}
	
	public FormatedDate (DateFormat _format, int _day, int _month, int _year) {
		dateFormat = _format;
		date = new Date(_day, _month, _year);
		dateFormat.setDate(date);
	}
	
	@Override
	public String toString () {
		return dateFormat.toString();
	}
}