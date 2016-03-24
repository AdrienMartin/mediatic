package mediatic.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseHelper {

	private static EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("unit");

	public static EntityManager createEntityManager() {
		return entityManagerFactory.createEntityManager();

	}

	 public static void commitTxAndClose(EntityManager entityManager) {
	
		 entityManager.getTransaction().commit();
		
		 entityManager.close();
	
	 }
	
	 public static void beginTx(EntityManager entityManager) {
	
		 entityManager.getTransaction().begin();
	
	 }

}