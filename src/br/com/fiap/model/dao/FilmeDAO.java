/*
 * INTEGRANTES: VINICIUS GONTIJO SANTOS
 * RM: 550657
 * */

package br.com.fiap.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.model.bean.Filme;

public class FilmeDAO {
	private Connection con;
	
	public Connection getCon() {
		return con;
	}
	
	public FilmeDAO(Connection con) {
		this.con = con;
	}

	public String inserir(Filme filme) throws SQLException {
		
		String sql = "insert into tb_ddd_filmes (codigo, titulo, genero, produtora) values (?,?,?,?)";
		
		PreparedStatement ps = getCon().prepareStatement(sql);
		
		ps.setString(1, filme.getCodigo());
		ps.setString(2, filme.getTitulo());
		ps.setString(3, filme.getGenero());
		ps.setString(4, filme.getProdutora());
		
		if (ps.executeUpdate() > 0) {
			return "Filme inserido com sucesso";
		}
		return "Erro ao inserir filme";
	}
	
	public String alterar(Filme filme) throws SQLException {
		
		String sql = "update tb_ddd_filmes set titulo =?, set genero=?, set produtora=? where codigo=?";
		
		PreparedStatement ps = getCon().prepareStatement(sql);
		
		ps.setString(1, filme.getTitulo());
		ps.setString(2, filme.getGenero());
		ps.setString(3, filme.getProdutora());
		ps.setString(4, filme.getCodigo());
		
		if (ps.executeUpdate() > 0) {
			return "Filme alterado com sucesso";
		}
		return "Erro ao alterar filme";
	}
	public String excluir(Filme filme) throws SQLException {
		
		String sql = "delete from tb_ddd_filmes where codigo=?";
		
		PreparedStatement ps = getCon().prepareStatement(sql);
		
		ps.setString(1, filme.getCodigo());
		
		if (ps.executeUpdate() > 0) {
			return "Filme excluido com sucesso";
		}		
		return "Erro ao excluir filme";
	}
	
	public ArrayList<Filme> listarTodos() throws SQLException{
		String sql = "select * from tb_ddd_filmes";
		ArrayList<Filme> listaFilme = new ArrayList<Filme>();
		PreparedStatement ps = getCon().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if (rs != null) {
			while (rs.next()) {
				Filme filme = new Filme();
				filme.setCodigo(rs.getString(1));
				filme.setTitulo(rs.getString(2));
				filme.setGenero(rs.getString(3));
				filme.setProdutora(rs.getString(4));
				listaFilme.add(filme);
			}
			return listaFilme;
		}
		return null;
	}
}
