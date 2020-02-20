package br.com.itau.pontoeletronico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.itau.pontoeletronico.dto.RegistroPontoDTO;
import br.com.itau.pontoeletronico.model.RegistroPonto;
import br.com.itau.pontoeletronico.model.Usuario;
import br.com.itau.pontoeletronico.repository.RegistroRepository;


@Service
public class RegistroPontoService {
	
	@Autowired
	private RegistroRepository registroRepository;
	
	public RegistroPonto baterPonto(RegistroPontoDTO registroPontoDTO) {		
		return registroRepository.save(fromDTO(registroPontoDTO));		
	}
	
	private RegistroPonto fromDTO(RegistroPontoDTO registroPontoDTO) {
		Usuario usuario = new Usuario();
		usuario.setId(registroPontoDTO.getIdUsuario());
		RegistroPonto registroPonto = new RegistroPonto(usuario,
				registroPontoDTO.getDataHoraRegistro(),
				registroPontoDTO.getTipoRegistro()
				);
		return registroPonto;
	}

	public List<RegistroPonto> consultarRegistro(Long id) {
		return registroRepository.consultarRegistro(id);
	}
	

}
