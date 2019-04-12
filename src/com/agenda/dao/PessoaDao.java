package com.agenda.dao;

import java.sql.Connection;
import java.sql.SQLException;
import com.agenda.modelos.Pessoas;
import com.agenda.util.ConnectionFactory;
import java.sql.PreparedStatement;

public class PessoaDao {

	private Connection connection;

	public void cadastraDAO(Pessoas pessoa) {

		String SQL = "insert into testandobd (nome, senha, email, telefone, endereco) values (?, ?, ?, ?, ?)";

		try {
			this.connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = this.connection.prepareStatement(SQL);

			stmt.setString(1, pessoa.getNome());
			stmt.setString(2, pessoa.getSenha());
			stmt.setString(3, pessoa.getEmail());
			stmt.setString(4, pessoa.getTelefone());
			stmt.setString(5, pessoa.getEndereco());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
