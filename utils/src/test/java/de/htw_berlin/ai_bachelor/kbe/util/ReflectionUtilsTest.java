package de.htw_berlin.ai_bachelor.kbe.util;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ReflectionUtilsTest {

	@Test
	public void isImplementation() throws Exception {
		class Dummy implements Comparable<String> {
			@Override
			public int compareTo(String o) {
				return 0;
			}
		}
		assertTrue(ReflectionUtils.isImplementation(Dummy.class, Comparable.class));
		assertFalse(ReflectionUtils.isImplementation(Object.class, Comparable.class));
	}

	@Test(expected = IllegalArgumentException.class)
	public void isImplementationWithNonInterfaceTypeAssigned() throws Exception {
		assertTrue(ReflectionUtils.isImplementation(Object.class, Object.class));
	}
}
