package de.htw_berlin.ai_bachelor.kbe.date;

import de.htw_berlin.ai_bachelor.kbe.date.format.DateFormatter;
import de.htw_berlin.ai_bachelor.kbe.util.ReflectionUtils;
import de.htw_berlin.ai_bachelor.kbe.util.Singleton;

import static java.util.Objects.*;

public class DateFormatterFactory {

	public static final String CH_FORMATTER = "ch";
	public static final String ISO_FORMATTER = "iso";
	public static final String US_FORMATTER = "us";
	public static final String DEFAULT_FORMATTER = CH_FORMATTER;

	public static DateFormatter getInstance() {
		return getInstanceByName(null);
	}

	public static DateFormatter getInstanceByName(String name) {

		if (isNull(name)) {
			name = DEFAULT_FORMATTER;
		}

		Class<?> type = getFormatterClassByName(name);
		ensuresClassImplementsDataFormatter(type);
		return (DateFormatter) Singleton.of(type);
	}

	private static Class<?> getFormatterClassByName(String name) {
		try {
			return Class.forName(normalizeClassName(name));
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException(
				String.format("The requested DateFormatter \"%s\" wasn't found.", name)
			);
		}
	}

	private static String normalizeClassName(String name) {
		return DateFormatter.class.getPackage().getName()
			+ "."
			+ "DateFormatter"
			+ name.trim().toUpperCase();
	}

	private static void ensuresClassImplementsDataFormatter(Class<?> type) {
		if (! ReflectionUtils.isImplementation(type, DateFormatter.class)) {
			throw new IllegalArgumentException(
				String.format(
				 "The requested class \"%s\" didn't implements DateFormatter",
				 type.getName()
			));
        }
	}
}
