package net.gefco.cartaporte.persistencia;

import java.util.List;

import net.gefco.cartaporte.modelo.Agencia;
import net.gefco.cartaporte.modelo.Ruta;

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
public class RutaDaoImpl implements RutaDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void guardar(Ruta ruta) {
		getSession().save(ruta);	
	}

	@Override
	public void actualizar(Ruta ruta) {
		getSession().update(ruta);
	}

	@Override
	public void eliminar(Ruta ruta) {
		getSession().delete(ruta);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Ruta> listarRutas(Agencia agencia) {		
		
		Query query = getSession().createQuery("from Ruta where agencia = :agencia");
		
		query.setParameter("agencia", agencia);
		
		return query.list();
	}
	
	@Override
	public Ruta buscarRuta(Integer id) {
		
		Criteria crit = getSession().createCriteria(Ruta.class);
		
		crit.add(Restrictions.eq("id", id));
		
		return (Ruta) crit.uniqueResult();
	}
	
}
