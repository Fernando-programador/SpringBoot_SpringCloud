package com.fsc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fsc.model.Pessoa;
import com.fsc.service.PessoaService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/pessoa")
public class PessoaResource {

	@Autowired
	private PessoaService pessoaService;
	
	@HystrixCommand(fallbackMethod =  "getPessoaAlternativo")
	@GetMapping("/{produtoId}/quantidade/{quantidade}")
public ResponseEntity<Pessoa> getPessoa(
		@PathVariable Long produtoId, @PathVariable Integer quantidade){
		Pessoa pessoa = pessoaService.getPessoa(produtoId, quantidade);
		
		return ResponseEntity.ok(pessoa);
	}
	
	//resposta altenativa caso um micro serviço cai a conexão
	public ResponseEntity<Pessoa> getPessoaAlternativo(Long produtoId, Integer quantidade){
		Pessoa pessoa = new Pessoa("sem resposta", 0.00, quantidade);
		return ResponseEntity.ok(pessoa);
	}
	
	
}