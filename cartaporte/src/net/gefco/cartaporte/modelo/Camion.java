package net.gefco.cartaporte.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Camion implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id 								= null;
	
	@ManyToOne
	@JoinColumn(name="compania_transporte")
	private CompaniaTransporte companiaTransporte 	= null;
	
	private String 	cami_matricula					= null;
	
	private Boolean cami_tractora					= null;

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

	public String getCami_matricula() {
		return cami_matricula;
	}
	public void setCami_matricula(String cami_matricula) {
		this.cami_matricula = cami_matricula;
	}

	public Boolean getCami_tractora() {
		return cami_tractora;
	}
	public void setCami_tractora(Boolean cami_tractora) {
		this.cami_tractora = cami_tractora;
	}
	
	public Camion() {
		super();	
	}
	
	public Camion(Integer id, CompaniaTransporte companiaTransporte,
			String cami_matricula, Boolean cami_tractora) {
		super();
		this.id = id;
		this.companiaTransporte = companiaTransporte;
		this.cami_matricula = cami_matricula;
		this.cami_tractora = cami_tractora;
	}
	
	@Override
	public String toString() {
		return "Camion [id=" + id + ", companiaTransporte="
				+ companiaTransporte + ", cami_matricula=" + cami_matricula
				+ ", cami_tractora=" + cami_tractora + "]";
	}

}
