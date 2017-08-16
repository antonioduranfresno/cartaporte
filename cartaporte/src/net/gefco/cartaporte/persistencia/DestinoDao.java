package net.gefco.cartaporte.persistencia;

import java.util.List;

import net.gefco.cartaporte.modelo.Agencia;
import net.gefco.cartaporte.modelo.Destino;

public interface DestinoDao {

	public void guardar(Destino destino);
	
	public void actualizar(Destino destino);
	
	public void eliminar(Destino destino);

	public List<Destino> listarDestinos(Agencia agencia);


}
