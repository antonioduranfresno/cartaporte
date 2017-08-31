package net.gefco.cartaporte.persistencia;

import java.util.List;

import net.gefco.cartaporte.modelo.Agencia;
import net.gefco.cartaporte.modelo.Ruta;

public interface RutaDao {

	public void guardar(Ruta ruta);
	
	public void actualizar(Ruta ruta);
	
	public void eliminar(Ruta ruta);

	public List<Ruta> listarRutas(Agencia agencia);

	public Ruta buscarRuta(Integer id);

}
