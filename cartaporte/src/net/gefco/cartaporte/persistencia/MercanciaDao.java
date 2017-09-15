package net.gefco.cartaporte.persistencia;

import java.util.List;

import net.gefco.cartaporte.modelo.CartaPorte;
import net.gefco.cartaporte.modelo.Mercancia;

public interface MercanciaDao {

	public void guardar(Mercancia mercancia);
	
	public void actualizar(Mercancia mercancia);
	
	public void eliminar(Mercancia mercancia);

	public List<Mercancia> listarMercancias(CartaPorte cartaPorte);

	public Mercancia buscarMercancia(Integer id);
}
