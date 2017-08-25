package net.gefco.cartaporte.persistencia;

import java.util.List;

import net.gefco.cartaporte.modelo.Agencia;
import net.gefco.cartaporte.modelo.CompaniaTransporte;

public interface CompaniaTransporteDao {

	public void guardar(CompaniaTransporte companiaTransporte);
	
	public void actualizar(CompaniaTransporte companiaTransporte);
	
	public void eliminar(CompaniaTransporte companiaTransporte);

	public List<CompaniaTransporte> listarCompaniasTransporte(Agencia agencia);

	public CompaniaTransporte buscarCompaniaTransporte(Integer id);


}
