package br.com.itau.pontoeletronico.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.itau.pontoeletronico.dto.UsuarioDTO;
import br.com.itau.pontoeletronico.dto.UsuarioEditavelDTO;
import br.com.itau.pontoeletronico.model.Usuario;
import br.com.itau.pontoeletronico.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario criarUsuario(UsuarioDTO usuarioDTO) {
		return usuarioRepository.save(fromDTO(usuarioDTO));
	}

	public List<Usuario> consultarListaUsuario() {
		Iterable<Usuario> iterator = usuarioRepository.findAll();

		List<Usuario> listaUsuario = StreamSupport.stream(iterator.spliterator(), false).collect(Collectors.toList());

		return listaUsuario;
	}

	public boolean editarUsuario(Long id, UsuarioEditavelDTO usuarioEditavelDTO) {

		if (usuarioRepository.existsById(id)) {
			Usuario usuario = usuarioRepository.findById(id).get();
			atualizarEntity(usuarioEditavelDTO, usuario);
			usuarioRepository.save(usuario);
			return true;
		}

		return false;
	}
	
	private void atualizarEntity(UsuarioEditavelDTO edicaoUSuarioDTO, Usuario usuario) {
		usuario.setCpf(edicaoUSuarioDTO.getCpf());
		usuario.setEmail(edicaoUSuarioDTO.getEmail());
		usuario.setNomeCompleto(edicaoUSuarioDTO.getNomeCompleto());
	}

	private Usuario fromDTO(UsuarioDTO usuarioDTO) {
		Usuario usuario = new Usuario(usuarioDTO.getNomeCompleto(), usuarioDTO.getCpf(), usuarioDTO.getEmail(),
				usuarioDTO.getDataCadastro());
		return usuario;
	}

	public Usuario consultarUsuario(@Valid Long id) {
		return usuarioRepository.findById(id).get();
	}

}
