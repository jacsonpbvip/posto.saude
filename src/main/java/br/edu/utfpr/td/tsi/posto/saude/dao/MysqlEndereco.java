package br.edu.utfpr.td.tsi.posto.saude.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.posto.saude.modelo.Endereco;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Paciente;

@Component
public class MysqlEndereco implements EnderecoDAO {

	@Autowired
	DataSource datasource;

	@Override
	public void inserir(Endereco endereco, Paciente paciente) {

		String sql = "INSERT INTO Endereco (logradouro, numero, cep, bairro_idbairro) values (?, ?, ?, ?)";

		try {
			Connection conn = datasource.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, endereco.getLogradouro());
			preparedStatement.setString(2, endereco.getNumero());
			preparedStatement.setString(3, endereco.getCep());
			preparedStatement.setString(4, endereco.getBairro().getId());
			/*
			 * preparedStatement.setString(5, paciente.getId());
			 */
			preparedStatement.executeUpdate();

			conn.close();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
