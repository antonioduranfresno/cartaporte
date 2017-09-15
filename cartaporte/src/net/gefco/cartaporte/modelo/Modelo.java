package net.gefco.cartaporte.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="modelo")
public class Modelo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="id")	
	private Integer 			id 				= null;
	
	private String				mode_nombre		= null;
	
	private String				mode_campo1		= null;
	
	private String				mode_campo2		= null;
	
	private String				mode_campo3		= null;
	
	private String				mode_campo4		= null;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMode_nombre() {
		return mode_nombre;
	}

	public void setMode_nombre(String mode_nombre) {
		this.mode_nombre = mode_nombre;
	}

	public String getMode_campo1() {
		return mode_campo1;
	}

	public void setMode_campo1(String mode_campo1) {
		this.mode_campo1 = mode_campo1;
	}

	public String getMode_campo2() {
		return mode_campo2;
	}

	public void setMode_campo2(String mode_campo2) {
		this.mode_campo2 = mode_campo2;
	}

	public String getMode_campo3() {
		return mode_campo3;
	}

	public void setMode_campo3(String mode_campo3) {
		this.mode_campo3 = mode_campo3;
	}

	public String getMode_campo4() {
		return mode_campo4;
	}

	public void setMode_campo4(String mode_campo4) {
		this.mode_campo4 = mode_campo4;
	}

	public Modelo() {
		super();
	}

	public Modelo(Integer id, String mode_nombre, String mode_campo1,
			String mode_campo2, String mode_campo3, String mode_campo4) {
		super();
		this.id = id;
		this.mode_nombre = mode_nombre;
		this.mode_campo1 = mode_campo1;
		this.mode_campo2 = mode_campo2;
		this.mode_campo3 = mode_campo3;
		this.mode_campo4 = mode_campo4;
	}

	@Override
	public String toString() {
		return "Modelo [id=" + id + ", mode_nombre=" + mode_nombre
				+ ", mode_campo1=" + mode_campo1 + ", mode_campo2="
				+ mode_campo2 + ", mode_campo3=" + mode_campo3
				+ ", mode_campo4=" + mode_campo4 + "]";
	}
	
	public String toStringDescripcionModelo(){
		return mode_campo1 + " / " + mode_campo2 + " / " + mode_campo3 + " / " + mode_campo4;
	}
}
