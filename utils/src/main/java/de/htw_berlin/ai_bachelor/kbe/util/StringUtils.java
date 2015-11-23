package de.htw_berlin.ai_bachelor.kbe.util;

public class StringUtils {
	
	public static String toUpperCaseFirstLetter(String name) {	
		name = name.trim();
		char first = Character.toUpperCase(name.charAt(0));
		return first + name.substring(1) ;
	}
}
