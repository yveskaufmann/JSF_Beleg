package de.htw_berlin.ai_bachelor.kbe.date;

import de.htw_berlin.ai_bachelor.kbe.date.format.DateFormatterCH;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class DateTest {

	@Test
	public void testToday() throws Exception {
		LocalDate currentLocalDate = LocalDate.now();

		Date today = Date.today();

		assertEquals(currentLocalDate.getDayOfMonth(), today.getDay());
		assertEquals(currentLocalDate.getMonthValue(), today.getMonth());
		assertEquals(currentLocalDate.getYear(), today.getYear());
	}

	@Test
	public void testToString() throws Exception {
		Date testDate = new Date(24,12,2015);

		String formattedDate = testDate.toString();

		assertEquals(new DateFormatterCH().format(testDate), formattedDate);

	}
}
