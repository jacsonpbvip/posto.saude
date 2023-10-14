package br.edu.utfpr.td.tsi.posto.saude.dao;
import java.util.List;

import br.edu.utfpr.td.tsi.posto.saude.modelo.Especialidade;

public interface EspecialidadeDAO {

	public List<Especialidade> listarTodos();
	
	public void inserir(Especialidade especialidade);
	
	public Especialidade procurar(String idEspecialidade);
}
