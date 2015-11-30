package de.htw_berlin.ai_bachelor.kbe.date;

import de.htw_berlin.ai_bachelor.kbe.date.format.DateFormatter;
import de.htw_berlin.ai_bachelor.kbe.date.format.DateFormatterCH;
import de.htw_berlin.ai_bachelor.kbe.date.format.DateFormatterISO;
import de.htw_berlin.ai_bachelor.kbe.date.format.DateFormatterUS;
import org.junit.Test;

import static de.htw_berlin.ai_bachelor.kbe.util.AssertsUtils.*;
import static de.htw_berlin.ai_bachelor.kbe.date.DateFormatterFactory.CH_FORMATTER;
import static de.htw_berlin.ai_bachelor.kbe.date.DateFormatterFactory.ISO_FORMATTER;
import static de.htw_berlin.ai_bachelor.kbe.date.DateFormatterFactory.US_FORMATTER;

public class DateFormatterFactoryTest {

	public static final String UNKNOWN_FORMATTER = "UNKNOWN";
	public static final Class<DateFormatterCH> DEFAULT_FORMATTER = DateFormatterCH.class;

	@Test
	public void testGetInstanceReturnsDefaultFormatter() throws Exception {
		DateFormatter formatter = DateFormatterFactory.getInstance();
		assertIsInstanceOf(formatter, DEFAULT_FORMATTER);
	}

	@Test
	public void testGetInstanceByName() throws Exception {
		assertIsInstanceOf(DateFormatterFactory.getInstanceByName(CH_FORMATTER), DateFormatterCH.class);
		assertIsInstanceOf(DateFormatterFactory.getInstanceByName(ISO_FORMATTER), DateFormatterISO.class);
		assertIsInstanceOf(DateFormatterFactory.getInstanceByName(US_FORMATTER), DateFormatterUS.class);
	}

	@Test
	public void testGetInstanceByNameWithNullReturnsTheDefaultFormatter() throws Exception {
		assertIsInstanceOf(DateFormatterFactory.getInstanceByName(null), DEFAULT_FORMATTER);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetInstanceByNameWithUnknownFormatterName() {
		DateFormatterFactory.getInstanceByName(UNKNOWN_FORMATTER);
	}

	@Test
	public void ensuresThatTheFactoryReturnsSingletons() {
		DateFormatter formatterCh = DateFormatterFactory.getInstance();
		DateFormatter formatterIso = DateFormatterFactory.getInstanceByName(ISO_FORMATTER);
		DateFormatter formatterUs = DateFormatterFactory.getInstanceByName(US_FORMATTER);

		assertSingleton(formatterCh);
		assertSingleton(formatterIso);
		assertSingleton(formatterUs);
	}
}
