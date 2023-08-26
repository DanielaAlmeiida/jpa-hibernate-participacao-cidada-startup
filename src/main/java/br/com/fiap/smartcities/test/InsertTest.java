package br.com.fiap.smartcities.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.smartcities.entity.CategoriaRelato;
import br.com.fiap.smartcities.entity.Comentario;
import br.com.fiap.smartcities.entity.GovernoLocal;
import br.com.fiap.smartcities.entity.Relato;
import br.com.fiap.smartcities.entity.StatusRelato;
import br.com.fiap.smartcities.entity.Usuario;

public class InsertTest {

	public static void main(String[] args) {
		EntityManager em = null;
		
		try {
			em =  Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();
			em.getTransaction().begin();
			
			
			Usuario usuario1 = new Usuario();
			usuario1.setNome("Daniela");		
			em.persist(usuario1);
			
			GovernoLocal governo1 = new GovernoLocal();
			governo1.setNome("Departamento Social");		
			em.persist(governo1);
			
			
			Relato relato1 = new Relato();
			relato1.setTitulo("Estrada sem luz");
			relato1.setUsuario(usuario1);
			em.persist(relato1);
			
			Relato relato2 = new Relato();
			relato2.setTitulo("Avenida com buracos");
			relato2.setUsuario(governo1);
			em.persist(relato2);
			
			
			StatusRelato status1 = new StatusRelato();
			status1.setNome("Em andamento");
			em.persist(status1);
			
			StatusRelato status2 = new StatusRelato();
			status2.setNome("Concluído");
			em.persist(status2);
			
			relato1.setStatus(status1);
			relato2.setStatus(status2);
			
			
			CategoriaRelato categoria1 = new CategoriaRelato();
			categoria1.setTitulo("Rua/Estradas/Avenidas");
			em.persist(categoria1);
			
			relato1.setCategoria(categoria1);
			relato2.setCategoria(categoria1);
			
			
			Comentario comentario1 = new Comentario();
			comentario1.setDescricaoComentario("Não há nenhum poste de luz na Estrada X");
			comentario1.setUsuario(usuario1);
			comentario1.setRelato(relato1);
			em.persist(comentario1);
			
			
			Comentario comentario2 = new Comentario();
			comentario2.setDescricaoComentario("Nós, do governo, iremos trabalhar para resolver isso.");
			comentario2.setUsuario(governo1);
			comentario2.setRelato(relato2);
			em.persist(comentario2);
			
			
			List<Comentario> comentarios = new ArrayList<>();
			comentarios.add(comentario1);
			comentarios.add(comentario2);
			
			relato1.setComentarios(comentarios);
			
	
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
