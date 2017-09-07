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
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

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
	private Destino destino				= null;
	
	@NotNull
	private Double entr_importe			= null;
	
	@DateTimeFormat(pattern = "HH:mm")
	private Date entr_horaLlegada		= null;

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

	public Destino getDestino() {
		return destino;
	}
	public void setDestino(Destino destino) {
		this.destino = destino;
	}

	public Double getEntr_importe() {
		return entr_importe;
	}
	public void setEntr_importe(Double entr_importe) {
		this.entr_importe = entr_importe;
	}

	public Date getEntr_horaLlegada() {
		return entr_horaLlegada;
	}
	public void setEntr_horaLlegada(Date entr_horaLlegada) {
		this.entr_horaLlegada = entr_horaLlegada;
	}

	//Formateo horas
	public String getEntr_horaLlegadaFormateada() {
		return entr_horaLlegada.toString().substring(11, 16);
	}
	
	public Integer getEntr_soloHoraLlegadaFormateada() {
		return new Integer(entr_horaLlegada.toString().substring(11, 13));
	}
	
	public Integer getEntr_soloMinutosLlegadaFormateada() {
		return new Integer(entr_horaLlegada.toString().substring(14, 16));
	}
	
	public Entrega() {
		super();		
	}

	public Entrega(Integer id, Ruta ruta, Destino destino, Double entr_importe,
			Date entr_horaLlegada) {
		super();
		this.id = id;
		this.ruta = ruta;
		this.destino = destino;
		this.entr_importe = entr_importe;
		this.entr_horaLlegada = entr_horaLlegada;
	}

	@Override
	public String toString() {
		return "Entrega [id=" + id + ", ruta=" + ruta + ", destino=" + destino
				+ ", entr_importe=" + entr_importe + ", entr_horaLlegada="
				+ entr_horaLlegada + "]";
	}
	
}
