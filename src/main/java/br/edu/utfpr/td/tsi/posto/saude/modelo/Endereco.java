package br.edu.utfpr.td.tsi.posto.saude.modelo;

public class Endereco {

	private String id;
	private String idPaciente;
	private String logradouro;
	private String numero;
	private String cep;
	private Bairro bairro;
	private Paciente paciente;


	public Endereco() {
		
	}
	
	public Endereco(String id, Paciente paciente, String logradouro, String numero, String cep, Bairro bairro, String idBairro) {
		super();
		this.id = id;
		this.idPaciente = paciente.getId();
		this.logradouro = logradouro;
		this.numero = numero;
		this.cep = cep;
		this.bairro = bairro;
	}


	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}


	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getIdPaciente() {
		return idPaciente;
	}



	public void setIdPaciente(String idPaciente) {
		this.idPaciente = idPaciente;
	}



	public String getLogradouro() {
		return logradouro;
	}



	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}



	public String getNumero() {
		return numero;
	}



	public void setNumero(String numero) {
		this.numero = numero;
	}



	public String getCep() {
		return cep;
	}



	public void setCep(String cep) {
		this.cep = cep;
	}



	public Bairro getBairro() {
		return bairro;
	}



	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}	
	
	
}

