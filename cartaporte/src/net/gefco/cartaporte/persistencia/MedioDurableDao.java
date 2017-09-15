package net.gefco.cartaporte.persistencia;

import java.util.List;

import net.gefco.cartaporte.modelo.CartaPorte;
import net.gefco.cartaporte.modelo.MedioDurable;

public interface MedioDurableDao {

	public void guardar(MedioDurable medioDurable);
	
	public void actualizar(MedioDurable medioDurable);
	
	public void eliminar(MedioDurable medioDurable);

	public List<MedioDurable> listarMediosDurables(CartaPorte cartaPorte);

	public MedioDurable buscarMedioDurable(Integer id);
}
