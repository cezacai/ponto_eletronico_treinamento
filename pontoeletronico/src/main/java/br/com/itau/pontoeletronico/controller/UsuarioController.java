package br.com.itau.pontoeletronico.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.pontoeletronico.dto.UsuarioDTO;
import br.com.itau.pontoeletronico.dto.UsuarioEditavelDTO;
import br.com.itau.pontoeletronico.model.Usuario;
import br.com.itau.pontoeletronico.service.UsuarioService;

@RestController
@RequestMapping("/ponto-eletronico/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping
	@ResponseStatus(code = HttpStatus.OK)
	public void criarUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO) {
		usuarioService.criarUsuario(usuarioDTO);
	}

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<Usuario> consultarListaUsuario() {
		return usuarioService.consultarListaUsuario();
	}

	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<?> editarUsuario(@Valid @PathVariable(value = "id") Long id,
			@Valid @RequestBody UsuarioEditavelDTO usuarioEditavel) {

		if (usuarioService.editarUsuario(id, usuarioEditavel)) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.noContent().build();
		}
	}

}
