package de.htw_berlin.ai_bachelor.kbe.checklistkbe8jpa.mb;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;

import javax.inject.Named;

import de.htw_berlin.ai_bachelor.kbe.checklistkbe8jpa.model.ToDo;
import de.htw_berlin.ai_bachelor.kbe.checklistkbe8jpa.persistence.DAO;

@Named
@RequestScoped
public class ToDoMB implements Serializable {

	private static final long serialVersionUID = -2147527261649492388L;
	private ToDo template;

	public ToDoMB() {
		template = new ToDo("", false, 1);
	}
	
	public ToDo getTodo() {
		return template;
	}

	public String save() {
		try(DAO<ToDo> dao = new DAO<>(ToDo.class)) {
			dao.transaction(() -> {
				dao.save(template);
			});
		}
		return Pages.editToDoList;
	}

	public String cancel() {
		return Pages.editToDoList;
	}
}
