package de.htw_berlin.ai_bachelor.kbe.tree;

public class Tree {
	private final int value;
	private final Tree left;
	private final Tree right;

	public Tree(int v, Tree l, Tree r) {
		this.value = v;
		this.left = l;
		this.right = r;
	}

	public int getValue() {
		return this.value;
	}

	public Tree getLeft() {
		return this.left;
	}

	public Tree getRight() {
		return this.right;
	}
}
