package net.gefco.cartaporte.negocio;

import java.util.List;

import net.gefco.cartaporte.modelo.Agencia;
import net.gefco.cartaporte.modelo.CartaPorte;
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
	
}