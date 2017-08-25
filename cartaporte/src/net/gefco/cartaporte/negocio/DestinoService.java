package net.gefco.cartaporte.negocio;

import java.util.List;

import net.gefco.cartaporte.modelo.Agencia;
import net.gefco.cartaporte.modelo.Destino;
import net.gefco.cartaporte.persistencia.DestinoDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DestinoService {

	@Autowired
	private DestinoDao destinoDao;

	public void guardar(Destino destino) {		
		destinoDao.guardar(destino);
	}
	
	public void actualizar(Destino destino) {		
		destinoDao.actualizar(destino);
	}	
	
	public void eliminar(Destino destino) {		
		destinoDao.eliminar(destino);
	}
	
	public List<Destino> listarDestinos(Agencia agencia){
		return destinoDao.listarDestinos(agencia);
	}
		
	public Destino buscarDestino(Integer id){
		return destinoDao.buscarDestino(id);
	}
}