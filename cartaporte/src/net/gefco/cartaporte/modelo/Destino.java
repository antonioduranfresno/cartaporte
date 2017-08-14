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
@Table(name="destino")
public class Destino implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id 					= null;
		
	@ManyToOne
	@JoinColumn(name="agencia")	
	private Agencia agencia 			= null;
	
	private String  dest_destinatario 	= null;
	
	private String  dest_direccion		= null;
	
	private String  dest_provincia		= null;

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

	public String getDest_destinatario() {
		return dest_destinatario;
	}
	public void setDest_destinatario(String dest_destinatario) {
		this.dest_destinatario = dest_destinatario;
	}

	public String getDest_direccion() {
		return dest_direccion;
	}
	public void setDest_direccion(String dest_direccion) {
		this.dest_direccion = dest_direccion;
	}

	public String getDest_provincia() {
		return dest_provincia;
	}
	public void setDest_provincia(String dest_provincia) {
		this.dest_provincia = dest_provincia;
	}

	public Destino() {
		super();	
	}

	public Destino(Integer id, Agencia agencia, String dest_destinatario,
			String dest_direccion, String dest_provincia) {
		super();
		this.id = id;
		this.agencia = agencia;
		this.dest_destinatario = dest_destinatario;
		this.dest_direccion = dest_direccion;
		this.dest_provincia = dest_provincia;
	}

	@Override
	public String toString() {
		return "Destino [id=" + id + ", agencia=" + agencia
				+ ", dest_destinatario=" + dest_destinatario
				+ ", dest_direccion=" + dest_direccion + ", dest_provincia="
				+ dest_provincia + "]";
	}
	
	
	
}
