package com.SpringMongo.SpringMongo.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.SpringMongo.SpringMongo.Model.Funcionario;

public interface FuncionarioRepository extends MongoRepository<Funcionario, String>{

	public Optional<Funcionario> findByNome(String nome);
	
}
