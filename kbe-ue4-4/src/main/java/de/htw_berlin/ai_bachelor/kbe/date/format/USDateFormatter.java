package de.htw_berlin.ai_bachelor.kbe.date.format;

import de.htw_berlin.ai_bachelor.kbe.date.Date;

public class USDateFormatter implements DateFormatter {

	@Override
	public String format(Date date) {
		return String.format("%d-%02d-%02d",
			date.getYear(),
			date.getMonth(), 
			date.getDay()
		);
	}
}
