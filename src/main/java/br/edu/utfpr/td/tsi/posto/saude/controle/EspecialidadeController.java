package br.edu.utfpr.td.tsi.posto.saude.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.utfpr.td.tsi.posto.saude.dao.EspecialidadeDAO;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Especialidade;

@Controller
public class EspecialidadeController {

	@Autowired
	EspecialidadeDAO especialidadeDao;

	@GetMapping(value = "/listarEspecialidades")
	public String listarEspecialidades(Model model) {
		List<Especialidade> especialidades = especialidadeDao.listarTodos();
		model.addAttribute("especialidades", especialidades);
		return "listarEspecialidades";

	}

	@GetMapping(value = "/cadastrarEspecialidade")
	public String cadastrar(Especialidade especialidade) {
		especialidadeDao.inserir(especialidade);
		return "cadastrarEspecialidade";
	}

	@PostMapping(value = "/cadastrarEspecialidade")
	public String especialiadeCadastrar(Especialidade especialidade) {
		especialidadeDao.inserir(especialidade);
		return "index";
	}

}
