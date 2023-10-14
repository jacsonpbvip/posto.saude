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

import br.edu.utfpr.td.tsi.posto.saude.modelo.Bairro;

@Component
public class MysqlBairro implements BairroDAO {
	@Autowired
	DataSource datasource;
	
	@Override
	public void inserir(Bairro bairro) {		
		String sql = "insert into bairro ( nome) values (?)";
				
		try {
			Connection conn = datasource.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);			
			
			preparedStatement.setString(1, bairro.getNome());
			preparedStatement.executeUpdate();

			conn.close();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public List<Bairro> listarTodos() {
		ArrayList<Bairro> bairros = new ArrayList<>();
		try {
			Connection conn = datasource.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select idBairro, nome from bairro");
			while (rs.next()) {
				String id = rs.getString(1);
				String nome = rs.getString(2);
				bairros.add(new Bairro(id, nome));
			}
			conn.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bairros;
	}	
	

	

}
