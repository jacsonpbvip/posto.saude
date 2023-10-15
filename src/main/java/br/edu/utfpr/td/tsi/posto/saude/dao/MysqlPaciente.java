
package br.edu.utfpr.td.tsi.posto.saude.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import br.edu.utfpr.td.tsi.posto.saude.modelo.Paciente;


@Component
public class MysqlPaciente implements PacienteDAO{
	

	
@Autowired
private DataSource datasource;
	
	
	@Override
	public void inserir(Paciente paciente) {
		
		String sql = "insert into Paciente ( nome, sobrenome, telefone, email, cpf) values (?, ?, ?, ?, ?)";
				
		try {
			Connection conn = datasource.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			
			
			preparedStatement.setString(1, paciente.getNome());
			preparedStatement.setString(2, paciente.getSobrenome());
			preparedStatement.setString(3, paciente.getTelefone());
			preparedStatement.setString(4, paciente.getEmail());
			preparedStatement.setString(5, paciente.getCpf());
			preparedStatement.executeUpdate();

			conn.close();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Paciente> listarTodos() {
		ArrayList<Paciente> pacientes = new ArrayList<>();
		try {
			Connection conn = datasource.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select idPaciente, nome, sobrenome, telefone, email, cpf from Paciente");
			while(rs.next()) {
				String id = rs.getString(1);
				String nome = rs.getString(2);
				String sobrenome = rs.getString(3);
				String telefone = rs.getString(4);
				String email = rs.getString(5);
				String cpf = rs.getString(6);
				pacientes.add(new Paciente(id, nome, sobrenome, telefone, email, cpf));
			}
			conn.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return pacientes;
	}	

}

