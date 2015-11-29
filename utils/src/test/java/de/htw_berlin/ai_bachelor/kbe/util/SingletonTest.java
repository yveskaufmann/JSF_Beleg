package de.htw_berlin.ai_bachelor.kbe.util;

import org.junit.Test;

import static de.htw_berlin.ai_bachelor.kbe.util.AssertsUtils.*;

public class SingletonTest {

	@Test
	public void testSingletonOfReturnsASingletonObject() throws Exception {
		Class<?> type = Object.class;

		Object singletonObject = Singleton.of(type);

		assertIsInstanceOf(singletonObject, type);
		assertSingleton(singletonObject);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSingletonOfWithNonDefaultConstructor() throws Exception {
		Singleton.of(Boolean.class);
	}
}
