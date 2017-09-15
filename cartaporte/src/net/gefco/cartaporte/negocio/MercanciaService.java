package net.gefco.cartaporte.negocio;

import java.util.List;

import net.gefco.cartaporte.modelo.CartaPorte;
import net.gefco.cartaporte.modelo.Mercancia;
import net.gefco.cartaporte.persistencia.MercanciaDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MercanciaService {

	@Autowired
	private MercanciaDao mercanciaDao;

	public void guardar(Mercancia mercancia) {		
		mercanciaDao.guardar(mercancia);
	}

	public void actualizar(Mercancia mercancia) {		
		mercanciaDao.actualizar(mercancia);
	}	
	
	public void eliminar(Mercancia mercancia) {		
		mercanciaDao.eliminar(mercancia);
	}
	
	public List<Mercancia> listarMercancias(CartaPorte cartaPorte){
		return mercanciaDao.listarMercancias(cartaPorte);
	}
	
	public Mercancia buscarMercancia(Integer id){
		return mercanciaDao.buscarMercancia(id);
	}
	
}