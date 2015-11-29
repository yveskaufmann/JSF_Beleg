package de.htw_berlin.ai_bachelor.kbe.util;


import java.util.Objects;
import static org.junit.Assert.*;

public class AssertsUtils {

	public static void assertSingleton(Object object) {
		assertNotNull(object);
		assertTrue(object == Singleton.of(object.getClass()));
	}

	public static void assertIsInstanceOf(Object object, Class<?> expectedType) {
		if (Objects.isNull(expectedType)) return;

		assertNotNull(object);
		assertEquals(expectedType, object.getClass());
	}
}
