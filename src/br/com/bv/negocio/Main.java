package br.com.bv.negocio;

import java.util.Scanner;

import br.com.bv.model.Contato;
import br.com.bv.model.jpa.ContatoJPA;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		for (Visitante visitante : new VisitanteDao().listar())
//		{
//			System.out.println("Nome: " + visitante.getNome());
////			System.out.println("Telefone: " + visitante.getTelefone() + "\n");
//		}
		
//		Contato contato = new Contato();
//		contato.setId(1);
//		contato.setNome("Bruno Alcântara");
//		contato.setData(null);
		
//		ClienteJPA c = new ClienteJPA();
//		c.createCliente();
		

		Integer id;
		String nome = "";
		ContatoJPA contatoJPA = new ContatoJPA();
		int op = 0;
		Scanner entrada = new Scanner(System.in);

		do
		{
			Contato contato = new Contato();
			System.out.print("Selecione uma opcao de contato (1-pesquisarOneById 2-listarAllByNome 3-cadastrar 4-alterar 5-remover 0-sair): ");
			op = entrada.nextInt();
			entrada.nextLine();
			System.out.println();
			
			switch(op)
			{
				case 0:
					System.out.println("ENCERRANDO PROGRAMA...\n");
					entrada.close();
					break;
				case 1:
					System.out.println("PESQUISAR CONTATO POR ID\n");
					System.out.print("Nome: ");
					contato = contatoJPA.findOneContatoById(entrada.nextInt()); //entrada.nextLine();
					System.out.print("Resultado->");
					System.out.print(contato.getId() + ": " + contato.getNome());
					break;
				case 2:
					System.out.println("LISTAR CONTATOS POR NOME\n");
					System.out.print("Nome: ");
					System.out.print("Resultado->");
					for (Contato c : contatoJPA.findAllContatoByNome(entrada.nextLine()))
					{
						System.out.println("ID: " + c.getId());
						System.out.println("Nome: " + c.getNome() + "\n");
					}
					break;
				case 3:
					System.out.println("CADASTRAR NOVO CONTATO\n");
					System.out.print("Nome: ");
					contato.setNome(entrada.nextLine());
					System.out.print("Resultado->");
					System.out.print(contatoJPA.saveContato(contato));				
					break;
				case 4:
					System.out.println("ALTERAR CONTATO\n");
					System.out.print("Digite o ID do cliente ao qual se deseja alterar o nome: ");
					id = entrada.nextInt(); //entrada.nextLine();
					contato = contatoJPA.findOneContatoById(id);
					System.out.print("Digite o novo nome: ");
					contato.setNome(entrada.nextLine());
					contatoJPA.updateContato(contato);
					break;
				case 5:
					System.out.println("REMOVER CONTATO\n");
					System.out.print("Digite o ID do cliente ao qual se deseja alterar o remover: ");
					contato = contatoJPA.removeContato(entrada.nextInt()); //entrada.nextLine();
					System.out.println("ID "+contato.getId()+": " + contato.getNome() + " removido com sucesso.");
					break;
				default:
					System.out.println("Opcao invalida.\n");
					break;
			}
			System.out.println();		
		}
		while(op!=0);
		
		System.out.println("Programa encerrado.");
	}

}
