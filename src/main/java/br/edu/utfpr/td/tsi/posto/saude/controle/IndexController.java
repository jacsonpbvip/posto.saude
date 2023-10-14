package br.edu.utfpr.td.tsi.posto.saude.controle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping(value = "/")
	public String index() {
		return "index";
	}
	
	@GetMapping(value = "/pacienteIndex")
	public String pacienteIndex() {
		return "pacienteIndex";
	}
	

	@GetMapping(value = "/cadastrarPacientesIndex")
	public String pacienteCadasto() {
		return "cadastrarPacientes";
	}
	
	

	@GetMapping(value = "/medicoIndex")
	public String medicoIndex() {
		return "medicoIndex";
	}
	
	@GetMapping(value = "/adminIndex")
	public String adminIndex() {
		return "adminIndex";
	}
	
	@GetMapping(value = "/voltar")
	public String voltar() {
		System.out.print("Funcionou");
		return "index";
	}
	
}
