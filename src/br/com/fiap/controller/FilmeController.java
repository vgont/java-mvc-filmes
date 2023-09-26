/*
 * INTEGRANTES: VINICIUS GONTIJO SANTOS
 * RM: 550657
 * */

package br.com.fiap.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.model.bean.Filme;
import br.com.fiap.model.dao.Conexao;
import br.com.fiap.model.dao.FilmeDAO;

public class FilmeController {
	
	public String insereFilme(String codigo, String titulo, String genero, String produtora) throws ClassNotFoundException, SQLException {
		String resul;
		Connection con = Conexao.abrirConexao();
		FilmeDAO filmeDao = new FilmeDAO(con);
		Filme filme = new Filme();
		
		filme.setCodigo(codigo);
		filme.setTitulo(titulo);
		filme.setGenero(genero);
		filme.setProdutora(produtora);

		resul = filmeDao.inserir(filme);
		
		Conexao.fecharConexao(con);
		return resul;
	}
	
	public String alteraFilme(String codigo, String titulo, String genero, String produtora) throws ClassNotFoundException, SQLException {
		String resul;
		Connection con = Conexao.abrirConexao();
		FilmeDAO filmeDao = new FilmeDAO(con);
		Filme filme = new Filme();
		
		filme.setCodigo(codigo);
		filme.setTitulo(titulo);
		filme.setGenero(genero);
		filme.setProdutora(produtora);

		resul = filmeDao.alterar(filme);
		
		Conexao.fecharConexao(con);
		return resul;
	}
	
	public String excluiFilme(String codigo) throws ClassNotFoundException, SQLException {
		String resul;
		Connection con = Conexao.abrirConexao();
		FilmeDAO filmeDao = new FilmeDAO(con);
		Filme filme = new Filme();
		
		filme.setCodigo(codigo);						

		resul = filmeDao.excluir(filme);
		
		Conexao.fecharConexao(con);
		return resul;
	}
	
	public String listaTodosFilmes() throws ClassNotFoundException, SQLException {
		ArrayList<Filme> listaFilmes;
		String resul="";
		int index = 1;
		Connection con = Conexao.abrirConexao();
		FilmeDAO FilmeDao = new FilmeDAO(con);
		
		listaFilmes = FilmeDao.listarTodos();
		
		for (Filme filme : listaFilmes) {
			resul += index+"º Filme: \n"
					+ "Código do Filme: " +filme.getCodigo() + "\n"
					+ "Título do Filme: " + filme.getTitulo() + "\n"
					+ "Gênero do Filme: " + filme.getGenero() + "\n"
					+ "Produtora do Filme: " + filme.getProdutora() + "\n"
					+"----------------------------------\n";
			index++;
		}
		
		if(resul=="") {
			return "Não possui filmes cadastrados";
		}
		
		return resul;
	}
}	
