package net.gefco.cartaporte.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="agencia")
public class Agencia implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer 			id						= null;
	
	@NotEmpty
	private String				agen_codigo 			= null;
	
	@NotEmpty
	private String  			agen_nombre				= null;
	
	@ManyToOne
	@JoinColumn(name="uo")	
	private UO					uo						= null;
	
	private String				agen_contacto			= null;
	
	private String				agen_telefonoContacto 	= null;
	
	private Boolean 			agen_copiaOrigen		= null;
	private Boolean 			agen_copiaDestino		= null;
	private Boolean 			agen_copiaTransportista	= null;
	private Boolean 			agen_copiaFactura		= null;
	
	private Boolean				agen_mediosDurables		= null;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getAgen_codigo() {
		return agen_codigo;
	}
	public void setAgen_codigo(String agen_codigo) {
		this.agen_codigo = agen_codigo;
	}
	
	public String getAgen_nombre() {
		return agen_nombre;
	}
	public void setAgen_nombre(String agen_nombre) {
		this.agen_nombre = agen_nombre;
	}
	
	public UO getUo() {
		return uo;
	}
	public void setUo(UO uo) {
		this.uo = uo;
	}
	
	public String getAgen_contacto() {
		return agen_contacto;
	}
	public void setAgen_contacto(String agen_contacto) {
		this.agen_contacto = agen_contacto;
	}
	
	public String getAgen_telefonoContacto() {
		return agen_telefonoContacto;
	}
	public void setAgen_telefonoContacto(String agen_telefonoContacto) {
		this.agen_telefonoContacto = agen_telefonoContacto;
	}
	
	public Boolean getAgen_copiaOrigen() {
		return agen_copiaOrigen;
	}
	public void setAgen_copiaOrigen(Boolean agen_copiaOrigen) {
		this.agen_copiaOrigen = agen_copiaOrigen;
	}
	
	public Boolean getAgen_copiaDestino() {
		return agen_copiaDestino;
	}
	public void setAgen_copiaDestino(Boolean agen_copiaDestino) {
		this.agen_copiaDestino = agen_copiaDestino;
	}
	
	public Boolean getAgen_copiaTransportista() {
		return agen_copiaTransportista;
	}
	public void setAgen_copiaTransportista(Boolean agen_copiaTransportista) {
		this.agen_copiaTransportista = agen_copiaTransportista;
	}
	
	public Boolean getAgen_copiaFactura() {
		return agen_copiaFactura;
	}
	public void setAgen_copiaFactura(Boolean agen_copiaFactura) {
		this.agen_copiaFactura = agen_copiaFactura;
	}
	
	public Boolean getAgen_mediosDurables() {
		return agen_mediosDurables;
	}
	public void setAgen_mediosDurables(Boolean agen_mediosDurables) {
		this.agen_mediosDurables = agen_mediosDurables;
	}
	
	public Agencia() {
		super();
	}

	public Agencia(Integer id) {
		super();
		this.id= id;		
	}
	
	public Agencia(Integer id, String agen_codigo, String agen_nombre, UO uo,
			String agen_contacto, String agen_telefonoContacto,
			Boolean agen_copiaOrigen, Boolean agen_copiaDestino,
			Boolean agen_copiaTransportista, Boolean agen_copiaFactura, Boolean agen_mediosDurables) {
		super();
		this.id = id;
		this.agen_codigo = agen_codigo;
		this.agen_nombre = agen_nombre;
		this.uo = uo;
		this.agen_contacto = agen_contacto;
		this.agen_telefonoContacto = agen_telefonoContacto;
		this.agen_copiaOrigen = agen_copiaOrigen;
		this.agen_copiaDestino = agen_copiaDestino;
		this.agen_copiaTransportista = agen_copiaTransportista;
		this.agen_copiaFactura = agen_copiaFactura;
		this.agen_mediosDurables = agen_mediosDurables;
	}
	@Override
	public String toString() {
		return "Agencia [id=" + id+ ", agen_codigo=" + agen_codigo
				+ ", agen_nombre=" + agen_nombre + ", uo=" + uo
				+ ", agen_contacto=" + agen_contacto + ", agen_telefonoContacto=" + agen_telefonoContacto
				+ ", agen_copiaOrigen=" + agen_copiaOrigen + ", agen_copiaDestino=" + agen_copiaDestino
				+ ", agen_copiaTransportista=" + agen_copiaTransportista + ", agen_copiaFactura=" + agen_copiaFactura
				+ ", agen_mediosDurables=" + agen_mediosDurables + "]";
	}
	
	public String toStringCodigo(){		
		return agen_codigo+" - "+agen_nombre;
	}
	
}
