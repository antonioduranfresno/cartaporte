package net.gefco.cartaporte.persistencia;

import java.util.List;

import net.gefco.cartaporte.modelo.CartaPorte;
import net.gefco.cartaporte.modelo.MedioDurable;

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
public class MedioDurableDaoImpl implements MedioDurableDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void guardar(MedioDurable medioDurable) {
		getSession().save(medioDurable);	
	}

	@Override
	public void actualizar(MedioDurable medioDurable) {
		getSession().update(medioDurable);
	}

	@Override
	public void eliminar(MedioDurable medioDurable) {
		getSession().delete(medioDurable);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<MedioDurable> listarMediosDurables(CartaPorte cartaPorte) {		
		
		Query query = getSession().createQuery("from MedioDurable where cartaPorte = :cartaPorte");
		
		query.setParameter("cartaPorte", cartaPorte);
		
		return query.list();
	}

	@Override
	public MedioDurable buscarMedioDurable(Integer id) {
		
		Criteria crit = getSession().createCriteria(MedioDurable.class);
		
		crit.add(Restrictions.eq("id", id));
		
		return (MedioDurable) crit.uniqueResult();
	}

}