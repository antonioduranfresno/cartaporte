package net.gefco.cartaporte.negocio;

import java.util.List;

import net.gefco.cartaporte.modelo.UO;
import net.gefco.cartaporte.persistencia.UODao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UOService {

	@Autowired
	private UODao uoDao;

	public void guardar(UO uo) {		
		uoDao.guardar(uo);
	}
	
	public void actualizar(UO uo) {		
		uoDao.actualizar(uo);
	}	
	
	public void eliminar(UO uo) {		
		uoDao.eliminar(uo);
	}
	
	public List<UO> listarUnidadesOperacionales(){
		return uoDao.listarUnidadesOperacionales();
	}
	
}