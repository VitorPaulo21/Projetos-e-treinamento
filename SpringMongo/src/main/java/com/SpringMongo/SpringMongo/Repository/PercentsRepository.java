package com.SpringMongo.SpringMongo.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.SpringMongo.SpringMongo.Model.Percents;

public interface PercentsRepository extends MongoRepository<Percents, String>{

	public Optional<Percents> findByIdent(int ident);
	
}
