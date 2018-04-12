package br.com.bv.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.bv.model.Cliente;


public class ClienteController {
	
	public void createCliente() {
		Cliente contato = new Cliente();
		contato.setNome("Bruno Vitalino");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("db_sqlserver");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		// Cliente sera adicionado ao db
		em.persist(contato);
		em.getTransaction().commit();
		
		System.err.println("ID: " + contato.getId() + " adicionado.");
		
		em.close();
		emf.close();
	}

}
