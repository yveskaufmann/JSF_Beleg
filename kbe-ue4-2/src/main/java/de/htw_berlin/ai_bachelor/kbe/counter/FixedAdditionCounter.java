package de.htw_berlin.ai_bachelor.kbe.counter;

public abstract class FixedAdditionCounter implements Counter {
	
	protected final int addition;
	protected int count;
	
	protected FixedAdditionCounter(int initialeValue, int addition) {
		this.addition = addition;
		this.count = initialeValue;
	}
	
	@Override
	public Counter increment() {
		this.count += addition;
		return this;
	}

	@Override
	public int getCount() {
		return this.count;
	}

}
