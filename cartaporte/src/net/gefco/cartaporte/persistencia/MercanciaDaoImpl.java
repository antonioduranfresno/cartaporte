package net.gefco.cartaporte.persistencia;

import java.util.List;

import net.gefco.cartaporte.modelo.CartaPorte;
import net.gefco.cartaporte.modelo.Mercancia;

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
public class MercanciaDaoImpl implements MercanciaDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void guardar(Mercancia mercancia) {
		getSession().save(mercancia);	
	}

	@Override
	public void actualizar(Mercancia mercancia) {
		getSession().update(mercancia);
	}

	@Override
	public void eliminar(Mercancia mercancia) {
		getSession().delete(mercancia);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Mercancia> listarMercancias(CartaPorte cartaPorte) {		
		
		Query query = getSession().createQuery("from Mercancia where cartaPorte = :cartaPorte");
		
		query.setParameter("cartaPorte", cartaPorte);
		
		return query.list();
	}

	@Override
	public Mercancia buscarMercancia(Integer id) {
		
		Criteria crit = getSession().createCriteria(Mercancia.class);
		
		crit.add(Restrictions.eq("id", id));
		
		return (Mercancia) crit.uniqueResult();
	}
	
}