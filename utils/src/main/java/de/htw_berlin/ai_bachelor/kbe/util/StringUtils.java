package de.htw_berlin.ai_bachelor.kbe.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

	private static final Pattern FIRST_LETTER_PATTERN = Pattern.compile("([^\\s\\d])");

	public static String toUpperCaseFirstLetter(String name) {

		Matcher firstLetterMatcher =  FIRST_LETTER_PATTERN.matcher(name);
		if (firstLetterMatcher.find()) {
			String firstLetter = firstLetterMatcher.group(1);
			return firstLetterMatcher.replaceFirst(firstLetter.toUpperCase());
		}
		return name;
	}
}
