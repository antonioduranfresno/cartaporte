package net.gefco.cartaporte.persistencia;

import java.util.List;

import net.gefco.cartaporte.modelo.UO;

public interface UODao {

	public void guardar(UO uo);
	
	public void actualizar(UO uo);
	
	public void eliminar(UO uo);

	public List<UO> listarUnidadesOperacionales();


}
