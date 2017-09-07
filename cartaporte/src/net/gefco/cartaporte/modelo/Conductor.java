package net.gefco.cartaporte.modelo;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="conductor")
public class Conductor implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id 								= null;
	
	@ManyToOne
	@JoinColumn(name="companiaTransporte")
	@NotNull
	private CompaniaTransporte companiaTransporte 	= null;
	
	@NotEmpty
	private String cond_nombre 						= null;
	
	@NotEmpty
	private String cond_carne							= null;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date   cond_fechaExpedicion				= null;
	
	@NotEmpty
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

	public String getCond_carne() {
		return cond_carne;
	}
	public void setCond_carne(String cond_carne) {
		this.cond_carne = cond_carne;
	}
	
	public Date getCond_fechaExpedicion() {
		return cond_fechaExpedicion;
	}
	public void setCond_fechaExpedicion(Date cond_fechaExpedicion) {
		this.cond_fechaExpedicion = cond_fechaExpedicion;
	}
	
	public String getCond_telefono() {
		return cond_telefono;
	}
	public void setCond_telefono(String cond_telefono) {
		this.cond_telefono = cond_telefono;
	}
	
	public String getCond_fechaExpedicionFormateada(){
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		String fecha = "";
		
		if(cond_fechaExpedicion!=null){
			fecha = sdf.format(cond_fechaExpedicion);
		}
				
		return fecha;
	}
	
	public Conductor() {
		super();	
	}
	
	public Conductor(Integer id, CompaniaTransporte companiaTransporte,
			String cond_nombre, String cond_carne, Date cond_fechaExpedicion,
			String cond_telefono) {
		super();
		this.id = id;
		this.companiaTransporte = companiaTransporte;
		this.cond_nombre = cond_nombre;
		this.cond_carne = cond_carne;
		this.cond_fechaExpedicion = cond_fechaExpedicion;
		this.cond_telefono = cond_telefono;
	}
	
	@Override
	public String toString() {
		return "Conductor [id=" + id + ", companiaTransporte="
				+ companiaTransporte + ", cond_nombre=" + cond_nombre
				+ ", cond_carne=" + cond_carne + ", cond_fechaExpedicion="
				+ cond_fechaExpedicion + ", cond_telefono=" + cond_telefono
				+ "]";
	}
	
}
