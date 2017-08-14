package net.gefco.cartaporte.negocio;

import net.gefco.cartaporte.modelo.Usuario;
import net.gefco.cartaporte.persistencia.UsuarioDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioDao usuarioDao;

	public void guardar(Usuario usuario) {		
		usuarioDao.guardar(usuario);
	}

	public void eliminar(Usuario usuario) {		
		usuarioDao.eliminar(usuario);
	}

	public Usuario buscarMatricula(String matricula){
		return usuarioDao.buscarMatricula(matricula);
	}
}