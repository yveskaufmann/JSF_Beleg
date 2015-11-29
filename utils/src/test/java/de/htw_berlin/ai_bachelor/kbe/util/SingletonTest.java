package de.htw_berlin.ai_bachelor.kbe.util;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class SingletonTest {

	@Test
	public void testSingletonOfReturnsASingletonObject() throws Exception {
		Class<?> type = Object.class;

		Object singletonObject = Singleton.of(type);

		assertEquals(type, singletonObject.getClass());
		assertSingleton(singletonObject);
	}

	private void assertSingleton(Object object) {
		assertNotNull(object);
		assertTrue(object == Singleton.of(object.getClass()));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSingletonOfWithNonDefaultConstructor() throws Exception {
		Singleton.of(Boolean.class);
	}
}
