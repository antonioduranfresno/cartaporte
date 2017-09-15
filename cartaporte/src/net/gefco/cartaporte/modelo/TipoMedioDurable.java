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
@Table(name="tipomediodurable")
public class TipoMedioDurable implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id 				= null;
	
	@ManyToOne
	@JoinColumn(name="agencia")
	private Agencia agencia			= null;
	
	@NotEmpty
	private String timd_codigo		= null;
	
	@NotEmpty
	private String timd_descripcion = null;

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

	public String getTimd_codigo() {
		return timd_codigo;
	}

	public void setTimd_codigo(String timd_codigo) {
		this.timd_codigo = timd_codigo;
	}

	public String getTimd_descripcion() {
		return timd_descripcion;
	}

	public void setTimd_descripcion(String timd_descripcion) {
		this.timd_descripcion = timd_descripcion;
	}

	public TipoMedioDurable() {
		super();
	}

	public TipoMedioDurable(Integer id, Agencia agencia, String timd_codigo,
			String timd_descripcion) {
		super();
		this.id = id;
		this.agencia = agencia;
		this.timd_codigo = timd_codigo;
		this.timd_descripcion = timd_descripcion;
	}

	@Override
	public String toString() {
		return "TipoMedioDurable [id=" + id + ", agencia=" + agencia
				+ ", timd_codigo=" + timd_codigo + ", timd_descripcion="
				+ timd_descripcion + "]";
	}
		
	public String toStringCodigoDescripcion() {
		return timd_codigo + " - " + timd_descripcion ;
	}
	
}
