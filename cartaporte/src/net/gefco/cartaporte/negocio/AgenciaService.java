package net.gefco.cartaporte.negocio;

import java.util.List;

import net.gefco.cartaporte.modelo.Agencia;
import net.gefco.cartaporte.persistencia.AgenciaDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgenciaService {

	@Autowired
	private AgenciaDao agenciaDao;

	public void guardar(Agencia agencia) {		
		agenciaDao.guardar(agencia);
	}

	public void eliminar(Agencia agencia) {		
		agenciaDao.eliminar(agencia);
	}
	
	public List<Agencia> listarAgencias(){
		return agenciaDao.listarAgencias();
	}
	
}