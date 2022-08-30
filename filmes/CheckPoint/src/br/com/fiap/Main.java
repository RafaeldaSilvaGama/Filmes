
package br.com.fiap;

import java.sql.*;


import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		Connection con = Conexao.abrirConexao();
		Filme fil = new Filme();
		FilmeDAO fd = new FilmeDAO(con);

		
		
		JOptionPane.showMessageDialog(null, "Bem vindo ao cadastro de filmes DDD");
		int opcao;
		do {
			String aux = JOptionPane.showInputDialog(
					"Menu \n (1)Inserir um filme ao banco de dados. \n(2)Alterar informações de um filme já cadastrado. \n(3)Excluir um filme.");
			opcao = Integer.parseInt(aux);
			switch (opcao) {
			case 1: {
				fil.setCodigo(JOptionPane.showInputDialog("Digite o código do filme"));
				fil.setTitulo(JOptionPane.showInputDialog("Digite o título do filme"));
				fil.setGenero(JOptionPane.showInputDialog("Digite o gênero do filme"));
				fil.setProdutora(JOptionPane.showInputDialog("Digite a produtora do filme"));
				System.out.println(fd.inserir(fil));
				break;
			}
			case 2: {
				fil.setCodigo(JOptionPane.showInputDialog("Digite o código do filme"));
				fil.setTitulo(JOptionPane.showInputDialog("Digite o novo título do filme"));
				fil.setGenero(JOptionPane.showInputDialog("Digite o novo gênero do filme"));
				fil.setProdutora(JOptionPane.showInputDialog("Digite a nova produtora do filme"));
				System.out.println(fd.alterar(fil));
				break;
			}
			case 3: {
				fil.setCodigo(JOptionPane.showInputDialog("Digite o código do filme que deseja excluir"));
				System.out.println(fd.excluir(fil));
				break;
			}
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida");
				break;

			}
			JOptionPane.showMessageDialog(null, fd.listarTodos());
			aux = JOptionPane.showInputDialog("Gostaria de voltar ao menu inicial ou encerrar o programa? "
					+ "\n(1)Retornar ao menu inicial. \nQualquer outro para encerrar o programa.");
			opcao = Integer.parseInt(aux);
		} while (opcao == 1);
		JOptionPane.showMessageDialog(null, "Programa encerrado, até breve!");
		Conexao.fecharConexao(con);

	}

}
