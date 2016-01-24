package de.htw_berlin.ai_bachelor.kbe.checklistkbe8.model;


import de.htw_berlin.ai_bachelor.kbe.checklistkbe8.validation.MyInterval;

import javax.validation.constraints.Future;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class ToDo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private boolean done = false;

	@MyInterval(interval = "priorityIntervalMB.interval")
	private long priority;

	@Future()
	private Date dueDate;

	private ToDo(String name, boolean done) {
		this.name = name;
		this.done = done;
		this.priority = 1;
		this.dueDate = Date.from(
			LocalDate.now()
				.atStartOfDay(ZoneId.systemDefault())
				.plusDays(2)
				.toInstant()
		);
	}

	public ToDo(String name) {
		this(name, false);
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date date) {
		dueDate = date;
	}

	public long getPriority() {
		return priority;
	}

	public void setPriority(long priority) {
		this.priority = priority;
	}
}
