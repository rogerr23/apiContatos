package br.com.cotiinformatica.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.cotiinformatica.entities.Contato;
import br.com.cotiinformatica.factories.ConnectionFactory;

public class ContatoRepository {

	public void create(Contato contato) throws Exception {

		String query = "INSERT INTO contato(nome, email, telefone) VALUES(?,?,?)";

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, contato.getNome());
		statement.setString(2, contato.getEmail());
		statement.setString(3, contato.getTelefone());
		statement.execute();

		ResultSet resultSet = statement.getGeneratedKeys();
		if (resultSet.next()) {
			contato.setId(resultSet.getInt(1));

		}

		connection.close();
	}

	public void update(Contato contato) throws Exception {

		String query = "UPDATE contato SET nome=?, email=?, telefone=? WHERE id=?";

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, contato.getNome());
		statement.setString(2, contato.getEmail());
		statement.setString(3, contato.getTelefone());
		statement.setInt(4, contato.getId());
		statement.execute();

		connection.close();
	}

	public void delete(Integer id) throws Exception {

		String query = "DELETE FROM contato WHERE id=?";

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, id);
		statement.execute();

		connection.close();

	}

	public List<Contato> findAll() throws Exception {
		String query = "SELECT id, nome, email, telefone FROM contato";

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement(query);

		ResultSet resultSet = statement.executeQuery();

		List<Contato> contatos = new ArrayList<>();

		while (resultSet.next()) {
			Contato contato = new Contato();
			contato.setId(resultSet.getInt("id"));
			contato.setNome(resultSet.getString("nome"));
			contato.setEmail(resultSet.getString("email"));
			contato.setTelefone(resultSet.getString("telefone"));
			contatos.add(contato);
		}

		resultSet.close();
		connection.close();

		return contatos;
	}

	public Contato findById(Integer id) throws Exception {
		String query = "SELECT id, nome, email, telefone FROM contato WHERE id=? ";

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, id);

		ResultSet resultSet = statement.executeQuery();

		Contato contato = null;
		if (resultSet.next()) {
			contato = new Contato();
			contato.setId(resultSet.getInt("id"));
			contato.setNome(resultSet.getString("nome"));
			contato.setEmail(resultSet.getString("email"));
			contato.setTelefone(resultSet.getString("telefone"));
		}

		resultSet.close();
		connection.close();

		return contato;
	}

}
