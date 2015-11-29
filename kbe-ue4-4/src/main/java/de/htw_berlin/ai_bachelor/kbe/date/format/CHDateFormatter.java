package de.htw_berlin.ai_bachelor.kbe.date.format;

import de.htw_berlin.ai_bachelor.kbe.date.Date;

public class CHDateFormatter implements DateFormatter {

	@Override
	public String format(Date date) {
		return String.format("%02d.%02d.%d",
			date.getDay(),
			date.getMonth(),
			date.getYear()
		);
	}
}
