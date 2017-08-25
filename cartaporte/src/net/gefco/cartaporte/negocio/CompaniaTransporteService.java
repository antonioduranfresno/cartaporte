package net.gefco.cartaporte.negocio;

import java.util.List;

import net.gefco.cartaporte.modelo.Agencia;
import net.gefco.cartaporte.modelo.CompaniaTransporte;
import net.gefco.cartaporte.persistencia.CompaniaTransporteDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompaniaTransporteService {

	@Autowired
	private CompaniaTransporteDao companiaTransporteDao;

	public void guardar(CompaniaTransporte companiaTransporte) {		
		companiaTransporteDao.guardar(companiaTransporte);
	}
	
	public void actualizar(CompaniaTransporte companiaTransporte) {		
		companiaTransporteDao.actualizar(companiaTransporte);
	}	
	
	public void eliminar(CompaniaTransporte companiaTransporte) {		
		companiaTransporteDao.eliminar(companiaTransporte);
	}
	
	public List<CompaniaTransporte> listarCompaniaTransporte(Agencia agencia){
		return companiaTransporteDao.listarCompaniasTransporte(agencia);
	}
	
	public CompaniaTransporte buscarCompaniaTransporte(Integer id){
		return companiaTransporteDao.buscarCompaniaTransporte(id);
	}
	
}