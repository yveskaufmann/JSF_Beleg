package de.htw_berlin.ai_bachelor.kbe.checklistkbe8jpa.mb;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.validation.constraints.Min;

import de.htw_berlin.ai_bachelor.kbe.checklistkbe8jpa.model.Interval;

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
