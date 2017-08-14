package net.gefco.cartaporte.persistencia;

import net.gefco.cartaporte.modelo.Usuario;

public interface UsuarioDao {

	public void guardar(Usuario usuario);
	
	public void actualizar(Usuario usuario);
	
	public void eliminar(Usuario usuario);
	
	public Usuario buscarMatricula(String matricula);

}
