package br.edu.utfpr.td.tsi.posto.saude.modelo;

import java.util.UUID;

public class Doenca {

	private UUID id;
	private String nome;
	private String nome_cientifico;

	public Doenca(UUID id, String nome, String nome_cientifico) {
		super();
		this.id = id;
		this.nome = nome;
		this.nome_cientifico = nome_cientifico;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome_cientifico() {
		return nome_cientifico;
	}

	public void setNome_cientifico(String nome_cientifico) {
		this.nome_cientifico = nome_cientifico;
	}

}
