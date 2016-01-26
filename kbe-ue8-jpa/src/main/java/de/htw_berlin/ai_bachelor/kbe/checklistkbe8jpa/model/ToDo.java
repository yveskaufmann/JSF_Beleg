package de.htw_berlin.ai_bachelor.kbe.checklistkbe8jpa.model;


import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import de.htw_berlin.ai_bachelor.kbe.checklistkbe8jpa.validation.MyInterval;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class ToDo implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	private String name;

	@NotNull
	@MyInterval(interval = "priorityIntervalMB.interval")
	private long priority;

	@NotNull
	@Future()
	private Date dueDate;

	private boolean done;
	public ToDo(String name, boolean done, long priority) {
		this.name = name;
		this.done = done;
		this.priority = priority;
		this.dueDate = Date.from(
			LocalDate.now()
				.atStartOfDay(ZoneId.systemDefault())
				.plusDays(2)
				.toInstant()
		);
	}

	public ToDo(String name) {
		this(name, false, 1);
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
