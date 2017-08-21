package net.gefco.cartaporte.persistencia;

import java.util.List;

import net.gefco.cartaporte.modelo.Agencia;
import net.gefco.cartaporte.modelo.TipoTransporte;

public interface TipoTransporteDao {

	public void guardar(TipoTransporte tipoTransporte);
	
	public void actualizar(TipoTransporte tipoTransporte);
	
	public void eliminar(TipoTransporte tipoTransporte);

	public List<TipoTransporte> listarTiposTransporte(Agencia agencia);

	public TipoTransporte buscarTipoTransporte(Agencia agencia, String nombre);

}
