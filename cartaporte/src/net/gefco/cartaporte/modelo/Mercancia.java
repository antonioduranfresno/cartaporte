package net.gefco.cartaporte.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="mercancia")
public class Mercancia implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="id")	
	private Integer 			id 				= null;
	
	@ManyToOne
	@JoinColumn(name="cartaPorte")	
	private CartaPorte cartaPorte				= null;
	
	@NotEmpty
	private String				merc_campo1		= null;
	
	@NotEmpty
	private String				merc_campo2		= null;
	
	@NotNull	
	private Double				merc_campo3		= null;
	
	private String				merc_campo4		= null;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public CartaPorte getCartaPorte() {
		return cartaPorte;
	}
	public void setCartaPorte(CartaPorte cartaPorte) {
		this.cartaPorte = cartaPorte;
	}

	public String getMerc_campo1() {
		return merc_campo1;
	}
	public void setMerc_campo1(String merc_campo1) {
		this.merc_campo1 = merc_campo1;
	}

	public String getMerc_campo2() {
		return merc_campo2;
	}
	public void setMerc_campo2(String merc_campo2) {
		this.merc_campo2 = merc_campo2;
	}

	public Double getMerc_campo3() {
		return merc_campo3;
	}
	public void setMerc_campo3(Double merc_campo3) {
		this.merc_campo3 = merc_campo3;
	}

	public String getMerc_campo4() {
		return merc_campo4;
	}
	public void setMerc_campo4(String merc_campo4) {
		this.merc_campo4 = merc_campo4;
	}
	
	public Mercancia() {
		super();		
	}
	
	public Mercancia(Integer id, CartaPorte cartaPorte, String merc_campo1,
			String merc_campo2, Double merc_campo3, String merc_campo4) {
		super();
		this.id = id;
		this.cartaPorte = cartaPorte;
		this.merc_campo1 = merc_campo1;
		this.merc_campo2 = merc_campo2;
		this.merc_campo3 = merc_campo3;
		this.merc_campo4 = merc_campo4;
	}
	
	@Override
	public String toString() {
		return "Mercancia [id=" + id + ", cartaPorte=" + cartaPorte
				+ ", merc_campo1=" + merc_campo1 + ", merc_campo2="
				+ merc_campo2 + ", merc_campo3=" + merc_campo3
				+ ", merc_campo4=" + merc_campo4 + "]";
	}
	
	

}
