package br.com.itau.pontoeletronico.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;


public class UsuarioDTO  implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -510536145807285536L;

	
	@NotNull(message = "Data não pode ser nula")
	@JsonProperty(value= "data-cadastro")	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd" )
	private Date dataCadastro;
	
	@NotBlank(message = "Nome Completo não pode ser nulo")
	@Size(min=2, max=250 , message="O nome deve ser ter no maximo 250 caracteres") 
	@JsonProperty(value= "nome-completo")	
	private String nomeCompleto;
	
	@Size(min=11, max=11, message="O tamanho do CPF deve ser de 11 digitos")
	@JsonProperty(value= "cpf")	
	@NotBlank(message = "CPF deve ser prenchido")
	private String cpf;
	
	@NotBlank(message = "E-mail não pode ser nulo")
	@JsonProperty(value= "email")	
	@Size(min=2, max=250 , message="O e-mail deve ser ter no maximo 250 caracteres") 
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
	
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
}
