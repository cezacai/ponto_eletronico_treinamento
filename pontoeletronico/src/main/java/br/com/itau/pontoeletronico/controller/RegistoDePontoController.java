package br.com.itau.pontoeletronico.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.pontoeletronico.dto.ConsultaRegistroDTO;
import br.com.itau.pontoeletronico.dto.RegistroPontoDTO;
import br.com.itau.pontoeletronico.service.RegistroPontoService;

@RestController
@RequestMapping("/registro")
public class RegistoDePontoController {
	
	@Autowired
	RegistroPontoService registroPontoService;
	
	@GetMapping("/{id}")
	public ConsultaRegistroDTO consultarPonto(@Valid @PathVariable(value="id") Long id) {
		ConsultaRegistroDTO consultaRegistroDTO = new ConsultaRegistroDTO();
		consultaRegistroDTO.setListaRegistros(registroPontoService.consultarRegistro(id));		
		return consultaRegistroDTO;
	}
	
	@PostMapping()
	@ResponseStatus(code = HttpStatus.OK)
	public void registrarPonto(@Valid @RequestBody RegistroPontoDTO registroPontoDTO) {
		registroPontoService.baterPonto(registroPontoDTO);		
	}	

}
