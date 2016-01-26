package de.htw_berlin.ai_bachelor.kbe.checklistkbe8jpa.mb;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.validation.constraints.Min;

import de.htw_berlin.ai_bachelor.kbe.checklistkbe8jpa.model.Interval;

import java.io.Serializable;

@Named
@ApplicationScoped
public class PriorityIntervalMB implements Serializable {

	private final Interval interval;

	public PriorityIntervalMB() {
		interval = new Interval(1, 6);
	}

	public Interval getInterval() {
		return interval;
	}

	public String save() {
		return Pages.editToDoList;
	}

	public String cancel() {
		return Pages.editToDoList;
	}

	public long getMin() {
		return  interval.getMin();
	}

	@Min(value =  1)
	public long getMax() {
		return interval.getMax();
	}

	public void setMax(long max) {
		interval.setMax(max);
	}
}
