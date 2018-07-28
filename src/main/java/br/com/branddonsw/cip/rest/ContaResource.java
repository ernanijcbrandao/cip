package br.com.branddonsw.cip.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.branddonsw.cip.service.dto.ContaDto;

@RestController
public class ContaResource {
	
	public ResponseEntity<List<ContaDto>> listar() {
		return new ResponseEntity<List<ContaDto>> (new ArrayList<ContaDto>(), HttpStatus.OK);
	}

}
