package br.edu.utfpr.td.tsi.posto.saude.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.utfpr.td.tsi.posto.saude.dao.BairroDAO;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Bairro;

@Controller
public class BairroController {
	
	@Autowired
	BairroDAO bairroDAO;
	
	@GetMapping(value = "/cadastrarBairro")
	public String bairroCadasto() {
		return "cadastrarBairro";
	}
	
	@PostMapping(value = "/cadastrarBairro")
	public String bairroCadastrar(Bairro bairro) {
		bairroDAO.inserir(bairro);
		return "index";
	}
	
	@GetMapping(value = "/listarBairros")
	public String listar(Model model) {
		List<Bairro> bairros = bairroDAO.listarTodos();
		model.addAttribute("bairros", bairros);	
		return "listarBairros";
	}
}
