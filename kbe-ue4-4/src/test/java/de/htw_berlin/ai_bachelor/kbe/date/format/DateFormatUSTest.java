package de.htw_berlin.ai_bachelor.kbe.date.format;

import de.htw_berlin.ai_bachelor.kbe.date.Date;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class DateFormatUSTest {
	Date date;
	DateFormatUS formatter;

	@Before
	public void createDate() {
		date = new Date(15, 10, 2015);
		formatter = new DateFormatUS();
	}

	@Test
	public void format_aassignDate_ResultAsExpected() {
		assertEquals("2015-10-15", formatter.format(date));
	}

	@Test
	public void format_aasignChangedDate_ResultAsExpected() {
		date.setDay(1);
		assertEquals("2015-10-01", formatter.format(date));
	}

	@Test
	public void format_aasignFirstJanuarOf2015_DateComponentsAreTwoDigits() {
		assertEquals("2015-01-01", formatter.format(
			new Date(1,1,2015)
		));
	}
}
