package br.com.fiap.smartcities.test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.smartcities.entity.Relato;

public class UpdateTest {

	public static void main(String[] args) {
		EntityManager em = null;
		
		try {
			em =  Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();
			em.getTransaction().begin();
				
			
			Relato relatoProcurado = em.find(Relato.class, 1);
			relatoProcurado.setTitulo("Na cidade de São Paulo a Estrada está sem luz!");			
			
	
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
