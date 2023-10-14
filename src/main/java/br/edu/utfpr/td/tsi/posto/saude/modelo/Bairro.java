package br.edu.utfpr.td.tsi.posto.saude.modelo;

public class Bairro {
	
	private String id;
	private String nome;
	
	public Bairro() {
	}
	
	public Bairro(String id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}

