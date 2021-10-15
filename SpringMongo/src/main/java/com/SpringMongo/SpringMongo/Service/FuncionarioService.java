package com.SpringMongo.SpringMongo.Service;

import java.util.List;

import com.SpringMongo.SpringMongo.Model.Funcionario;

public interface FuncionarioService {

	public List<Funcionario> obterTodos();
	
	public Funcionario obterPorCodico(String codico);
	
	public Funcionario obterPorNome(String codico);
	
	public Funcionario criarFuncionario(Funcionario funcionario);
	
}
