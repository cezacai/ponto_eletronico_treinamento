package br.com.itau.pontoeletronico.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table (name="TB_REGISTRO")
@JsonIgnoreType
@JsonIgnoreProperties("id-usuario")
public class RegistroPonto {
	
	public enum TipoRegistro{
		entrada,
		saida
	}

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_REGISTRO")
	private Long id;
	
	@JsonProperty(value= "id-usuario")	
	@ManyToOne 
    @JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;
	
	@JsonProperty(value= "data-hora")	
	@Column(name="DATA_HORA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date  dataHoraRegistro;
	
	@JsonProperty(value= "tipo")	
	@Column(name="TIPO")
	@Enumerated(EnumType.STRING)
	private TipoRegistro tipoRegistro;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Date getDataHoraRegistro() {
		return dataHoraRegistro;
	}
	public void setDataHoraRegistro(Date dataHoraRegistro) {
		this.dataHoraRegistro = dataHoraRegistro;
	}
	
	public TipoRegistro getTipoRegistro() {
		return tipoRegistro;
	}
	public void setTipoRegistro(TipoRegistro tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}


	public RegistroPonto(Usuario usuario, Date dataHoraRegistro, String tipoRegistro) {
		super();
		this.usuario = usuario;
		this.dataHoraRegistro = dataHoraRegistro;
		this.tipoRegistro = TipoRegistro.valueOf(tipoRegistro);
	}
	
	public RegistroPonto() {
		super();
	}
	
	

}
