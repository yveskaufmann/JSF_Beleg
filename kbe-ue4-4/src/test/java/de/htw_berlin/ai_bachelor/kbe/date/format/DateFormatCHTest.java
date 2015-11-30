package de.htw_berlin.ai_bachelor.kbe.date.format;

import de.htw_berlin.ai_bachelor.kbe.date.Date;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class DateFormatCHTest {
	Date date;
	DateFormatterCH formatter;

	@Before
	public void createDate() {
		date = new Date(15, 10, 2015);
		formatter = new DateFormatterCH();
	}

	@Test
	public void testFormatWithTestDate() {
		assertEquals("15.10.2015", formatter.format(date));
	}

	@Test
	public void testFormatWithChangedTestDate() {
		date.setDay(1);
		assertEquals("01.10.2015", formatter.format(date));
	}

	@Test
	public void ensuresThatDayAndMonthAreTwoDigits() {
		assertEquals("01.01.2015", formatter.format(
			new Date(1,1,2015)
		));
	}
}
