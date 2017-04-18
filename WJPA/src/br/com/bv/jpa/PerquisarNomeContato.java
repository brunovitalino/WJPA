package br.com.bv.jpa;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.bv.model.Contato;

public class PerquisarNomeContato {

	public static void main(String[] args)
	{
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contatos");
		EntityManager em = emf.createEntityManager();
		String comandoJPQL = "";
		List<Contato> contatos;
		
		comandoJPQL =	"SELECT c FROM Contato AS c " +
						"WHERE c.nome LIKE :paramNome";
		
		Query q = em.createQuery(comandoJPQL);
		q.setParameter("paramNome", "Bru%");
		contatos = q.getResultList();
		
		/*
		 * Forma mais direta:
		 * 
		 comandoJPQL =	"SELECT c FROM Contato AS c " +
		 				"WHERE c.nome LIKE 'Bru%'";
		 				
		 contatos = em.createQuery(comandoJPQL).getResultList();
		 *
		 */
		
		for (Contato contato : contatos)
		{
			System.out.println("ID: " + contato.getId());
			System.out.println("Nome: " + contato.getNome() + "\n");
		}
		
		em.close();
		emf.close();
		
	}

}
