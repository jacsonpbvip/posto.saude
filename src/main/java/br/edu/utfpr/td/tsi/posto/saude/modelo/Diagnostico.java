package br.edu.utfpr.td.tsi.posto.saude.modelo;



public class Diagnostico {
	private String id;
	private String observacoes;
	private String idDoenca;
	
	
	
	
	public Diagnostico(String id, String observacoes, String idDoenca) {
		super();
		this.id = id;
		this.observacoes = observacoes;
		this.idDoenca = idDoenca;
	}




	public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}




	public String getObservacoes() {
		return observacoes;
	}




	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}




	public String getIdDoenca() {
		return idDoenca;
	}




	public void setIdDoenca(String idDoenca) {
		this.idDoenca = idDoenca;
	}
	
	
	
	
	
	
	
	
	
}

