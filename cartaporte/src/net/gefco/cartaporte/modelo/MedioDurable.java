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

@Entity
@Table(name="mediodurable")
public class MedioDurable implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id 							= null;
	
	@ManyToOne
	@JoinColumn(name="cartaporte")
	private CartaPorte cartaPorte 				= null;
	
	@ManyToOne
	@JoinColumn(name="tipomediodurable")
	private TipoMedioDurable tipoMedioDurable 	= null;
	
	@NotNull
	private Integer medu_cantidad				= null;
	
	private String  medu_observaciones			= null;

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

	public TipoMedioDurable getTipoMedioDurable() {
		return tipoMedioDurable;
	}

	public void setTipoMedioDurable(TipoMedioDurable tipoMedioDurable) {
		this.tipoMedioDurable = tipoMedioDurable;
	}

	public Integer getMedu_cantidad() {
		return medu_cantidad;
	}

	public void setMedu_cantidad(Integer medu_cantidad) {
		this.medu_cantidad = medu_cantidad;
	}

	public String getMedu_observaciones() {
		return medu_observaciones;
	}

	public void setMedu_observaciones(String medu_observaciones) {
		this.medu_observaciones = medu_observaciones;
	}

	public MedioDurable() {
		super();
	}

	public MedioDurable(Integer id, CartaPorte cartaPorte,
			TipoMedioDurable tipoMedioDurable, Integer medu_cantidad,
			String medu_observaciones) {
		super();
		this.id = id;
		this.cartaPorte = cartaPorte;
		this.tipoMedioDurable = tipoMedioDurable;
		this.medu_cantidad = medu_cantidad;
		this.medu_observaciones = medu_observaciones;
	}

	@Override
	public String toString() {
		return "MedioDurable [id=" + id + ", cartaPorte=" + cartaPorte
				+ ", tipoMedioDurable=" + tipoMedioDurable + ", medu_cantidad="
				+ medu_cantidad + ", medu_observaciones=" + medu_observaciones
				+ "]";
	}

}
