package br.edu.utfpr.td.tsi.posto.saude.modelo;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

public class Consulta {	
	private String id;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime Data;
	private Status statusConsulta;
	private String idMedicos;
	private String idPaciente;
	
	
	public Consulta() {
		
	}
	
	public Consulta(String id, LocalDateTime data, Status statusConsulta, String idMedicos, String idPaciente) {
		super();
		this.id = id;
		this.Data = data;
		this.statusConsulta = statusConsulta;
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




	public Status getStatusConsulta() {
		return statusConsulta;
	}




	public void setStatusConsulta(Status statusConsulta) {
		this.statusConsulta = statusConsulta;
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

    public void setStatus(String string) {
    }

	
}
