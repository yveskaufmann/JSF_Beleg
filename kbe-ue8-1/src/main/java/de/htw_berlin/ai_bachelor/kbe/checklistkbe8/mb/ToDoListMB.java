package de.htw_berlin.ai_bachelor.kbe.checklistkbe8.mb;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import de.htw_berlin.ai_bachelor.kbe.checklistkbe8.model.ToDoList;

@SessionScoped
@ManagedBean
public class ToDoListMB implements Serializable {

	private static final long serialVersionUID = 1L;
    private final ToDoList toDoList;
    
	public ToDoListMB() {
		toDoList = new ToDoList();
	}    

	public ToDoList getToDoList() {
		return toDoList;
	}

    public String save() {
    	return "save";
    }

	public String cancel() {
		return "cancel";
	}

	public String editPriority() {
		return "editPriority";
	}
}
