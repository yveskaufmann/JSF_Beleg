package de.htw_berlin.ai_bachelor.kbe.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilsTest {

	@Test
	public void testToUpperCaseFirstLetter() throws Exception {
		String testString = "  testString ";
		assertEquals("  TestString ", StringUtils.toUpperCaseFirstLetter(testString));
	}
}
