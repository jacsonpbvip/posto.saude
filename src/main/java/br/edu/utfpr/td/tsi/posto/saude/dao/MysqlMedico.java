package br.edu.utfpr.td.tsi.posto.saude.dao;
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


import br.edu.utfpr.td.tsi.posto.saude.modelo.Especialidade;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Medicos;



@Component
public class MysqlMedico implements MedicoDAO{

	
@Autowired
private DataSource datasource;
@Autowired
private EspecialidadeDAO especialidadeDAO;

	
	@Override
	public void inserir(Medicos medico) {
		
		String sql = "insert into Medicos (nome, sobrenome, cpf, telefone, crm , Especialidade_idEspecialidade) values ( ?, ?, ?, ?, ?, ?)";

		try {
			Connection conn = datasource.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			
			
			preparedStatement.setString(1, medico.getNome());
			preparedStatement.setString(2, medico.getSobrenome());
			preparedStatement.setString(3, medico.getCpf());
			preparedStatement.setString(4, medico.getTelefone());
			preparedStatement.setString(5, medico.getCrm());			
			preparedStatement.setString(6, medico.getEspecialidade().getIdEspecialidade());
			preparedStatement.executeUpdate();

			conn.close();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	
	@Override
	public List<Medicos> listarTodos() {
		ArrayList<Medicos> medicos = new ArrayList<>();
		try {
			Connection conn = datasource.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select idMedicos, nome, sobrenome, cpf, telefone, crm, Especialidade_idEspecialidade from Medicos");
			while(rs.next()) {
				String id = rs.getString(1);
				String nome = rs.getString(2);
				String sobrenome = rs.getString(3);
				String cpf = rs.getString(4);
				String telefone = rs.getString(5);
				String crm = rs.getString(6);
				String idEspecialidade = rs.getString(7);
					
				medicos.add(new Medicos(id, nome, sobrenome, cpf, telefone, crm, idEspecialidade));
			}
			conn.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return medicos;
	}

	


	
}
