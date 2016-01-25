package de.htw_berlin.ai_bachelor.kbe.checklistkbe8jpa.mb;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import de.htw_berlin.ai_bachelor.kbe.checklistkbe8jpa.model.ToDo;

@ViewScoped
@ManagedBean
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
	
	public String create() {
		return "editToDo";
	}
	
	public String submit() {
		return Pages.editToDoList;
	}
}
