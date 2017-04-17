package br.com.bv.negocio;

import br.com.bv.model.Visitante;
import br.com.bv.model.VisitanteDao;

// Classe de teste
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (Visitante visitante : new VisitanteDao().listar())
		{
			System.out.println("Nome: " + visitante.getNome());
			System.out.println("Telefone: " + visitante.getTelefone() + "\n");
		}
	}

}
