package net.gefco.cartaporte.persistencia;

import java.util.List;

import net.gefco.cartaporte.modelo.Agencia;
import net.gefco.cartaporte.modelo.CartaPorte;

public interface CartaPorteDao {

	public void guardar(CartaPorte cartaPorte);
	
	public void actualizar(CartaPorte cartaPorte);
	
	public void eliminar(CartaPorte cartaPorte);

	public List<CartaPorte> listarCartasPendientes(Agencia agencia);
	
	public List<CartaPorte> listarCartasEmitidas(Agencia agencia);
	
	public CartaPorte buscarCartaPorte(Integer id);

}
