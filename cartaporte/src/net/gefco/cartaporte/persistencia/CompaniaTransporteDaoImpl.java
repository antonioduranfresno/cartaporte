package net.gefco.cartaporte.persistencia;

import java.util.List;

import net.gefco.cartaporte.modelo.Agencia;
import net.gefco.cartaporte.modelo.CompaniaTransporte;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class CompaniaTransporteDaoImpl implements CompaniaTransporteDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void guardar(CompaniaTransporte companiaTransporte) {
		getSession().save(companiaTransporte);	
	}

	@Override
	public void actualizar(CompaniaTransporte companiaTransporte) {
		getSession().update(companiaTransporte);
	}

	@Override
	public void eliminar(CompaniaTransporte companiaTransporte) {
		getSession().delete(companiaTransporte);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CompaniaTransporte> listarCompaniasTransporte(Agencia agencia) {		
		
		Query query = getSession().createQuery("from CompaniaTransporte where agencia = :agencia");
		
		query.setParameter("agencia", agencia);
		
		return query.list();
	}
}
