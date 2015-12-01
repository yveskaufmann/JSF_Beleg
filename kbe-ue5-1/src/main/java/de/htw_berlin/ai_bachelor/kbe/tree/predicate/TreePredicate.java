package de.htw_berlin.ai_bachelor.kbe.tree.predicate;

import de.htw_berlin.ai_bachelor.kbe.tree.Tree;

public interface TreePredicate<V> {
	boolean isOk(Tree<V> tree);
}
