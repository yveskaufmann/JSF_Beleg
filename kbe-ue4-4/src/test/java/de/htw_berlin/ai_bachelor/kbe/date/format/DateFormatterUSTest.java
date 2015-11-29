package de.htw_berlin.ai_bachelor.kbe.date.format;

import de.htw_berlin.ai_bachelor.kbe.date.Date;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class DateFormatterUSTest {
	Date date;
	DateFormatterUS formatter;

	@Before
	public void createDate() {
		date = new Date(15, 10, 2015);
		formatter = new DateFormatterUS();
	}

	@Test
	public void testFormatWithTestDate() {
		assertEquals("2015-10-15", formatter.format(date));
	}

	@Test
	public void testFormatWithChangedTestDate() {
		date.setDay(1);
		assertEquals("2015-10-01", formatter.format(date));
	}

	@Test
	public void ensuresThatDayAndMonthAreTwoDigits() {
		assertEquals("2015-01-01", formatter.format(
			new Date(1, 1, 2015)
		));
	}
}
