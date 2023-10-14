
package br.edu.utfpr.td.tsi.posto.saude.modelo;

public class Especialidade {
	private String idEspecialidade;
	public Especialidade() {
        // Construtor vazio
    }

	public String getIdEspecialidade() {
		return idEspecialidade;
	}

	public void setIdEspecialidade(String idEspecialidade) {
		this.idEspecialidade = idEspecialidade;
	}

	private String descricao; //

	public Especialidade(String id, String descricao) {
		super();
		this.idEspecialidade = id;
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}