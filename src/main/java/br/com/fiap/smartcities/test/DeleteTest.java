package br.com.fiap.smartcities.test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.smartcities.entity.Relato;

public class DeleteTest {

	public static void main(String[] args) {
		EntityManager em = null;
		
		try {
			em =  Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();
			em.getTransaction().begin();
				
			
			Relato relatoProcurado = em.find(Relato.class, 1);
			em.remove(relatoProcurado);
			
	
			em.getTransaction().commit();
		
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		} finally {
			em.close();
		}

	}

}
