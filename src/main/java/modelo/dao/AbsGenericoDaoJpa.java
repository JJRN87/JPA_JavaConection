package modelo.dao;

import java.beans.PersistenceDelegate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public abstract class AbsGenericoDaoJpa {
	
	protected EntityManagerFactory emf;
	protected EntityManager em;
	protected EntityTransaction tx;
	protected Query query;
	protected String jpql;
	protected int filas;
	
	public AbsGenericoDaoJpa() {
		emf = Persistence.createEntityManagerFactory("MY_JPA_HR");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}
}
