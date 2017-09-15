package net.gefco.cartaporte.persistencia;

import java.util.List;

import net.gefco.cartaporte.modelo.Modelo;

public interface ModeloDao {

	public void guardar(Modelo modelo);
	
	public void actualizar(Modelo modelo);
	
	public void eliminar(Modelo modelo);

	public List<Modelo> listarModelos();

}
