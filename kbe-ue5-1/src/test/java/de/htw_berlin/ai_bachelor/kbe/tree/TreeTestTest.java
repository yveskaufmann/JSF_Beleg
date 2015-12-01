package de.htw_berlin.ai_bachelor.kbe.tree;

import de.htw_berlin.ai_bachelor.kbe.tree.predicate.ComparePredicate;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TreeTestTest {


	public Tree<Integer> createIntegerTree() {
		Tree<Integer> tree = new Tree<>(42,
			new Tree<>(23, new Tree<>(1), null),
			new Tree<>(65, null, null)
		);

		return tree;
	}

	@Test
	public void testExportWithRootOnly() throws Exception {
		Tree<Integer> root = new Tree<>(9, null, null);
		assertEquals(
			  "[9,\n"
			+   "  null,\n"
			+   "  null\n"
			+ "]", TreeTest.export(root)
		);
	}

	@Test
	public void testExport() throws Exception {
		Tree<Integer> root = createIntegerTree();
		assertEquals(
			  "[42,\n"
			+ "  [23,\n"
			+ "    [1,\n"
			+ "      null,\n"
			+ "      null\n"
		    + "    ],\n"
			+ "    null\n"
			+ "  ],\n"
			+ "  [65,\n"
			+ "    null,\n"
		    + "    null\n"
		    + "  ]\n"
			+ "]", TreeTest.export(root));

	}

	@Test
	public void testFilterElements() {
		Tree<Integer> tree = createIntegerTree();

		assertCollectionEquals(
			Arrays.asList(23),
			TreeTest.filterElements(new ComparePredicate<>(20, 25), tree)
		);

		assertCollectionEquals(
			Arrays.asList(),
			TreeTest.filterElements(new ComparePredicate<>(100, 120), tree)
		);

		assertCollectionEquals(
			Arrays.asList(42, 23, 65),
			TreeTest.filterElements(new ComparePredicate<>(1, 70), tree)
		);

		assertCollectionEquals(
			Arrays.asList(42, 23, 1, 65),
			TreeTest.filterElements(new ComparePredicate<>(0, 70), tree)
		);

	}

	private <T> void assertCollectionEquals(Collection<T> expected, Collection<T> actual) {
		assertArrayEquals(expected.toArray(), actual.toArray());
	}

}
