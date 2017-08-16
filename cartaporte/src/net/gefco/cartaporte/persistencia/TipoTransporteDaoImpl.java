package net.gefco.cartaporte.persistencia;

import java.util.List;

import net.gefco.cartaporte.modelo.Agencia;
import net.gefco.cartaporte.modelo.TipoTransporte;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class TipoTransporteDaoImpl implements TipoTransporteDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void guardar(TipoTransporte tipoTransporte) {
		getSession().save(tipoTransporte);	
	}

	@Override
	public void actualizar(TipoTransporte tipoTransporte) {
		getSession().update(tipoTransporte);
	}

	@Override
	public void eliminar(TipoTransporte tipoTransporte) {
		getSession().delete(tipoTransporte);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<TipoTransporte> listarTiposTransporte(Agencia agencia) {		
		
		Query query = getSession().createQuery("from TipoTransporte where agencia = :agencia");
		
		query.setParameter("agencia", agencia);
		
		return query.list();
	}
}
