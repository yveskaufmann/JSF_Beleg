package de.htw_berlin.ai_bachelor.kbe.counter;

public abstract class FixedMultipyCounter implements Counter {

	private final FixedAdditionCounter counter;
	
	protected FixedMultipyCounter(int multiplicator) {
		counter = new FixedAdditionCounter(1, multiplicator) {
			public Counter increment() {
				this.count *= addition;
				return this;
			};
		};
	}

	@Override
	public Counter increment() {
		return this.counter.increment();
	}
	
	@Override
	public int getCount() {
		return this.counter.getCount();
	}

}
