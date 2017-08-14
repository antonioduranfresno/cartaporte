package net.gefco.cartaporte.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="agencia")
public class Agencia implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer 			idAgencia 		= null;
	
	private String				agen_codigo 	= null;
	
	private String  			agen_nombre			= null;
	
	@ManyToOne
	@JoinColumn(name="uo")	
	private UO					uo				= null;

	public Integer getIdAgencia() {
		return idAgencia;
	}
	public void setIdAgencia(Integer idAgencia) {
		this.idAgencia = idAgencia;
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
	
	public Agencia() {
		super();
	}

	public Agencia(Integer idAgencia) {
		super();
		this.idAgencia = idAgencia;		
	}
	
	public Agencia(Integer idAgencia, String agen_codigo, String agen_nombre, UO uo) {
		super();
		this.idAgencia = idAgencia;
		this.agen_codigo = agen_codigo;
		this.agen_nombre = agen_nombre;
		this.uo = uo;
	}
	
	@Override
	public String toString() {
		return "Agencia [idAgencia=" + idAgencia + ", agen_codigo=" + agen_codigo
				+ ", agen_nombre=" + agen_nombre + ", uo=" + uo + "]";
	}
	
	public String toStringCodigo(){		
		return agen_codigo+" - "+agen_nombre;
	}
	
	
}
