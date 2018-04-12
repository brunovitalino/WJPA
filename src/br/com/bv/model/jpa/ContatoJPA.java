package br.com.bv.model.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.bv.model.Contato;


public class ContatoJPA {
	
	EntityManagerFactory emf;
	
	public ContatoJPA()
	{
		this.emf = Persistence.createEntityManagerFactory("db_sqlserver");
		System.out.println("Database conectado!\n");
	}
	
	//Metodo usado pela camada de controle para fechamento de conexao
	public void close()
	{
		this.emf.close();
		System.out.println("Database desconectado.\n");
	}
	
	public String saveContato(Contato c) {
		
		EntityManager em = this.emf.createEntityManager();
		
		em.getTransaction().begin();
		// Cliente sera adicionado ao db
		em.persist(c);
		em.getTransaction().commit();
		
		em.close();
		
		return ("ID "+c.getId()+": " + c.getNome() + " adicionado com sucesso.");
	}
	
	public Contato findOneContatoById(Integer id) {
		EntityManager em = this.emf.createEntityManager();
		
		em.getTransaction().begin();
		// Contato sera pesquisado pelo id
		Contato contato = em.find(Contato.class, id);
		
		em.close();
		
		return contato;
	}
	
	public List<Contato> findAllContatoByNome(String nome) {
		EntityManager em = this.emf.createEntityManager();
		String comandoJPQL = "";
		List<Contato> contatos;
		
		comandoJPQL =	"SELECT c FROM Contato AS c " +
						"WHERE c.nome LIKE :paramNome";
		
		Query q = em.createQuery(comandoJPQL);
		nome = "%" + nome + "%";
		q.setParameter("paramNome", nome);
		contatos = q.getResultList();
		
		/*
		 * Forma mais direta:
		 * 
		 comandoJPQL =	"SELECT c FROM Contato AS c " +
		 				"WHERE c.nome LIKE 'Bru%'";
		 				
		 contatos = em.createQuery(comandoJPQL).getResultList();
		 *
		 */
		
		em.close();
		
		return contatos;
	}
	
	public void updateContato(Contato c) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.merge(c);
		em.getTransaction().commit();
		
		em.close();
	}
	
	public Contato removeContato(Integer id) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		// Contato sera removido pelo id
		Contato contato = em.find(Contato.class, id);
		em.remove(contato);
		em.getTransaction().commit();
		
		em.close();

		return (contato);
	}

}
