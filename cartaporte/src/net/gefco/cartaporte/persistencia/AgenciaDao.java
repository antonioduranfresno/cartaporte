package net.gefco.cartaporte.persistencia;

import java.util.List;

import net.gefco.cartaporte.modelo.Agencia;

public interface AgenciaDao {

	public void guardar(Agencia agencia);
	
	public void actualizar(Agencia agencia);
	
	public void eliminar(Agencia agencia);

	public List<Agencia> listarAgencias();
	
	public Agencia buscarAgencia(Integer idAgencia);

}
