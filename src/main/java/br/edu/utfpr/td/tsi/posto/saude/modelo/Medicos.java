package br.edu.utfpr.td.tsi.posto.saude.modelo;

public class Medicos {
	private String id;
	private String nome;
	private String sobrenome;
	private String cpf;
	private String telefone;
	private String crm;
	private Especialidade especialidade;
	private String idEspecialidade;

	

	public String getIdEspecialidade() {
		return idEspecialidade;
	}


	public void setIdEspecialidade(String idEspecialidade) {
		this.idEspecialidade = idEspecialidade;
	}


	public Medicos(String id, String nome, String sobrenome, String cpf, String telefone, String crm,
    String idEspecialidade) {
    super();
    this.id = id;
    this.nome = nome;
    this.sobrenome = sobrenome;
    this.cpf = cpf;
    this.telefone = telefone;
    this.crm = crm;
    this.idEspecialidade = idEspecialidade;
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

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

}