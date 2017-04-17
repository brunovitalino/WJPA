package br.com.bv.jpa;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.bv.model.Contato;

public class AdicionarContato {

	public static void main(String[] args)
	{
		
		Contato contato = new Contato();
		contato.setNome("Bruno Vitalino");
		contato.setData(Calendar.getInstance());
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contatos");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		// Contato sera adicionado ao db
		em.persist(contato);
		em.getTransaction().commit();
		
		System.out.println("ID: " + contato.getId());
		
		em.close();
		emf.close();

	}

}
