package de.htw_berlin.ai_bachelor.kbe.tree;


public class TreeTest {
	public static void main(String... a) {
		System.out.println(export(new Tree<>(null, null, null)));
	}

	private static <T> String export(Tree<T> tree) {
		StringBuilder str = new StringBuilder();
		export(tree, str);
		return str.toString();
	}

	private static <T> void export(Tree<T> tree, StringBuilder str) {

		
	}
	
	
		
}
