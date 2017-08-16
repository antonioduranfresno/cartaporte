package net.gefco.cartaporte.negocio;

import java.util.List;

import net.gefco.cartaporte.modelo.Agencia;
import net.gefco.cartaporte.modelo.TipoTransporte;
import net.gefco.cartaporte.persistencia.TipoTransporteDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoTransporteService {

	@Autowired
	private TipoTransporteDao tipoTransporteDao;

	public void guardar(TipoTransporte tipoTransporte) {		
		tipoTransporteDao.guardar(tipoTransporte);
	}
	
	public void actualizar(TipoTransporte tipoTransporte) {		
		tipoTransporteDao.actualizar(tipoTransporte);
	}	
	
	public void eliminar(TipoTransporte tipoTransporte) {		
		tipoTransporteDao.eliminar(tipoTransporte);
	}
	
	public List<TipoTransporte> listarTiposTransporte(Agencia agencia){
		return tipoTransporteDao.listarTiposTransporte(agencia);
	}
	
}