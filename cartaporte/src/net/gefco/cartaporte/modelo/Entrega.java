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


@Entity
@Table(name="entrega")
public class Entrega implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id 					= null;
		
	@ManyToOne
	@JoinColumn(name="ruta")	
	private Ruta ruta					= null;
	
	@ManyToOne
	@JoinColumn(name="destino")	
	private Ruta destino				= null;
	
	private Double entr_importe			= null;
	
	private Date entr_hora_llegada		= null;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Ruta getRuta() {
		return ruta;
	}
	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}

	public Ruta getDestino() {
		return destino;
	}
	public void setDestino(Ruta destino) {
		this.destino = destino;
	}

	public Double getEntr_importe() {
		return entr_importe;
	}
	public void setEntr_importe(Double entr_importe) {
		this.entr_importe = entr_importe;
	}

	public Date getEntr_hora_llegada() {
		return entr_hora_llegada;
	}
	public void setEntr_hora_llegada(Date entr_hora_llegada) {
		this.entr_hora_llegada = entr_hora_llegada;
	}

	public Entrega() {
		super();		
	}

	public Entrega(Integer id, Ruta ruta, Ruta destino, Double entr_importe,
			Date entr_hora_llegada) {
		super();
		this.id = id;
		this.ruta = ruta;
		this.destino = destino;
		this.entr_importe = entr_importe;
		this.entr_hora_llegada = entr_hora_llegada;
	}

	@Override
	public String toString() {
		return "Entrega [id=" + id + ", ruta=" + ruta + ", destino=" + destino
				+ ", entr_importe=" + entr_importe + ", entr_hora_llegada="
				+ entr_hora_llegada + "]";
	}
	
	
	
}
