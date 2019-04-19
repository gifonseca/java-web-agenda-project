package com.agenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.agenda.modelos.Pessoas;
import com.agenda.util.ConnectionFactory;

public class PessoaDao {

	private Connection connection;

	public void cadastraDAO(Pessoas pessoa) {

		String SQL = "insert into pessoas (nome, email, telefone, endereco) values (?, ?, ?, ?)";

		try {
			this.connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = this.connection.prepareStatement(SQL);

			stmt.setString(1, pessoa.getNome());
			stmt.setString(2, pessoa.getEmail());
			stmt.setString(3, pessoa.getTelefone());
			stmt.setString(4, pessoa.getEndereco());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public List<Pessoas> buscarPessoas() {

		String SQL = "select * from pessoas";
		
		try {
			
			this.connection = new ConnectionFactory().getConnection();
		    PreparedStatement stmt = this.connection.prepareStatement(SQL);

		    List<Pessoas> pessoas = new ArrayList<Pessoas>();
		    
		    ResultSet rs = stmt.executeQuery();

		    while (rs.next()) {
		    	Pessoas pessoa = new Pessoas();
		    	pessoa.setNome(rs.getString("nome"));
		    	pessoa.setEmail(rs.getString("email"));
		    	pessoa.setEndereco(rs.getString("endereco"));
		    	pessoa.setTelefone(rs.getString("telefone"));
		    	pessoas.add(pessoa);
		    }

		    stmt.close();
		    this.connection.close();
		    return pessoas;
		    
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
