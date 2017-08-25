package net.gefco.cartaporte.persistencia;

import java.util.List;

import net.gefco.cartaporte.modelo.Agencia;
import net.gefco.cartaporte.modelo.CompaniaTransporte;
import net.gefco.cartaporte.modelo.Conductor;

public interface ConductorDao {

	public void guardar(Conductor conductor);
	
	public void actualizar(Conductor conductor);
	
	public void eliminar(Conductor conductor);

	public List<Conductor> listarConductores(CompaniaTransporte companiaTransporte);
	
	public List<Conductor> listarConductoresAgencia(Agencia agencia);

	public Conductor buscarConductor(Integer id);

}
