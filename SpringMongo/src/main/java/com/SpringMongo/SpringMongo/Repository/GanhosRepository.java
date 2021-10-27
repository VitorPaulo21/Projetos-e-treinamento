package com.SpringMongo.SpringMongo.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.SpringMongo.SpringMongo.Model.Ganhos;

public interface GanhosRepository extends MongoRepository<Ganhos, String>{

	public Optional<Ganhos> findByData(String data);
	
}
