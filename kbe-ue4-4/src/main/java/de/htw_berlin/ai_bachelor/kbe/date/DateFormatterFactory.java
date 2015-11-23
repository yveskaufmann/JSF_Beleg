package de.htw_berlin.ai_bachelor.kbe.date;

import de.htw_berlin.ai_bachelor.kbe.date.format.DateFormatter;
import de.htw_berlin.ai_bachelor.kbe.util.Singelton;


public class DateFormatterFactory {

	public static DateFormatter getInstance(String name) {
		Class<?> type = null;
		try {
			type = Class.forName(normalize(name));
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException(
				String.format("The requested \"%s\" wasn't found.", name)
			);
		}
		return (DateFormatter) Singelton.of(type);
	}

	private static String normalize(String name) {
		return DateFormatter.class.getPackage().getName()
			+ "."
			+ "DateFormat"
			+ name.toUpperCase();
	}

	public static DateFormatter getInstance() {
		return getInstance("ch");
	}
}
