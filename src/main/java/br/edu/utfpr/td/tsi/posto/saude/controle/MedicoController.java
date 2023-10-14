package br.edu.utfpr.td.tsi.posto.saude.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.utfpr.td.tsi.posto.saude.dao.EspecialidadeDAO;
import br.edu.utfpr.td.tsi.posto.saude.dao.MedicoDAO;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Especialidade;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Medicos;

@Controller
public class MedicoController {

	@Autowired
	EspecialidadeDAO especialidadeDAO;

	@Autowired
	MedicoDAO medicoDAO;

	@GetMapping("/cadastrarMedicos")
	public String listarEspecialidades(Model model) {
		List<Especialidade> especialidades = especialidadeDAO.listarTodos();
		model.addAttribute("especialidades", especialidades);
		return "cadastrarMedicos";
	}

	@PostMapping(value = "/cadastrarMedicos")
	public String cadastrarMedicos(Medicos medicos) {
		medicoDAO.inserir(medicos);
		return "index";
	}

	@GetMapping("/listarMedicos")
	public String listarTodos(Model model) {
		List<Medicos> medicos = medicoDAO.listarTodos();
		model.addAttribute("medicos", medicos);
		return "listarMedicos";
	}

}
