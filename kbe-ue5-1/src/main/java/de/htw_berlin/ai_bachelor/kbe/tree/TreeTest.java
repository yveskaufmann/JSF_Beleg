package de.htw_berlin.ai_bachelor.kbe.tree;


import de.htw_berlin.ai_bachelor.kbe.tree.predicate.ComparePredicate;
import de.htw_berlin.ai_bachelor.kbe.util.StringUtils;

import java.util.*;

import static java.util.stream.Collectors.*;


import java.util.stream.Stream;

public class TreeTest {

	public static final String ONE_INDENT_STRING = StringUtils.fill(2, " ");

	public static void main(String... a) {
		Tree<Integer> tree = new Tree<>(42,
			new Tree<>(23, new Tree<>(1), null),
			new Tree<>(65, null, null)
		);

		System.out.println(export(tree));
		System.out.println();
		System.out.println("Tree Sum: " + TreeSum.sum(tree));
		System.out.println();

		System.out.print("FilterElements: ");
		filterElements(new ComparePredicate<>(20, 25), tree)
			.forEach(System.out::println);

	}

	public static <T extends Comparable<T>> Collection<T> filterElements(ComparePredicate<T> predicate, Tree<T> tree) {
		ArrayList<T> accumulator = new ArrayList<>();
		filterElements(predicate, tree, accumulator);
		return accumulator;
	}

	private static <T extends Comparable<T>> void filterElements(ComparePredicate<T> predicate, Tree<T> tree, Collection<T> accumulator) {

		if (tree == null) return;

		if (predicate.isOk(tree)) {
			accumulator.add(tree.getValue());
		}
		
		filterElements(predicate, tree.getLeft(), accumulator);
		filterElements(predicate, tree.getRight(), accumulator);
	}

	public static <T> String export(Tree<T> tree) {
		return export(tree, 0);
	}

	private static <T> String export(Tree<T> tree, int depth) {
		StringBuilder str = new StringBuilder();
		export(tree, str, depth);
		return str.toString();
	}

	private static <T> void export(Tree<T> tree, StringBuilder string, int depth) {

		if (tree == null) {
			return;
		}

		final String indention = StringUtils.fill(depth, ONE_INDENT_STRING);
		String childrenString = Stream
			.of(tree.getLeft(), tree.getRight())
			.map((elm) -> {
				if (elm != null) {
					return "\n" + export((Tree<?>) elm, depth + 1);
				}
				return "\n" + indention + ONE_INDENT_STRING + Objects.toString(null);
			}).collect(joining(","));

		string
			.append(indention).append("[")
			.append(Objects.toString(tree.getValue())).append(",")
			.append(childrenString).append("\n")
			.append(indention).append("]"); 
	}

}
