package de.htw_berlin.ai_bachelor.kbe.util;

public class ReflectionUtils {

	public static boolean isImplementation(Class<?> type, Class<?> interfaceType) {

		if (! interfaceType.isInterface() ) {
			String message = String.format(
				"The specified interfaceType: \"%s\" isn't a interface",
				interfaceType.getName()
			);
			throw new IllegalArgumentException(message);

		}

		return interfaceType.isAssignableFrom(type);
	}
}
