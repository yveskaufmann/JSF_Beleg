package de.htw_berlin.ai_bachelor.kbe.counter;

/**
 * Interface for a counter which should be implemented by 
 * concrete counter class.
 */
public interface Counter {
	
	/**
	 * Increment the internal state of the counter 
	 * by an implementation based amount.
	 */
	Counter increment();
	
	/**
	 *
	 * @return the current counter state by this Counter.
	 */
	int getCount();
}
