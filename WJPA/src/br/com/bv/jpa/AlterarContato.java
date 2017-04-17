package br.com.bv.jpa;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.bv.model.Contato;

public class AlterarContato {

	public static void main(String[] args)
	{
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contatos");
		EntityManager em = emf.createEntityManager();
		
		Contato contato = new Contato();
		contato.setId(1);
		contato.setNome("Bruno Alcântara");
		contato.setData(null);
		
		em.getTransaction().begin();
		em.merge(contato);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

}
