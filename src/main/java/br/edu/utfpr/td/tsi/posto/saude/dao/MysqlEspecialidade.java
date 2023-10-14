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

import br.edu.utfpr.td.tsi.posto.saude.modelo.Especialidade;

@Component
public class MysqlEspecialidade implements EspecialidadeDAO {

    @Autowired
    private DataSource dataSource;

    @Override
    public void inserir(Especialidade especialidade) {
        long idEspecialidade = 0;
        String sql = "INSERT INTO especialidade (descricao) VALUES (?)";
        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, especialidade.getDescricao());

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                idEspecialidade = generatedKeys.getLong(1);
            }

            conn.close();
            preparedStatement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }        
    }

    @Override
    public List<Especialidade> listarTodos() {
        ArrayList<Especialidade> especialidades = new ArrayList<>();
        try {
            Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT idEspecialidade, descricao FROM especialidade");
            while (rs.next()) {
                String id = rs.getString("idEspecialidade");
                String descricao = rs.getString("descricao");
                especialidades.add(new Especialidade(id, descricao));
            }
            conn.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return especialidades;
    }

    public Especialidade procurarPorNome(String nome) {
        Especialidade especialidade = null;
        String sql = "SELECT idEspecialidade, descricao, nome FROM especialidade WHERE nome=?";
        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, nome);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String id = rs.getString("idEspecialidade");
                String descricao = rs.getString("descricao");
                especialidade = new Especialidade(id, descricao);
            }
            conn.close();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return especialidade;
    }

    @Override
    public Especialidade procurar(String idEspecialidade) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'procurar'");
    }

}
