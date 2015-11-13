package de.htw_berlin.ai_bachelor.kbe.checklist.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import de.htw_berlin.ai_bachelor.kbe.checklist.model.ToDo;
import de.htw_berlin.ai_bachelor.kbe.checklist.model.ToDoList;

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
}
