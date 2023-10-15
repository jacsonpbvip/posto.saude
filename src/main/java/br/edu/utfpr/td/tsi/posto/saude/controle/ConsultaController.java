package br.edu.utfpr.td.tsi.posto.saude.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.utfpr.td.tsi.posto.saude.dao.ConsultaDAO;
import br.edu.utfpr.td.tsi.posto.saude.dao.MedicoDAO;
import br.edu.utfpr.td.tsi.posto.saude.dao.PacienteDAO;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Consulta;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Medicos;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Paciente;

@Controller
public class ConsultaController {

	@Autowired
	private PacienteDAO pacienteDAO;
	@Autowired
	private MedicoDAO medicoDAO;
	@Autowired
	private ConsultaDAO consultaDAO;

	@GetMapping(value = "/cadastrarConsulta")
	public String goToCadastrarConsulta(Model model) {
		List<Paciente> pacientes = pacienteDAO.listarTodos();
		model.addAttribute("pacientes", pacientes);
		List<Medicos> medicos = medicoDAO.listarTodos();
		model.addAttribute("medicos", medicos);

		return "cadastrarConsulta";
	}

	@PostMapping(value = "/cadastrarConsulta")
	public String cadastrarConsulta(Consulta consulta) {
		consultaDAO.inserir(consulta);
		return "index";
	}

	@GetMapping(value = "/listarConsultas")
	public String listar(Model model) {
		List<Consulta> consultas = consultaDAO.listarTodos();
		model.addAttribute("consultas", consultas);
		return "listarConsultas";
	}
}
