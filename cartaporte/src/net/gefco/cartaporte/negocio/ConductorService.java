package net.gefco.cartaporte.negocio;

import java.util.List;

import net.gefco.cartaporte.modelo.Agencia;
import net.gefco.cartaporte.modelo.CompaniaTransporte;
import net.gefco.cartaporte.modelo.Conductor;
import net.gefco.cartaporte.persistencia.ConductorDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConductorService {

	@Autowired
	private ConductorDao conductorDao;

	public void guardar(Conductor conductor) {		
		conductorDao.guardar(conductor);
	}
	
	public void actualizar(Conductor conductor) {		
		conductorDao.actualizar(conductor);
	}	
	
	public void eliminar(Conductor conductor) {		
		conductorDao.eliminar(conductor);
	}
	
	public List<Conductor> listarConductores(CompaniaTransporte companiaTransporte){
		return conductorDao.listarConductores(companiaTransporte);
	}
	
	public List<Conductor> listarConductoresAgencia(Agencia agencia){
		return conductorDao.listarConductoresAgencia(agencia);
	}
		
	public Conductor buscarConductor(Integer id){
		return conductorDao.buscarConductor(id);
	}
	
}