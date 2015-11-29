package de.htw_berlin.ai_bachelor.kbe.date;

import de.htw_berlin.ai_bachelor.kbe.date.format.DateFormatter;
import de.htw_berlin.ai_bachelor.kbe.util.ReflectionUtils;
import de.htw_berlin.ai_bachelor.kbe.util.Singleton;

public class DateFormatterFactory {

	public static DateFormatter getInstance() {
		return getInstanceByName("ch");
	}

	public static DateFormatter getInstanceByName(String name) {
		Class<?> type = getFormatterClassByName(name);
		ensuresClassImplementsDataFormatter(type);
		return (DateFormatter) Singleton.of(type);
	}

	private static Class<?> getFormatterClassByName(String name) {
		try {
			return Class.forName(normalizeClassName(name));
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException(
				String.format("The requested \"%s\" wasn't found.", name)
			);
		}
	}

	private static String normalizeClassName(String name) {
		return DateFormatter.class.getPackage().getName()
			+ "."
			+ "DateFormat"
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
