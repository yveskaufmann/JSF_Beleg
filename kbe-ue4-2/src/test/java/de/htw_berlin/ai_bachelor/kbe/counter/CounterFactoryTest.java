package de.htw_berlin.ai_bachelor.kbe.counter;

import de.htw_berlin.ai_bachelor.kbe.counter.impl.*;

import static org.junit.Assert.*;
import org.junit.Test;

public class CounterFactoryTest {
	@Test
	public void getInstanceSimple() {
		assertEquals(
			SimpleCounter.class,
			CounterFactory.getInstance("simple").getClass()
		);
	}
	
	@Test
	public void getInstanceDouble() {
		assertEquals(
			DoubleCounter.class,
			CounterFactory.getInstance("double").getClass()
		);
	}
	
	@Test
	public void getInstanceTriple() {
		assertEquals(
			TripleCounter.class,
			CounterFactory.getInstance("triple").getClass()
		);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void getInstanceIllegalArgument () {
		CounterFactory.getInstance("quadruple");
	}
	
	@Test
	public void getInstanceBadFormattedArgument() {
		assertEquals(
			SimpleCounter.class,
			CounterFactory.getInstance("    simple ").getClass()
		);
	}
	
	@Test
	public void getInstanceExisting() {
		Counter counter = CounterFactory.getInstance("simple");
		
		assertEquals (
			counter,
			CounterFactory.getInstance("simple")	
		);
	}
	
	@Test
	public void getInstanceNotExisting() {
		Counter counter = CounterFactory.getInstance("simple");
		
		assertNotEquals (
			counter,
			CounterFactory.getInstance("double")	
		);
	}
}
