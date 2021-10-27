package com.SpringMongo.SpringMongo.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringMongo.SpringMongo.Model.Funcionario;
import com.SpringMongo.SpringMongo.Repository.FuncionarioRepository;
import com.SpringMongo.SpringMongo.Service.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService{

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Override
	public List<Funcionario> obterTodos() {
		return funcionarioRepository.findAll();
	}

	@Override
	public Funcionario obterPorCodico(String codico) {
		return funcionarioRepository
				.findById(codico)
				.orElseThrow(() -> new IllegalArgumentException("Funcionario não existe."));
	}

	@Override
	public Funcionario obterPorNome(String nome) {
		
		return funcionarioRepository.findByNome(nome)
				.orElseThrow(() -> new IllegalArgumentException("Funcionario nao existe."));
	}
	
	@Override
	public Funcionario criarFuncionario(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}
	
	

}
