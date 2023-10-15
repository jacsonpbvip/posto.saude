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
public class MySqlConsulta implements ConsultaDAO {

	@Autowired
	private DataSource datasource;

	private boolean pacienteJaPossuiConsultaAgendada(String idPaciente) {
		try {
			Connection conn = datasource.getConnection();

			String sql = "SELECT COUNT(*) FROM Consulta WHERE Paciente_idPaciente = ? AND Status = 'Agendada'";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, idPaciente);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next() && resultSet.getInt(1) > 0) {
				conn.close();
				preparedStatement.close();
				
				return true;
			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		return false;
	}

	@Override
	public void inserir(Consulta consulta) {

		
		if (!pacienteJaPossuiConsultaAgendada(consulta.getIdPaciente())) {
			String sql = "insert into Consulta (data_hora, Status, Paciente_idPaciente, Medicos_idMedicos) values (?, ?, ?, ?)";

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
	@Override
public List<Consulta> listarTodos() {
    List<Consulta> consultas = new ArrayList<>();
    try {
        Connection conn = datasource.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT data_hora, Status, Paciente_idPaciente, Medicos_idMedicos FROM Consulta");
        while (rs.next()) {
            Consulta consulta = new Consulta(); // Crie uma nova instância de Consulta

            // Configure a instância Consulta com os dados do banco de dados
            consulta.setData(rs.getTimestamp("data_hora").toLocalDateTime());
            consulta.setStatus(rs.getString("Status"));
            consulta.setIdPaciente(rs.getString("Paciente_idPaciente"));
            consulta.setIdMedicos(rs.getString("Medicos_idMedicos"));

            consultas.add(consulta);
        }
        conn.close();
        stmt.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return consultas;
}

}
