package com.StormProject.exerciciossb.model.Repositories;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.StormProject.exerciciossb.model.Entities.Produto;

public interface repository extends PagingAndSortingRepository<Produto, Integer>{

	
	public Iterable<Produto> findByNomeContainingIgnoreCase(@NotBlank String nom);
	
	//findByNomeContaining
	//findByNomeIsContaining
	//findByNomeContains
	
	//findByNomeStartsWith
	//findByNomeEndsWith
	
	//findByNomeNotContaining
	
	@Query(value = "SELECT * FROM produto WHERE nome LIKE %?1", nativeQuery = true)
	public Iterable<Produto> searchNomeLike(String nome);
	
	
}
