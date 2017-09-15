package net.gefco.cartaporte.persistencia;

import java.util.List;

import net.gefco.cartaporte.modelo.Agencia;
import net.gefco.cartaporte.modelo.TipoMedioDurable;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class TipoMedioDurableDaoImpl implements TipoMedioDurableDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void guardar(TipoMedioDurable tipoMedioDurable) {
		getSession().save(tipoMedioDurable);	
	}

	@Override
	public void actualizar(TipoMedioDurable tipoMedioDurable) {
		getSession().update(tipoMedioDurable);
	}

	@Override
	public void eliminar(TipoMedioDurable tipoMedioDurable) {
		getSession().delete(tipoMedioDurable);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<TipoMedioDurable> listarTiposMediosDurablesAgencia(Agencia agencia) {		
		
		Query query = getSession().createQuery("from TipoMedioDurable where agencia = :agencia");
		
		query.setParameter("agencia", agencia);
		
		return query.list();
	}
	
	@Override
	public TipoMedioDurable buscarTipoMedioDurable(Integer id) {
		
		Criteria crit = getSession().createCriteria(TipoMedioDurable.class);
		
		crit.add(Restrictions.eq("id", id));
		
		return (TipoMedioDurable) crit.uniqueResult();
	}
}
