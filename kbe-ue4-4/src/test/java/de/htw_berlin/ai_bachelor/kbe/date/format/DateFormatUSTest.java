package de.htw_berlin.ai_bachelor.kbe.date.format;

import de.htw_berlin.ai_bachelor.kbe.date.Date;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class DateFormatUSTest {
	Date date;
	DateFormatUS format;
	
	@Before
	public void createDate() {
		date = new Date(15, 10, 2015);
		format = new DateFormatUS(date);
	}
	
	@Test
	public void toStringSimple() {
		assertEquals("2015-10-15", format.toString());
	}
	
	@Test
	public void toStringChangedDate() {
		format.setDate(new Date(24, 12, 2018));
		assertEquals("2018-12-24", format.toString());
	}
	
	@Test
	public void toStringChangedDateYear() {
		date.setYear(2016);
		assertEquals("2016-10-15", format.toString());
	}
}