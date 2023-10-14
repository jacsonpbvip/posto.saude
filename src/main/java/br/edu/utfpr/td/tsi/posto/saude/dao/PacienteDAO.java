package br.edu.utfpr.td.tsi.posto.saude.dao;

import java.util.List;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Paciente;

public interface PacienteDAO {

	public void inserir(Paciente paciente);


	public List<Paciente> listarTodos();
	
	public boolean procurar(String cpf);
}

