package net.gefco.cartaporte.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ruta")
public class Ruta implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id 									= null;
		
	@ManyToOne
	@JoinColumn(name="agencia")	
	private Agencia agencia 							= null;
	
	@ManyToOne
	@JoinColumn(name="compania_transporte")	
	private CompaniaTransporte compania_transporte		= null;
	
	@ManyToOne
	@JoinColumn(name="tipo_transporte")	
	private TipoTransporte tipo_transporte				= null;
	
	private Date ruta_hora_documentacion				= null;
	
	private Date ruta_hora_salida						= null;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Agencia getAgencia() {
		return agencia;
	}
	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public CompaniaTransporte getCompania_transporte() {
		return compania_transporte;
	}
	public void setCompania_transporte(CompaniaTransporte compania_transporte) {
		this.compania_transporte = compania_transporte;
	}

	public TipoTransporte getTipo_transporte() {
		return tipo_transporte;
	}
	public void setTipo_transporte(TipoTransporte tipo_transporte) {
		this.tipo_transporte = tipo_transporte;
	}

	public Date getRuta_hora_documentacion() {
		return ruta_hora_documentacion;
	}
	public void setRuta_hora_documentacion(Date ruta_hora_documentacion) {
		this.ruta_hora_documentacion = ruta_hora_documentacion;
	}

	public Date getRuta_hora_salida() {
		return ruta_hora_salida;
	}
	public void setRuta_hora_salida(Date ruta_hora_salida) {
		this.ruta_hora_salida = ruta_hora_salida;
	}
	
	public Ruta() {
		super();	
	}
	
	public Ruta(Integer id, Agencia agencia,
			CompaniaTransporte compania_transporte,
			TipoTransporte tipo_transporte, Date ruta_hora_documentacion,
			Date ruta_hora_salida) {
		super();
		this.id = id;
		this.agencia = agencia;
		this.compania_transporte = compania_transporte;
		this.tipo_transporte = tipo_transporte;
		this.ruta_hora_documentacion = ruta_hora_documentacion;
		this.ruta_hora_salida = ruta_hora_salida;
	}
	
	@Override
	public String toString() {
		return "Ruta [id=" + id + ", agencia=" + agencia
				+ ", compania_transporte=" + compania_transporte
				+ ", tipo_transporte=" + tipo_transporte
				+ ", ruta_hora_documentacion=" + ruta_hora_documentacion
				+ ", ruta_hora_salida=" + ruta_hora_salida + "]";
	}
	
}
