package net.gefco.cartaporte.modelo;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.gefco.cartaporte.modelo.CompaniaTransporte;


@Entity
@Table(name="conductor")
public class Conductor implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id 								= null;
	
	@ManyToOne
	@JoinColumn(name="compania_transporte")
	private CompaniaTransporte companiaTransporte 	= null;
	
	private String cond_nombre 						= null;
	
	private String cond_dni							= null;
	
	private String cond_telefono					= null;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public CompaniaTransporte getCompaniaTransporte() {
		return companiaTransporte;
	}
	public void setCompaniaTransporte(CompaniaTransporte companiaTransporte) {
		this.companiaTransporte = companiaTransporte;
	}

	public String getCond_nombre() {
		return cond_nombre;
	}
	public void setCond_nombre(String cond_nombre) {
		this.cond_nombre = cond_nombre;
	}

	public String getCond_dni() {
		return cond_dni;
	}
	public void setCond_dni(String cond_dni) {
		this.cond_dni = cond_dni;
	}

	public String getCond_telefono() {
		return cond_telefono;
	}
	public void setCond_telefono(String cond_telefono) {
		this.cond_telefono = cond_telefono;
	}
	
	public Conductor() {
		super();	
	}
	
	public Conductor(Integer id, CompaniaTransporte companiaTransporte,
			String cond_nombre, String cond_dni, String cond_telefono) {
		super();
		this.id = id;
		this.companiaTransporte = companiaTransporte;
		this.cond_nombre = cond_nombre;
		this.cond_dni = cond_dni;
		this.cond_telefono = cond_telefono;
	}
	
	@Override
	public String toString() {
		return "Conductor [id=" + id + ", companiaTransporte="
				+ companiaTransporte + ", cond_nombre=" + cond_nombre
				+ ", cond_dni=" + cond_dni + ", cond_telefono=" + cond_telefono
				+ "]";
	}
	
	
	
	
}
