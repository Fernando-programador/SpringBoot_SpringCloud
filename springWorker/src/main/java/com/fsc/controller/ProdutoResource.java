package com.fsc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fsc.model.Produto;
import com.fsc.repository.ProdutoRepository;

@RestController
@RequestMapping("api/produto")
public class ProdutoResource {

	@Autowired
	private ProdutoRepository produtoRepository;

	@GetMapping
	public ResponseEntity<List<Produto>> obterTodosProdutos() {
		List<Produto> produto = produtoRepository.findAll();
		return ResponseEntity.ok(produto);
	}

	@GetMapping("{id}")
	public ResponseEntity<Produto> obterPorId(@PathVariable Long id) {
		Produto produto = produtoRepository.findById(id).get();
		return ResponseEntity.ok(produto);
	}

}
