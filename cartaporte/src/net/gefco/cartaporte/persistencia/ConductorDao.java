package net.gefco.cartaporte.persistencia;

import java.util.List;

import net.gefco.cartaporte.modelo.Conductor;
import net.gefco.cartaporte.modelo.CompaniaTransporte;

public interface ConductorDao {

	public void guardar(Conductor conductor);
	
	public void actualizar(Conductor conductor);
	
	public void eliminar(Conductor conductor);

	public List<Conductor> listarConductores(CompaniaTransporte companiaTransporte);


}
