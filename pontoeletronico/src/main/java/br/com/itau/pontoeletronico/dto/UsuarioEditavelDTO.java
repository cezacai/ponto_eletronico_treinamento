package br.com.itau.pontoeletronico.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;



import com.fasterxml.jackson.annotation.JsonProperty;

public class UsuarioEditavelDTO {
	@NotBlank
	@Size(min=2, max=250 , message="Tamanho inválido") 
	@JsonProperty(value= "nome-completo")	
	private String nomeCompleto;
	
	@NotBlank
	@Size(min=11, max=11, message="cpf inválido")
	@JsonProperty(value= "cpf")	
	private String cpf;
	
	@NotBlank
	@JsonProperty(value= "email")	
	@Size(min=2, max=250 , message="email inválido") 
	String email;

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	

}
