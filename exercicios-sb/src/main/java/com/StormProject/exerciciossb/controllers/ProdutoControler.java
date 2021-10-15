package com.StormProject.exerciciossb.controllers;

import java.nio.file.Path;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.StormProject.exerciciossb.model.Entities.Produto;
import com.StormProject.exerciciossb.model.Repositories.repository;

@RestController
@RequestMapping("api/produto")
public class ProdutoControler {

	@Autowired
	private repository prodRepos;
	
	@PostMapping("new")
	public @ResponseBody Produto novo(@RequestParam(name = "name") String name, 
			@RequestParam(name = "preco") double preco,
			@RequestParam(name = "desconto") double desconto) {
		Produto prod = new Produto(name, preco, desconto);
		System.out.println(prodRepos.save(prod).getNome());
		return prod;
		
	}
	
	@RequestMapping(path = "/new2", method = {RequestMethod.POST, RequestMethod.PUT})
	public @ResponseBody Produto novo(@Valid Produto prod) {
		prodRepos.save(prod);
		return prod;
		
	}
	
	@GetMapping("all")
	public Iterable<Produto> getAll(){
		
		return prodRepos.findAll();
	
	}
	
	@GetMapping(path = "/{id}")
	public Optional<Produto> getFromId(@PathVariable Integer id){
		
		return prodRepos.findById(id);
		
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public void delete(@PathVariable Integer id) {
		
		prodRepos.deleteById(id);
		
	}
	
	@GetMapping(path = "/pagina/{pagina}")
	public Iterable<Produto> getPaged(@PathVariable Integer pagina){
		
		Pageable pageable = PageRequest.of(pagina, 3);
		return prodRepos.findAll(pageable);
		
	}
	
	@GetMapping(path = {"/searchName/{name}", "/searchName/", "/searchName"})
	public Iterable<Produto> findName(@Valid @PathVariable(name = "", required = false) String name){
		if (name != null) {
			
//			return prodRepos.findByNomeContainingIgnoreCase(name);
			return prodRepos.searchNomeLike(name);
		}
		
		return null;
	}
	
}
