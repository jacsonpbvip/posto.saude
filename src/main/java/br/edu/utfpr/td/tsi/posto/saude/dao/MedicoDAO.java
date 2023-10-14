package br.edu.utfpr.td.tsi.posto.saude.dao;

import java.util.List;

import br.edu.utfpr.td.tsi.posto.saude.modelo.Medicos;

public interface MedicoDAO {


	public void inserir(Medicos medico);

	public List<Medicos> listarTodos();
	
	
}