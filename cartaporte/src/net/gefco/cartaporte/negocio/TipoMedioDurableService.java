package net.gefco.cartaporte.negocio;

import java.util.List;

import net.gefco.cartaporte.modelo.Agencia;
import net.gefco.cartaporte.modelo.TipoMedioDurable;
import net.gefco.cartaporte.persistencia.TipoMedioDurableDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoMedioDurableService {

	@Autowired
	private TipoMedioDurableDao tipoMedioDurableDao;

	public void guardar(TipoMedioDurable tipoMedioDurable) {		
		tipoMedioDurableDao.guardar(tipoMedioDurable);
	}
	
	public void actualizar(TipoMedioDurable tipoMedioDurable) {		
		tipoMedioDurableDao.actualizar(tipoMedioDurable);
	}	
	
	public void eliminar(TipoMedioDurable tipoMedioDurable) {		
		tipoMedioDurableDao.eliminar(tipoMedioDurable);
	}
	
	public List<TipoMedioDurable> listarTiposMediosDurablesAgencia(Agencia agencia){
		return tipoMedioDurableDao.listarTiposMediosDurablesAgencia(agencia);
	}
	
	public TipoMedioDurable buscarTipoMedioDurable(Integer id){
		return tipoMedioDurableDao.buscarTipoMedioDurable(id);
	}
	
}