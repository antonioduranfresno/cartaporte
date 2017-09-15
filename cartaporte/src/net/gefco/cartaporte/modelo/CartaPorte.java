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
@Table(name="cartaPorte")
public class CartaPorte implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="id")	
	private Integer 			id 									= null;
	
	@ManyToOne
	@JoinColumn(name="agencia")	
	private Agencia 			agencia 							= null;
	
	private String 				capo_numeroCarta 					= null;
	
	private String 				capo_precinto 						= null;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date				capo_fechaDocumentacion				= null;
	
	@ManyToOne
	@JoinColumn(name="companiaTransporte")
	private CompaniaTransporte	companiaTransporte					= null;
	
	private String 	capo_codigoCompania								= null;
	
	private String 	capo_razonSocialCompania						= null;
	
	private String 	capo_domicilioCompania							= null;
	
	private String  capo_cifCompania								= null;
	
	private String 	capo_codigoCompaniaEfectiva						= null;
	
	private String 	capo_razonSocialCompaniaEfectiva				= null;
	
	private String 	capo_domicilioCompaniaEfectiva					= null;
	
	private String  capo_cifCompaniaEfectiva						= null;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date 	capo_fechaSalida								= null;
	
	@NotEmpty
	private String 	capo_destinatario								= null;
	
	@NotEmpty
	private String 	capo_direccion									= null;
	
	@NotEmpty
	private String 	capo_provincia									= null;
	
	@ManyToOne
	@JoinColumn(name="tipoTransporte")
	private TipoTransporte tipoTransporte							= null;
	
	@NotNull
	private Double 	capo_importe									= null;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date   	capo_fechaLlegada								= null;
	
	private String 	capo_contactoAgencia							= null;
	
	private String 	capo_telefonoContacto							= null;
		
	@ManyToOne
	@JoinColumn(name="conductor")
	private Conductor conductor										= null;
	
	private String  capo_telefonoConductor							= null;
	
	private String 	capo_matriculaTractora							= null;
	
	private String 	capo_matriculaRemolque							= null;
	
	private Boolean	capo_emitida									= null;
	
	private String	capo_secuenciaRuta								= null;

	@ManyToOne
	@JoinColumn(name="modelo")
	private Modelo	modelo											= null;
	
	private String  capo_destinoMedioDurable						= null;
	
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

	public String getCapo_numeroCarta() {
		return capo_numeroCarta;
	}

	public void setCapo_numeroCarta(String capo_numeroCarta) {
		this.capo_numeroCarta = capo_numeroCarta;
	}

	public String getCapo_precinto() {
		return capo_precinto;
	}

	public void setCapo_precinto(String capo_precinto) {
		this.capo_precinto = capo_precinto;
	}

	public Date getCapo_fechaDocumentacion() {
		return capo_fechaDocumentacion;
	}

	public void setCapo_fechaDocumentacion(Date capo_fechaDocumentacion) {
		this.capo_fechaDocumentacion = capo_fechaDocumentacion;
	}

	public CompaniaTransporte getCompaniaTransporte() {
		return companiaTransporte;
	}

	public void setCompaniaTransporte(CompaniaTransporte companiaTransporte) {
		this.companiaTransporte = companiaTransporte;
	}

	public String getCapo_codigoCompania() {
		return capo_codigoCompania;
	}

	public void setCapo_codigoCompania(String capo_codigoCompania) {
		this.capo_codigoCompania = capo_codigoCompania;
	}

	public String getCapo_razonSocialCompania() {
		return capo_razonSocialCompania;
	}

	public void setCapo_razonSocialCompania(String capo_razonSocialCompania) {
		this.capo_razonSocialCompania = capo_razonSocialCompania;
	}

	public String getCapo_domicilioCompania() {
		return capo_domicilioCompania;
	}

	public void setCapo_domicilioCompania(String capo_domicilioCompania) {
		this.capo_domicilioCompania = capo_domicilioCompania;
	}

	public String getCapo_cifCompania() {
		return capo_cifCompania;
	}

	public void setCapo_cifCompania(String capo_cifCompania) {
		this.capo_cifCompania = capo_cifCompania;
	}

	public String getCapo_codigoCompaniaEfectiva() {
		return capo_codigoCompaniaEfectiva;
	}

	public void setCapo_codigoCompaniaEfectiva(String capo_codigoCompaniaEfectiva) {
		this.capo_codigoCompaniaEfectiva = capo_codigoCompaniaEfectiva;
	}

	public String getCapo_razonSocialCompaniaEfectiva() {
		return capo_razonSocialCompaniaEfectiva;
	}

	public void setCapo_razonSocialCompaniaEfectiva(
			String capo_razonSocialCompaniaEfectiva) {
		this.capo_razonSocialCompaniaEfectiva = capo_razonSocialCompaniaEfectiva;
	}

	public String getCapo_domicilioCompaniaEfectiva() {
		return capo_domicilioCompaniaEfectiva;
	}

	public void setCapo_domicilioCompaniaEfectiva(
			String capo_domicilioCompaniaEfectiva) {
		this.capo_domicilioCompaniaEfectiva = capo_domicilioCompaniaEfectiva;
	}

	public String getCapo_cifCompaniaEfectiva() {
		return capo_cifCompaniaEfectiva;
	}

	public void setCapo_cifCompaniaEfectiva(String capo_cifCompaniaEfectiva) {
		this.capo_cifCompaniaEfectiva = capo_cifCompaniaEfectiva;
	}

	public Date getCapo_fechaSalida() {
		return capo_fechaSalida;
	}

	public void setCapo_fechaSalida(Date capo_fechaSalida) {
		this.capo_fechaSalida = capo_fechaSalida;
	}

	public String getCapo_destinatario() {
		return capo_destinatario;
	}

	public void setCapo_destinatario(String capo_destinatario) {
		this.capo_destinatario = capo_destinatario;
	}

	public String getCapo_direccion() {
		return capo_direccion;
	}

	public void setCapo_direccion(String capo_direccion) {
		this.capo_direccion = capo_direccion;
	}

	public String getCapo_provincia() {
		return capo_provincia;
	}

	public void setCapo_provincia(String capo_provincia) {
		this.capo_provincia = capo_provincia;
	}

	public TipoTransporte getTipoTransporte() {
		return tipoTransporte;
	}

	public void setTipoTransporte(TipoTransporte tipoTransporte) {
		this.tipoTransporte = tipoTransporte;
	}

	public Double getCapo_importe() {
		return capo_importe;
	}

	public void setCapo_importe(Double capo_importe) {
		this.capo_importe = capo_importe;
	}

	public Date getCapo_fechaLlegada() {
		return capo_fechaLlegada;
	}

	public void setCapo_fechaLlegada(Date capo_fechaLlegada) {
		this.capo_fechaLlegada = capo_fechaLlegada;
	}

	public String getCapo_contactoAgencia() {
		return capo_contactoAgencia;
	}

	public void setCapo_contactoAgencia(String capo_contactoAgencia) {
		this.capo_contactoAgencia = capo_contactoAgencia;
	}

	public String getCapo_telefonoContacto() {
		return capo_telefonoContacto;
	}

	public void setCapo_telefonoContacto(String capo_telefonoContacto) {
		this.capo_telefonoContacto = capo_telefonoContacto;
	}

	public Conductor getConductor() {
		return conductor;
	}

	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}

	public String getCapo_telefonoConductor() {
		return capo_telefonoConductor;
	}

	public void setCapo_telefonoConductor(String capo_telefonoConductor) {
		this.capo_telefonoConductor = capo_telefonoConductor;
	}

	public String getCapo_matriculaTractora() {
		return capo_matriculaTractora;
	}

	public void setCapo_matriculaTractora(String capo_matriculaTractora) {
		this.capo_matriculaTractora = capo_matriculaTractora;
	}

	public String getCapo_matriculaRemolque() {
		return capo_matriculaRemolque;
	}

	public void setCapo_matriculaRemolque(String capo_matriculaRemolque) {
		this.capo_matriculaRemolque = capo_matriculaRemolque;
	}

	public Boolean getCapo_emitida() {
		return capo_emitida;
	}

	public void setCapo_emitida(Boolean capo_emitida) {
		this.capo_emitida = capo_emitida;
	}

	public String getCapo_secuenciaRuta() {
		return capo_secuenciaRuta;
	}

	public void setCapo_secuenciaRuta(String capo_secuenciaRuta) {
		this.capo_secuenciaRuta = capo_secuenciaRuta;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public String getCapo_destinoMedioDurable() {
		return capo_destinoMedioDurable;
	}

	public void setCapo_destinoMedioDurable(String capo_destinoMedioDurable) {
		this.capo_destinoMedioDurable = capo_destinoMedioDurable;
	}

	public String getCapo_fechaHoraDocumentacionFormateada() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		return sdf.format(capo_fechaDocumentacion);
	}

	public String getCapo_fechaHoraSalidaFormateada() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		return sdf.format(capo_fechaSalida);
	}
	
	public String getCapo_fechaHoraLlegadaFormateada() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		return sdf.format(capo_fechaLlegada);
	}
	
	public CartaPorte() {
		super();
	}

	public CartaPorte(Integer id, Agencia agencia, String capo_numeroCarta,
			String capo_precinto, Date capo_fechaDocumentacion,
			CompaniaTransporte companiaTransporte, String capo_codigoCompania,
			String capo_razonSocialCompania, String capo_domicilioCompania,
			String capo_cifCompania, String capo_codigoCompaniaEfectiva,
			String capo_razonSocialCompaniaEfectiva,
			String capo_domicilioCompaniaEfectiva,
			String capo_cifCompaniaEfectiva, Date capo_fechaSalida,
			String capo_destinatario, String capo_direccion,
			String capo_provincia, TipoTransporte tipoTransporte,
			Double capo_importe, Date capo_fechaLlegada,
			String capo_contactoAgencia, String capo_telefonoContacto,
			Conductor conductor, String capo_telefonoConductor,
			String capo_matriculaTractora, String capo_matriculaRemolque,
			Boolean capo_emitida, String capo_secuenciaRuta, Modelo modelo,
			String capo_destinoMedioDurable) {
		super();
		this.id = id;
		this.agencia = agencia;
		this.capo_numeroCarta = capo_numeroCarta;
		this.capo_precinto = capo_precinto;
		this.capo_fechaDocumentacion = capo_fechaDocumentacion;
		this.companiaTransporte = companiaTransporte;
		this.capo_codigoCompania = capo_codigoCompania;
		this.capo_razonSocialCompania = capo_razonSocialCompania;
		this.capo_domicilioCompania = capo_domicilioCompania;
		this.capo_cifCompania = capo_cifCompania;
		this.capo_codigoCompaniaEfectiva = capo_codigoCompaniaEfectiva;
		this.capo_razonSocialCompaniaEfectiva = capo_razonSocialCompaniaEfectiva;
		this.capo_domicilioCompaniaEfectiva = capo_domicilioCompaniaEfectiva;
		this.capo_cifCompaniaEfectiva = capo_cifCompaniaEfectiva;
		this.capo_fechaSalida = capo_fechaSalida;
		this.capo_destinatario = capo_destinatario;
		this.capo_direccion = capo_direccion;
		this.capo_provincia = capo_provincia;
		this.tipoTransporte = tipoTransporte;
		this.capo_importe = capo_importe;
		this.capo_fechaLlegada = capo_fechaLlegada;
		this.capo_contactoAgencia = capo_contactoAgencia;
		this.capo_telefonoContacto = capo_telefonoContacto;
		this.conductor = conductor;
		this.capo_telefonoConductor = capo_telefonoConductor;
		this.capo_matriculaTractora = capo_matriculaTractora;
		this.capo_matriculaRemolque = capo_matriculaRemolque;
		this.capo_emitida = capo_emitida;
		this.capo_secuenciaRuta = capo_secuenciaRuta;
		this.modelo = modelo;
		this.capo_destinoMedioDurable = capo_destinoMedioDurable;
	}

	@Override
	public String toString() {
		return "CartaPorte [id=" + id + ", agencia=" + agencia
				+ ", capo_numeroCarta=" + capo_numeroCarta + ", capo_precinto="
				+ capo_precinto + ", capo_fechaDocumentacion="
				+ capo_fechaDocumentacion + ", companiaTransporte="
				+ companiaTransporte + ", capo_codigoCompania="
				+ capo_codigoCompania + ", capo_razonSocialCompania="
				+ capo_razonSocialCompania + ", capo_domicilioCompania="
				+ capo_domicilioCompania + ", capo_cifCompania="
				+ capo_cifCompania + ", capo_codigoCompaniaEfectiva="
				+ capo_codigoCompaniaEfectiva
				+ ", capo_razonSocialCompaniaEfectiva="
				+ capo_razonSocialCompaniaEfectiva
				+ ", capo_domicilioCompaniaEfectiva="
				+ capo_domicilioCompaniaEfectiva
				+ ", capo_cifCompaniaEfectiva=" + capo_cifCompaniaEfectiva
				+ ", capo_fechaSalida=" + capo_fechaSalida
				+ ", capo_destinatario=" + capo_destinatario
				+ ", capo_direccion=" + capo_direccion + ", capo_provincia="
				+ capo_provincia + ", tipoTransporte=" + tipoTransporte
				+ ", capo_importe=" + capo_importe + ", capo_fechaLlegada="
				+ capo_fechaLlegada + ", capo_contactoAgencia="
				+ capo_contactoAgencia + ", capo_telefonoContacto="
				+ capo_telefonoContacto + ", conductor=" + conductor
				+ ", capo_telefonoConductor=" + capo_telefonoConductor
				+ ", capo_matriculaTractora=" + capo_matriculaTractora
				+ ", capo_matriculaRemolque=" + capo_matriculaRemolque
				+ ", capo_emitida=" + capo_emitida + ", capo_secuenciaRuta="
				+ capo_secuenciaRuta + ", modelo=" + modelo
				+ ", capo_destinoMedioDurable=" + capo_destinoMedioDurable
				+ "]";
	}

}