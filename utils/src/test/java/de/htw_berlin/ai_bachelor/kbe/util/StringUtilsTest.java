package de.htw_berlin.ai_bachelor.kbe.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilsTest {

	@Test
	public void testToUpperCaseFirstLetter() throws Exception {
		String testString = "  testString ";
		assertEquals("  TestString ", StringUtils.toUpperCaseFirstLetter(testString));
	}

	@Test
	public void testFill() {
		assertEquals("", StringUtils.fill(0, ""));
		assertEquals("4242", StringUtils.fill(2, "42"));
		assertEquals("", StringUtils.fill(-1, "42"));
	}
}
