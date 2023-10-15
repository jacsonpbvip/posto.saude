package br.edu.utfpr.td.tsi.posto.saude.modelo;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

public class Consulta {	
	private String id;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime Data;
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String string) {
		this.status = string;
	}




	private String idMedicos;
	private String idPaciente;
	
	
	public Consulta() {
		
	}
	
	public Consulta(String id, LocalDateTime data, String status, String idMedicos, String idPaciente) {
		super();
		this.id = id;
		this.Data = data;
		this.status = status;
		this.idMedicos = idMedicos;
		this.idPaciente = idPaciente;
	}




	public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}




	public LocalDateTime getData() {
		return Data;
	}




	public void setData(LocalDateTime data) {
		Data = data;
	}




	



	public String getIdMedicos() {
		return idMedicos;
	}




	public void setIdMedicos(String idMedicos) {
		this.idMedicos = idMedicos;
	}




	public String getIdPaciente() {
		return idPaciente;
	}




	public void setIdPaciente(String idPaciente) {
		this.idPaciente = idPaciente;
	}
  

	
}
