package net.gefco.cartaporte.persistencia;

import java.util.List;

import net.gefco.cartaporte.modelo.Agencia;
import net.gefco.cartaporte.modelo.Entrega;
import net.gefco.cartaporte.modelo.Ruta;

public interface EntregaDao {

	public void guardar(Entrega entrega);
	
	public void actualizar(Entrega entrega);
	
	public void eliminar(Entrega entrega);

	public List<Entrega> listarEntregas(Ruta ruta);

	public Entrega buscarEntrega(Integer idEntrega);

	public List<Entrega> listarEntregasAgencia(Agencia agencia);
}
