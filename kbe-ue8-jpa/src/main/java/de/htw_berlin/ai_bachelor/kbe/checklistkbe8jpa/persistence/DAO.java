package de.htw_berlin.ai_bachelor.kbe.checklistkbe8jpa.persistence;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.Closeable;
import java.util.List;

/**
 * Simple generic data access object which helps to persists, update,
 * request entities of a specified type.
 *
 * @param <T> the type of the entity to work with
 */
public class DAO <T> implements Closeable {

	private Class<T> type;
	private EntityManager em;

	/**
	 * Creates a DAO for a specified entity type.
	 *
	 * @param type the specified entity type
     */
	public DAO(Class<T> type) {
		this.type = type;
		em = EMF.createEntityManager();
	}

	/**
	 * Starts a transaction and performs the specified action
	 * inside this transaction.
	 *
	 * The Transaction will be committed automaticly if no exception
	 * appears while the <code>action</code> is
	 * executed otherwise the transaction will be rolled back.
	 *
	 * @param action the action to execute in the transaction
     */
	public void transaction(Runnable action) {
		try {
			em.getTransaction().begin();
			action.run();
			em.flush();
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			ex.printStackTrace();
		}
	}

	/**
	 * Persists the specified object.
	 *
	 * The caller is responsible to perform this method
	 * in a transaction and must ensure that save is only called
	 * for object which are not already persisted.
	 *
	 * @param object the object to persist.
     */
	public void save(T object) {
		em.persist(object);
	}

	/**
	 * Synchronize the local state of object with the database.
	 * The object must be already persisted with the call of save or
	 * EntityManger::persist.
	 *
	 * @param object the object to update.
     */
	public void update(T object) {
		em.merge(object);
		em.flush();
	}

	/**
	 * Synchronize the local state of each object in the specified list with the database.
	 * The objects must be already persisted with the call of save or
	 * EntityManger::persist.
	 *
	 * @param list the list to update.
     */
	public void updateAll(List<T> list) {
		transaction(() -> list.forEach(this::update));
	}

	/**
	 * Request all entities of the type T from the database
	 * and return these as a list.
	 *
	 * @return the requested entities.
     */
	public List<T> findAll() {
		String entityName = getEntityName();
		String queryText = "select t from  " + entityName + " t";
		TypedQuery<T> query = em.createQuery(queryText, type);
		return query.getResultList();
	}

	/**
	 * Returns the entity name of a specified object.
	 *
	 * @return the entity name or null if the specified object isn't a entity.
     */
	public String getEntityName() {
		Entity entity = type.getAnnotation(Entity.class);
		if (entity == null) return null;
		return ("".equals(entity.name())) ? type.getSimpleName() : entity.name();
	}
	
	@Override
	public void close() {
		try {
			em.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}



}
