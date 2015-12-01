package de.htw_berlin.ai_bachelor.kbe.tree.predicate;

import de.htw_berlin.ai_bachelor.kbe.tree.Tree;

public class ComparePredicate<V extends Comparable<V>> implements TreePredicate<V> {

	private V minElement;
	private V maxElement;

	public ComparePredicate(V minElement, V maxElement) {
		this.minElement = minElement;
		this.maxElement = maxElement;
	}

	@Override
	public boolean isOk(Tree<V> tree) {
		V value = tree.getValue();

		return  minElement.compareTo(value) < 0
			&&  maxElement.compareTo(value) > 0;
	}
}
