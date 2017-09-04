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
@Table(name="companiaTransporte")
public class CompaniaTransporte implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="id")	
	private Integer id = null;
	
	@NotEmpty
	private String cotr_codigo = null;
	
	@NotEmpty
	private String cotr_razonSocial = null;
	
	@NotEmpty
	private String cotr_domicilio = null;
	
	@ManyToOne
	@JoinColumn(name="agencia")	
	private Agencia agencia = null;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getCotr_codigo() {
		return cotr_codigo;
	}
	public void setCotr_codigo(String cotr_codigo) {
		this.cotr_codigo = cotr_codigo;
	}

	public String getCotr_razonSocial() {
		return cotr_razonSocial;
	}
	public void setCotr_razonSocial(String cotr_razonSocial) {
		this.cotr_razonSocial = cotr_razonSocial;
	}

	public String getCotr_domicilio() {
		return cotr_domicilio;
	}
	public void setCotr_domicilio(String cotr_domicilio) {
		this.cotr_domicilio = cotr_domicilio;
	}

	public Agencia getAgencia() {
		return agencia;
	}
	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}
	
	public CompaniaTransporte() {
		super();	
	}
	
	public CompaniaTransporte(Integer id, String cotr_codigo,
			String cotr_razonSocial, String cotr_domicilio, Agencia agencia) {
		super();
		this.id = id;
		this.cotr_codigo = cotr_codigo;
		this.cotr_razonSocial = cotr_razonSocial;
		this.cotr_domicilio = cotr_domicilio;
		this.agencia = agencia;
	}
	
	@Override
	public String toString() {
		return "CompaniaTransporte [id=" + id + ", cotr_codigo=" + cotr_codigo
				+ ", cotr_razonSocial=" + cotr_razonSocial
				+ ", cotr_domicilio=" + cotr_domicilio + ", agencia=" + agencia
				+ "]";
	}
	
	public String toStringCodigoNombre() {

		return cotr_codigo + " - " +  cotr_razonSocial;
	}

}
