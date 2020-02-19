package br.com.itau.pontoeletronico.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="USUARIOS")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty(value= "id-usuario")	
	@Column(name="ID_USUARIO")
	private Long id;
	
	@JsonProperty(value= "nome-completo")	
	@Column(name="NOME_COMPLETO")
	@Size(max=250)
	private String nomeCompleto;
	
    @Column(name="CPF")
    @Size(max=11)
	private String cpf;
    
    @Column(name="EMAIL")
    @Size(max=250)
	private String email;
    
	@Column(name="DATA_CADASTRO")
	@JsonProperty(value= "data-cadastro")	
	@Temporal(TemporalType.DATE)
	private Date dataCadastro;
	
	
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public Usuario(String nomeCompleto, String cpf, String email, Date dataCadastro) {
		super();
		this.nomeCompleto = nomeCompleto;
		this.cpf = cpf;
		this.email = email;
		this.dataCadastro= dataCadastro;
	}
	
	public Usuario() {
		super();
	}
	
	
}
