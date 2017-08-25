package net.gefco.cartaporte.persistencia;

import java.util.List;

import net.gefco.cartaporte.modelo.Agencia;
import net.gefco.cartaporte.modelo.Camion;
import net.gefco.cartaporte.modelo.CompaniaTransporte;

public interface CamionDao {

	public void guardar(Camion camion);
	
	public void actualizar(Camion camion);
	
	public void eliminar(Camion camion);

	public List<Camion> listarCamiones(CompaniaTransporte companiaTransporte);

	public List<Camion> listarCamionesAgencia(Agencia agencia);

	public Camion buscarCamion(Integer id);
}
