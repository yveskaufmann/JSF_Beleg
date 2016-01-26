package de.htw_berlin.ai_bachelor.kbe.checklistkbe8jpa.mb;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import de.htw_berlin.ai_bachelor.kbe.checklistkbe8jpa.model.ToDo;

@Named(value = "toDoMB")
@RequestScoped
public class ToDoMB implements Serializable {
	
	private static final long serialVersionUID = -2147527261649492388L;
	
	//@Inject
	//private PriorityIntervalMB intervalMB;
	private ToDo template;
	
	public ToDoMB() {
		template = new ToDo("", false, 1);
	}
	
	public ToDo getTodo() {
		return template;
	}

	public String save() {
		return Pages.editToDoList;
	}

	public String cancel() {
		return Pages.editToDoList;
	}
}
