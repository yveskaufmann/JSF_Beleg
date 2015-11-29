package de.htw_berlin.ai_bachelor.kbe.date.format;

import de.htw_berlin.ai_bachelor.kbe.date.Date;

public class ISODateFormatter implements DateFormatter {

	@Override
	public String format(Date date) {
		return String.format("%02d/%02d/%d",
			date.getMonth(), 
			date.getDay(),
			date.getYear()
		);
	}
}
