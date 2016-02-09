package de.htw_berlin.ai_bachelor.kbe.checklistkbe8jpa.mb;

import de.htw_berlin.ai_bachelor.kbe.checklistkbe8jpa.model.ToDo;
import de.htw_berlin.ai_bachelor.kbe.checklistkbe8jpa.model.ToDoList;
import de.htw_berlin.ai_bachelor.kbe.checklistkbe8jpa.persistence.DAO;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;


@Named
@SessionScoped
public class ToDoListMB implements Serializable {

	private static final long serialVersionUID = 1L;
    private final ToDoList toDoList;

	public ToDoListMB() {
		toDoList = new ToDoList();
	}    

	public ToDoList getToDoList() {
		try(DAO<ToDo> toDoDAO = new DAO<>(ToDo.class)) {
			toDoList.setList(toDoDAO.findAll());
		}
		return toDoList;
	}

    public String save() {
		try(DAO<ToDo> toDoDAO = new DAO<>(ToDo.class)) {
			toDoDAO.updateAll(toDoList.getToDos());
		}
		return "save";
    }

	public String cancel() {
		return "cancel";
	}
}
