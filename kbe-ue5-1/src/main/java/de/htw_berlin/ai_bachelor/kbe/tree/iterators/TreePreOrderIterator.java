package de.htw_berlin.ai_bachelor.kbe.tree.iterators;

import de.htw_berlin.ai_bachelor.kbe.tree.Tree;

public class TreePreOrderIterator<T> extends TreeIterator<T> {


	public TreePreOrderIterator(Tree<T> tree) {
		super(tree);
	}

	@Override
	public T next() {
		Tree<T> currentNode = stack.pop();

		addToStackWhenNonNull(currentNode.getRight());
		addToStackWhenNonNull(currentNode.getLeft());

		return currentNode.getValue();

	}

}
