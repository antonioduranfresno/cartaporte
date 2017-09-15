package net.gefco.cartaporte.negocio;

import java.util.List;

import net.gefco.cartaporte.modelo.Modelo;
import net.gefco.cartaporte.persistencia.ModeloDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModeloService {

	@Autowired
	private ModeloDao modeloDao;

	public void guardar(Modelo modelo) {		
		modeloDao.guardar(modelo);
	}
	
	public void actualizar(Modelo modelo) {		
		modeloDao.actualizar(modelo);
	}	
	
	public void eliminar(Modelo modelo) {		
		modeloDao.eliminar(modelo);
	}

	public List<Modelo> listarModelos(){
		return modeloDao.listarModelos();
	}
	
}