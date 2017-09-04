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

import org.springframework.format.annotation.DateTimeFormat;

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
	@JoinColumn(name="companiaTransporte")	
	private CompaniaTransporte companiaTransporte		= null;
	
	@ManyToOne
	@JoinColumn(name="tipoTransporte")	
	private TipoTransporte tipoTransporte				= null;
	
	@DateTimeFormat(pattern = "HH:mm")	
	private Date ruta_horaDocumentacion					= null;
	
	@DateTimeFormat(pattern = "HH:mm")	
	private Date ruta_horaSalida						= null;
	
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

	public CompaniaTransporte getCompaniaTransporte() {
		return companiaTransporte;
	}
	public void setCompaniaTransporte(CompaniaTransporte companiaTransporte) {
		this.companiaTransporte = companiaTransporte;
	}

	public TipoTransporte getTipoTransporte() {
		return tipoTransporte;
	}
	public void setTipoTransporte(TipoTransporte tipoTransporte) {
		this.tipoTransporte = tipoTransporte;
	}

	public Date getRuta_horaDocumentacion() {
		return ruta_horaDocumentacion;
	}
	public void setRuta_horaDocumentacion(Date ruta_horaDocumentacion) {
		this.ruta_horaDocumentacion = ruta_horaDocumentacion;
	}

	public Date getRuta_horaSalida() {
		return ruta_horaSalida;
	}
	public void setRuta_horaSalida(Date ruta_horaSalida) {
		this.ruta_horaSalida = ruta_horaSalida;
	}
	
	//Formateo horas
	public String getRuta_horaDocumentacionFormateada() {
		return ruta_horaDocumentacion.toString().substring(11, 16);
	}
	public String getRuta_horaSalidaFormateada() {
		return ruta_horaSalida.toString().substring(11, 16);
	}
	
	public Ruta() {
		super();	
	}
	
	public Ruta(Integer id, Agencia agencia,
			CompaniaTransporte companiaTransporte,
			TipoTransporte tipoTransporte, Date ruta_horaDocumentacion,
			Date ruta_horaSalida) {
		super();
		this.id = id;
		this.agencia = agencia;
		this.companiaTransporte = companiaTransporte;
		this.tipoTransporte = tipoTransporte;
		this.ruta_horaDocumentacion = ruta_horaDocumentacion;
		this.ruta_horaSalida = ruta_horaSalida;
	}
	
	@Override
	public String toString() {
		return "Ruta [id=" + id + ", agencia=" + agencia
				+ ", companiaTransporte=" + companiaTransporte
				+ ", tipoTransporte=" + tipoTransporte
				+ ", ruta_horaDocumentacion=" + ruta_horaDocumentacion
				+ ", ruta_horaSalida=" + ruta_horaSalida + "]";
	}
	
}
