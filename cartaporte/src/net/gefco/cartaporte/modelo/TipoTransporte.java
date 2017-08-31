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
@Table(name="tipoTransporte")
public class TipoTransporte implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id					= null;
		
	@ManyToOne
	@JoinColumn(name="agencia")	
	private Agencia agencia 			= null;
	
	@NotEmpty
	private String  titr_nombre 		= null;

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

	public String getTitr_nombre() {
		return titr_nombre;
	}
	public void setTitr_nombre(String titr_nombre) {
		this.titr_nombre = titr_nombre;
	}
	
	public TipoTransporte() {
		super();	
	}
	
	public TipoTransporte(Integer id, Agencia agencia, String titr_nombre) {
		super();
		this.id = id;
		this.agencia = agencia;
		this.titr_nombre = titr_nombre;
	}
	
	@Override
	public String toString() {
		return "TipoTransporte [id=" + id+ ", agencia=" + agencia
				+ ", titr_nombre=" + titr_nombre + "]";
	}
	
	
	
}
