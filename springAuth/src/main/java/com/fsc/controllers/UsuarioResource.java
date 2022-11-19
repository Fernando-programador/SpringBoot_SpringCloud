package com.fsc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fsc.models.Usuario;
import com.fsc.service.UsuarioService;

@RestController
@RequestMapping("/oauth")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/search")
	public ResponseEntity<Usuario> obterPorEmail(@RequestParam String email){
		try {
			
			Usuario usuario = usuarioService.findByEmail(email);
			return ResponseEntity.ok(usuario);
		} catch (IllegalArgumentException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

}
