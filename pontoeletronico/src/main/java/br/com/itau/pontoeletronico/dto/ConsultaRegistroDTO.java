package br.com.itau.pontoeletronico.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.itau.pontoeletronico.model.RegistroPonto;

public class ConsultaRegistroDTO {
	
	@JsonProperty(value= "registros")	
	List<RegistroPonto> listaRegistros;
	
	public List<RegistroPonto> getListaRegistros() {
		return listaRegistros;
	}
	public void setListaRegistros(List<RegistroPonto> listaRegistros) {
		this.listaRegistros = listaRegistros;
	}	
}
