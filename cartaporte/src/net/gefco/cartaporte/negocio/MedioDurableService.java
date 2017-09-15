package net.gefco.cartaporte.negocio;

import java.util.List;

import net.gefco.cartaporte.modelo.CartaPorte;
import net.gefco.cartaporte.modelo.MedioDurable;
import net.gefco.cartaporte.persistencia.MedioDurableDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedioDurableService {

	@Autowired
	private MedioDurableDao medioDurableDao;

	public void guardar(MedioDurable medioDurable) {		
		medioDurableDao.guardar(medioDurable);
	}

	public void actualizar(MedioDurable medioDurable) {		
		medioDurableDao.actualizar(medioDurable);
	}	
	
	public void eliminar(MedioDurable medioDurable) {		
		medioDurableDao.eliminar(medioDurable);
	}
	
	public List<MedioDurable> listarMediosDurables(CartaPorte cartaPorte){
		return medioDurableDao.listarMediosDurables(cartaPorte);
	}
	
	public MedioDurable buscarMedioDurable(Integer id){
		return medioDurableDao.buscarMedioDurable(id);
	}
}