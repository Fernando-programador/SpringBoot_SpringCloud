package com.fsc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.fsc.feignClient.UsuarioFeignClient;
import com.fsc.models.Usuario;

@Service
public class UsuarioService {

	
  @Autowired
  private UsuarioFeignClient usuarioFeignClient;
  
  Logger logger = LoggerFactory.getLogger(UsuarioService.class);
  
  public Usuario findByEmail(String email) {
	Usuario usuario = usuarioFeignClient.findByEmail(email).getBody();
	if(usuario ==null) {
		logger.error("email não encontrado" + email);
		throw new IllegalArgumentException("Email não encontrado");
	}
	
	logger.info("emial encontrado " + email);
	return usuario;
	
	
	
  }
  
  
  
  
}
