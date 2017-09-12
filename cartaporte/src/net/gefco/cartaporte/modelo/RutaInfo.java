package net.gefco.cartaporte.modelo;

import java.util.Date;

public class RutaInfo {

	private String 	secuenciaRuta 			= null;
	private String 	razonSocialCompania	 	= null;
	private Date   	fechaDocumentacion		= null;
	private Date	fechaSalida				= null;
	
	public String getSecuenciaRuta() {
		return secuenciaRuta;
	}
	public void setSecuenciaRuta(String secuenciaRuta) {
		this.secuenciaRuta = secuenciaRuta;
	}
	
	public String getRazonSocialCompania() {
		return razonSocialCompania;
	}
	public void setRazonSocialCompania(String razonSocialCompania) {
		this.razonSocialCompania = razonSocialCompania;
	}
	
	public Date getFechaDocumentacion() {
		return fechaDocumentacion;
	}
	public void setFechaDocumentacion(Date fechaDocumentacion) {
		this.fechaDocumentacion = fechaDocumentacion;
	}
	
	public Date getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	
	public RutaInfo() {
		super();	
	}
	
	public RutaInfo(String secuenciaRuta, String razonSocialCompania,
			Date fechaDocumentacion, Date fechaSalida) {
		super();
		this.secuenciaRuta = secuenciaRuta;
		this.razonSocialCompania = razonSocialCompania;
		this.fechaDocumentacion = fechaDocumentacion;
		this.fechaSalida = fechaSalida;
	}
	
	@Override
	public String toString() {
		return "RutaInfo [secuenciaRuta=" + secuenciaRuta
				+ ", razonSocialCompania=" + razonSocialCompania
				+ ", fechaDocumentacion=" + fechaDocumentacion
				+ ", fechaSalida=" + fechaSalida + "]";
	}
	
	public String toStringInfo() {
		return fechaDocumentacion.toString().subSequence(11, 16) + " / " + 
			   fechaSalida.toString().subSequence(11, 16) + " / " + razonSocialCompania;
	}
	
}
