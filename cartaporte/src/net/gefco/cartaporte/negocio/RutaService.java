package net.gefco.cartaporte.negocio;

import java.util.List;

import net.gefco.cartaporte.modelo.Agencia;
import net.gefco.cartaporte.modelo.Ruta;
import net.gefco.cartaporte.persistencia.RutaDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RutaService {

	@Autowired
	private RutaDao rutaDao;

	public void guardar(Ruta ruta) {		
		rutaDao.guardar(ruta);
	}
	
	public void actualizar(Ruta ruta) {		
		rutaDao.actualizar(ruta);
	}	
	
	public void eliminar(Ruta ruta) {		
		rutaDao.eliminar(ruta);
	}
	
	public List<Ruta> listarRutas(Agencia agencia){
		return rutaDao.listarRutas(agencia);
	}
	
}