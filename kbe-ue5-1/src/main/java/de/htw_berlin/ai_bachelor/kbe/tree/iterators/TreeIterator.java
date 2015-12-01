package de.htw_berlin.ai_bachelor.kbe.tree.iterators;

import de.htw_berlin.ai_bachelor.kbe.tree.Tree;

import java.util.Iterator;
import java.util.Stack;

public abstract class TreeIterator<T> implements Iterator<T> {
	protected Stack<Tree<T>> stack = new Stack<>();

	@Override
	public boolean hasNext() {
		return ! stack.isEmpty();
	}

	protected void addToStackWhenNonNull(Tree<T> node) {
		if (node != null) {
			stack.push(node);
		}
	}

	@Override
	public void remove() {
	}
}
