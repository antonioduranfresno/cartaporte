package net.gefco.cartaporte.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="uo")
public class UO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="id")	
	private Integer id 		= null;
	
	private String uo_codigo 	= null;
	
	private String uo_nombre 	= null;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getUo_codigo() {
		return uo_codigo;
	}
	public void setUo_codigo(String uo_codigo) {
		this.uo_codigo = uo_codigo;
	}
	
	public String getUo_nombre() {
		return uo_nombre;
	}
	public void setUo_nombre(String uo_nombre) {
		this.uo_nombre = uo_nombre;
	}
	
	public UO() {
		super();	
	}
	
	public UO(Integer id, String uo_codigo, String uo_nombre) {
		super();
		this.id = id;
		this.uo_codigo = uo_codigo;
		this.uo_nombre = uo_nombre;
	}
	
	@Override
	public String toString() {
		return "UO [id=" + id + ", uo_codigo=" + uo_codigo + ", uo_nombre=" + uo_nombre
				+ "]";
	}

}
