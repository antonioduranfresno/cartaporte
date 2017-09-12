package net.gefco.cartaporte.persistencia;

import java.util.List;

import net.gefco.cartaporte.modelo.Agencia;
import net.gefco.cartaporte.modelo.CartaPorte;
import net.gefco.cartaporte.modelo.RutaInfo;

public interface CartaPorteDao {

	public void guardar(CartaPorte cartaPorte);
	
	public void actualizar(CartaPorte cartaPorte);
	
	public void eliminar(CartaPorte cartaPorte);

	public List<CartaPorte> listarCartasPendientes(Agencia agencia);
	
	public List<CartaPorte> listarCartasEmitidas(Agencia agencia);
	
	public CartaPorte buscarCartaPorte(Integer id);

	public List<RutaInfo> listarRutasPendientes(Agencia agencia);

	public List<CartaPorte> listarCartasPendientesRuta(String secuenciaRuta);

	public Integer ultimaCartaPorte(Agencia agencia, Integer anyo);

}
