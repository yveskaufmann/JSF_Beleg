package de.htw_berlin.ai_bachelor.kbe.tree.iterators;

import de.htw_berlin.ai_bachelor.kbe.tree.Tree;

import java.util.Iterator;
import java.util.Stack;

public class TreePreOrderIterator<T> implements Iterator<T> {

	private Stack<Tree<T>> stack = new Stack<>();

	public TreePreOrderIterator(Tree<T> tree) {
		addToStackWhenNonNull(tree);
	}

	@Override
	public boolean hasNext() {
		return ! stack.isEmpty();
	}

	@Override
	public T next() {
		Tree<T> currentNode = stack.pop();

		addToStackWhenNonNull(currentNode.getRight());
		addToStackWhenNonNull(currentNode.getLeft());

		return currentNode.getValue();

	}

	private void addToStackWhenNonNull(Tree<T> node) {
		if (node != null) {
			stack.push(node);
		}
	}

	@Override
	public void remove() {
	}

}
