package com.fsc.feignClient;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fsc.models.Usuario;


@Component
@FeignClient(name = "usuario", url = "localhost:8010", path = "/usuario")
public interface UsuarioFeignClient {

	@GetMapping("/search")
	ResponseEntity<Usuario> findByEmail(@RequestParam String email);
}
