package br.edu.utfpr.td.tsi.posto.saude.dao;

import java.util.List;

import br.edu.utfpr.td.tsi.posto.saude.modelo.Bairro;

public interface BairroDAO {
	public void inserir(Bairro bairro);
	public List<Bairro> listarTodos();
}
