package de.htw_berlin.ai_bachelor.kbe.date.format;

import de.htw_berlin.ai_bachelor.kbe.date.Date;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class DateFormatCHTest {
	Date date;
	DateFormatCH format;
	
	@Before
	public void createDate() {
		date = new Date(15, 10, 2015);
		format = new DateFormatCH(date);
	}
	
	@Test
	public void toStringSimple() {
		assertEquals("15.10.2015", format.toString());
	}
	
	@Test
	public void toStringChangedDate() {
		format.setDate(new Date(24, 12, 2018));
		assertEquals("24.12.2018", format.toString());
	}
	
	@Test
	public void toStringChangedDateYear() {
		date.setYear(2016);
		assertEquals("15.10.2016", format.toString());
	}
}