package net.gefco.cartaporte.negocio;

import java.util.List;

import net.gefco.cartaporte.modelo.Agencia;
import net.gefco.cartaporte.modelo.Camion;
import net.gefco.cartaporte.modelo.CompaniaTransporte;
import net.gefco.cartaporte.persistencia.CamionDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CamionService {

	@Autowired
	private CamionDao camionDao;

	public void guardar(Camion camion) {		
		camionDao.guardar(camion);
	}
	
	public void actualizar(Camion camion) {		
		camionDao.actualizar(camion);
	}	
	
	public void eliminar(Camion camion) {		
		camionDao.eliminar(camion);
	}
	
	public List<Camion> listarCamiones(CompaniaTransporte companiaTransporte){
		return camionDao.listarCamiones(companiaTransporte);
	}
	
	public List<Camion> listarCamionesAgencia(Agencia agencia){
		return camionDao.listarCamionesAgencia(agencia);
	}
	
	public Camion buscarCamion(Integer id){
		return camionDao.buscarCamion(id);
	}
	
	public List<Camion> listarCamionesTractores(CompaniaTransporte companiaTransporte){
		return camionDao.listarCamionesTractores(companiaTransporte);
	}
	
	public List<Camion> listarCamionesNoTractores(CompaniaTransporte companiaTransporte){
		return camionDao.listarCamionesNoTractores(companiaTransporte);
	}
	
}