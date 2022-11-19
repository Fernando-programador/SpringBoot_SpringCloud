package com.fsc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fsc.model.Usuario;
import com.fsc.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioResource {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> findByid(@PathVariable Long id){
		Usuario usuario = usuarioRepository.findById(id).get();
		return ResponseEntity.ok(usuario);
	
	}
	
	@GetMapping("/search")
	public ResponseEntity<Usuario> findByEmail(@RequestParam String email){
		Usuario usuario = usuarioRepository.findByEmail(email);
		return ResponseEntity.ok(usuario);
	}
	
	
}
