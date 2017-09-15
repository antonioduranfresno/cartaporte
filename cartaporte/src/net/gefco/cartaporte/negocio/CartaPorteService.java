package net.gefco.cartaporte.negocio;

import java.util.List;

import net.gefco.cartaporte.modelo.Agencia;
import net.gefco.cartaporte.modelo.CartaPorte;
import net.gefco.cartaporte.modelo.RutaInfo;
import net.gefco.cartaporte.persistencia.CartaPorteDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartaPorteService {

	@Autowired
	private CartaPorteDao cartaPorteDao;

	public void guardar(CartaPorte cartaPorte) {		
		cartaPorteDao.guardar(cartaPorte);
	}
	
	public void actualizar(CartaPorte cartaPorte) {		
		cartaPorteDao.actualizar(cartaPorte);
	}	

	public void eliminar(CartaPorte cartaPorte) {		
		cartaPorteDao.eliminar(cartaPorte);
	}
	
	public List<CartaPorte> listarCartasPendientes(Agencia agencia){
		return cartaPorteDao.listarCartasPendientes(agencia);
	}
	
	public List<CartaPorte> listarCartasEmitidas(Agencia agencia){
		return cartaPorteDao.listarCartasEmitidas(agencia);
	}
	
	public CartaPorte buscarCartaPorte(Integer id){
		return cartaPorteDao.buscarCartaPorte(id);
	}
	
	public List<RutaInfo> listarRutasPendientes(Agencia agencia){
		return cartaPorteDao.listarRutasPendientes(agencia);
	}
	
	public List<CartaPorte> listarCartasPendientesRuta(String secuenciaRuta){
		return cartaPorteDao.listarCartasPendientesRuta(secuenciaRuta);
	}

	public String calculaNumeroCarta(Agencia agencia, Integer anyo){
				
		return String.format("%05d", cartaPorteDao.ultimaCartaPorte(agencia, anyo)+1)+"/"+anyo.toString().substring(2, 4)+"/"+agencia.getAgen_codigo();
	}
	
}