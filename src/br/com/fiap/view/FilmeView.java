/*
 * INTEGRANTES: VINICIUS GONTIJO SANTOS
 * RM: 550657
 * */

package br.com.fiap.view;

import javax.swing.JOptionPane;

import br.com.fiap.controller.FilmeController;

public class FilmeView {
	public static void main(String[] args) {
		String aux;
		String escolha ="sim"; 
		String codigoFilme;
		String tituloFilme = null;
		String generoFilme = null;
		String produtoraFilme = null;
		
		int key;
		FilmeController filme = new FilmeController();
		while (escolha.equalsIgnoreCase("sim")) {
			try {
			
				aux = JOptionPane.showInputDialog(
						"Opções (digite o número):"
						+ "\n[1]-Inserir filme"
						+ "\n[2]-Alterar filme"
						+ "\n[3]-Excluir filme");
				key = Integer.parseInt(aux);
				
				codigoFilme = JOptionPane.showInputDialog("Digite o código do filme");
				
				if (key == 1 || key == 2) {
					tituloFilme = JOptionPane.showInputDialog("Digite o título do filme");
					generoFilme = JOptionPane.showInputDialog("Digite o gênero do filme");
					produtoraFilme = JOptionPane.showInputDialog("Digite o produtora do filme");
				}
				
				switch (key) {
				case 1:
					JOptionPane.showMessageDialog(null, filme.insereFilme(codigoFilme, tituloFilme, generoFilme, produtoraFilme));
					break;
				case 2:
					JOptionPane.showMessageDialog(null, filme.alteraFilme(codigoFilme, tituloFilme, generoFilme, produtoraFilme));
					break;
				case 3:
					JOptionPane.showMessageDialog(null, filme.excluiFilme(codigoFilme));									
					break;
				default:
					throw new Exception("Opcao invalida");
				}
				JOptionPane.showMessageDialog(null, filme.listaTodosFilmes());
				escolha = JOptionPane.showInputDialog("Deseja refazer a operação?");
			} catch (Exception e) {
				System.out.println(e.getMessage());
				break;
			}
		}
	}
}
