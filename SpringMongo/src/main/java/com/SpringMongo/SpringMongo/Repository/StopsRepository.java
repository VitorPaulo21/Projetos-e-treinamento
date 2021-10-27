package com.SpringMongo.SpringMongo.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.SpringMongo.SpringMongo.Model.Stops;

public interface StopsRepository extends MongoRepository<Stops, String>{

	public Optional<Stops> findByIdent(int ident);
	
}
