package de.htw_berlin.ai_bachelor.kbe.tree;

public class TreeSum {
	public static Integer sum(Tree<Integer> t) {
		int result = 0;
		if (t != null) {
			result = t.getValue() + sum(t.getLeft()) + sum(t.getRight());
		}
		return result;
	}
}
