package de.htw_berlin.ai_bachelor.kbe.checklistkbe8jpa.mb;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;

import javax.inject.Named;
import javax.persistence.*;

import de.htw_berlin.ai_bachelor.kbe.checklistkbe8jpa.model.ToDo;
import de.htw_berlin.ai_bachelor.kbe.checklistkbe8jpa.persistence.EMF;

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
		EntityManager em = EMF.createEntityManager();
		em.getTransaction().begin();
		em.persist(template);
		em.getTransaction().commit();
		em.close();
		return Pages.editToDoList;
	}

	public String cancel() {
		return Pages.editToDoList;
	}
}
