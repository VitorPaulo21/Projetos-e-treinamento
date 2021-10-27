package com.SpringMongo.SpringMongo.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.SpringMongo.SpringMongo.Model.Banca;

public interface BancaRepository extends MongoRepository<Banca, String>{

	public Optional<Banca> findByIdent(int ident);
	
}
