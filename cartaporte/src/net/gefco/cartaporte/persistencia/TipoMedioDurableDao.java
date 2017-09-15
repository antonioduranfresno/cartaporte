package net.gefco.cartaporte.persistencia;

import java.util.List;

import net.gefco.cartaporte.modelo.Agencia;
import net.gefco.cartaporte.modelo.TipoMedioDurable;

public interface TipoMedioDurableDao {

	public void guardar(TipoMedioDurable tipoMedioDurable);
	
	public void actualizar(TipoMedioDurable tipoMedioDurable);
	
	public void eliminar(TipoMedioDurable tipoMedioDurable);

	public List<TipoMedioDurable> listarTiposMediosDurablesAgencia(Agencia agencia);

	public TipoMedioDurable buscarTipoMedioDurable(Integer id);

}
