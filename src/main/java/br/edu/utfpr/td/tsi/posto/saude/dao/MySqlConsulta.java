package br.edu.utfpr.td.tsi.posto.saude.dao;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.posto.saude.modelo.Consulta;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Especialidade;

@Component
public class MySqlConsulta  implements ConsultaDAO{
	
	@Autowired
	private DataSource datasource;

	@Override
	public void inserir(Consulta consulta) {		
		String sql = "insert into  Consulta  (data_hora, Status, Paciente_idPaciente, Medicos_idMedicos) values (?, ?, ?, ?)";
		
		
		try {
			Connection conn = datasource.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);	
			
			Timestamp timestamp = Timestamp.valueOf(consulta.getData());
			preparedStatement.setTimestamp(1, timestamp);
			preparedStatement.setString(2, "Agendada");
			preparedStatement.setString(3, consulta.getIdPaciente());
			preparedStatement.setString(4, consulta.getIdMedicos());
			
			preparedStatement.executeUpdate();

			conn.close();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
