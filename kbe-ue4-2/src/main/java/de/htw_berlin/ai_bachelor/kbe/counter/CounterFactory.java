package de.htw_berlin.ai_bachelor.kbe.counter;

import de.htw_berlin.ai_bachelor.kbe.counter.impl.SimpleCounter;
import de.htw_berlin.ai_bachelor.kbe.util.Singleton;
import de.htw_berlin.ai_bachelor.kbe.util.StringUtils;


public class CounterFactory {
	public static Counter getInstance(String name) {
		Class<?> type = null;
		try {
			type = Class.forName(normalize(name));
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException(
					String.format("The requested \"%s\" wasn't found.", name)
			);
		}
		return (Counter) Singleton.of(type);
	}

	private static String normalize(String name) {
		return SimpleCounter.class.getPackage().getName() 
				+ "." 
				+ StringUtils.toUpperCaseFirstLetter(name.trim())
				+ "Counter";
	}
}
