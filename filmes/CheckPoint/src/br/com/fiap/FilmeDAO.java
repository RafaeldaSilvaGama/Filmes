
package br.com.fiap;

import java.sql.*;


public class FilmeDAO {
	private Connection con;

	public FilmeDAO(Connection con) {
		setCon(con);
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;

	}

	public String inserir(Filme filme) {
		String sql = "insert into filmes(codigo,titulo,genero,produtora) values (?,?,?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, filme.getCodigo());
			ps.setString(2, filme.getTitulo());
			ps.setString(3, filme.getGenero());
			ps.setString(4, filme.getProdutora());

			if (ps.executeUpdate() > 0) {
				return "Informações inseridas com sucesso.";
			} else {
				return "Erro ao inserir.";
			}

		} catch (SQLException e) {
			return e.getMessage();
		} catch (Exception e) {
			return e.getMessage();
		}

	}

	public String alterar(Filme filme) {
		String sql = "update filmes set titulo = ?, genero = ?, produtora = ? where codigo = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, filme.getTitulo());
			ps.setString(2, filme.getGenero());
			ps.setString(3, filme.getProdutora());
			ps.setString(4, filme.getCodigo());

			if (ps.executeUpdate() > 0) {
				return "Informações alteradas com sucesso";
			} else {
				return "Erro ao alterar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		} catch (Exception e) {
			return e.getMessage();
		}

	}

	public String excluir(Filme filme) {
		String sql = "delete from filmes where codigo = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, filme.getCodigo());

			if (ps.executeUpdate() > 0) {
				return "Excluido com sucesso";
			} else {
				return "Erro ao excluir.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public String listarTodos() {
		String sql = "select * from filmes";
		String listaFilme = "Lista de filmes: \n\n";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					listaFilme += "Codigo: " + rs.getString(1) + "\nTítulo: " + rs.getString(2) + "\nGênero: "
							+ rs.getString(3) + "\nProdutora: " + rs.getString(4) + "\n\n";
				}
				return listaFilme;
			} else {
				return null;
			}
		}

		catch (SQLException e) {
			return null;
		} catch (Exception e) {
			return null;
		}

	}

}
