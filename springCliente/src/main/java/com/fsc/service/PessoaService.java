package com.fsc.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.fsc.feingClient.ProdutoFeignCliente;
import com.fsc.model.Pessoa;

@Service
public class PessoaService {
	
	//usar somente se for usar o RestTemplate no lugar do feign
	//@Value("${produto.host}")
	//private String produtoHost;
	
	@Autowired
	private ProdutoFeignCliente produtoFeignCliente;

	public Pessoa getPessoa(Long produtoId, Integer quantidade) {
		
		Produto produto = produtoFeignCliente.findById(produtoId).getBody();
		
		
		return new Pessoa(produto.getNome(), produto.getPreco(), quantidade);
	
	//return new Pessoa("prato", 38.1 , quantidade);
	}
}
