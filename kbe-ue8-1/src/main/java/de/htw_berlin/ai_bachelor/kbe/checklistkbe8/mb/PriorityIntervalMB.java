package de.htw_berlin.ai_bachelor.kbe.checklistkbe8.mb;

import de.htw_berlin.ai_bachelor.kbe.checklistkbe8.model.Interval;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.validation.constraints.Min;

@ApplicationScoped
@ManagedBean
public class PriorityIntervalMB {

	private final Interval interval;

	public PriorityIntervalMB() {
		interval = new Interval(1, 6);
	}

	public Interval getInterval() {
		return interval;
	}

	public String save() {
		return "editToDoList";
	}

	public String cancel() {
		return "editToDoList";
	}

	public int getMin() {
		return  interval.getMin();
	}

	@Min(value = 1)
	public int getMax() {
		return interval.getMax();
	}

	public void setMax(int max) {
		interval.setMax(max);
	}
}
