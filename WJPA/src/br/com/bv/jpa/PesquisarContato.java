package br.com.bv.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.bv.model.Contato;

public class PesquisarContato {

	public static void main(String[] args)
	{
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contatos");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		Contato contato = em.find(Contato.class, 1);
		System.out.println("Nome do contato: " + contato.getNome());
		
		em.close();

	}

}
