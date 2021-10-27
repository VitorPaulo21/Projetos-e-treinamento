package com.SpringMongo.SpringMongo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SpringMongo.SpringMongo.Model.Funcionario;
import com.SpringMongo.SpringMongo.Service.FuncionarioService;

@RestController
@RequestMapping("funcionarios")
public class FuncionarioController {
 
	@Autowired
	FuncionarioService funcionarioservice;
	
	@GetMapping
	public List<Funcionario> obterTodos(){
		
		return funcionarioservice.obterTodos();
	}
	
	@GetMapping(path = "/obterPorCodico/{codico}")
	public Funcionario obterPorCodico(@PathVariable String codico) {
		return funcionarioservice.obterPorCodico(codico);
	}
	@GetMapping(path = "/obterPorNome/{nome}")
	public Funcionario obterPorNome(@PathVariable String nome) {
		return funcionarioservice.obterPorNome(nome);
	}
	
	@PostMapping("criar")
	public Funcionario criar( @RequestBody Funcionario funcionario) {
		
		Funcionario chefe = funcionarioservice.obterPorCodico(funcionario.getChefe().getCodico());
		
		funcionario.setChefe(chefe);
		
		return funcionarioservice.criarFuncionario(funcionario);
		
	}
	@PostMapping(path = "/update")
	public Funcionario update(@RequestParam(name = "id", required = true) String id, 
			@RequestParam(name = "chefe", required = true) String chefe) {

		Funcionario funcionario = funcionarioservice.obterPorCodico(id);
		
		funcionario.setChefe(funcionarioservice.obterPorCodico(chefe));

		System.out.println("atualizado");
		return funcionarioservice.criarFuncionario(funcionario);
	}
	
}
