package br.com.bv.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GerarTabelas {

	public static void main(String[] args)
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("contatos");
		
		factory.close();
	}

}
