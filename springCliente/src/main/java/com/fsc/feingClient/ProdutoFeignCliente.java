package com.fsc.feingClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fsc.service.Produto;



@Component
@FeignClient(name = "produto", url = "localhost:8000", path = "/produto")
public interface ProdutoFeignCliente {

	@GetMapping("/{id}")
	ResponseEntity<Produto> findById(@PathVariable Long id);
	
	
}
