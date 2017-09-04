package net.gefco.cartaporte.negocio;

import java.util.List;

import net.gefco.cartaporte.modelo.Agencia;
import net.gefco.cartaporte.modelo.Entrega;
import net.gefco.cartaporte.modelo.Ruta;
import net.gefco.cartaporte.persistencia.EntregaDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntregaService {

	@Autowired
	private EntregaDao entregaDao;

	public void guardar(Entrega entrega) {		
		entregaDao.guardar(entrega);
	}
	
	public void actualizar(Entrega entrega) {		
		entregaDao.actualizar(entrega);
	}	
	
	public void eliminar(Entrega entrega) {		
		entregaDao.eliminar(entrega);
	}
	
	public List<Entrega> listarEntregas(Ruta ruta){
		return entregaDao.listarEntregas(ruta);
	}
	
	public Entrega buscarEntrega(Integer idEntrega){
		return entregaDao.buscarEntrega(idEntrega);
	}
	
	public List<Entrega> listarEntregasAgencia(Agencia agencia){
		return entregaDao.listarEntregasAgencia(agencia);
	}
	
}