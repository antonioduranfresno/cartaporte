package net.gefco.cartaporte.persistencia;

import java.util.List;

import net.gefco.cartaporte.modelo.Agencia;
import net.gefco.cartaporte.modelo.Destino;

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
public class DestinoDaoImpl implements DestinoDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void guardar(Destino destino) {
		getSession().save(destino);	
	}

	@Override
	public void actualizar(Destino destino) {
		getSession().update(destino);
	}

	@Override
	public void eliminar(Destino destino) {
		getSession().delete(destino);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Destino> listarDestinos(Agencia agencia) {		
		
		Query query = getSession().createQuery("from Destino where agencia = :agencia");
		
		query.setParameter("agencia", agencia);
		
		return query.list();
	}

	
	@Override
	public Destino buscarDestino(Integer id) {
		
		Criteria crit = getSession().createCriteria(Destino.class);
		
		crit.add(Restrictions.eq("id", id));
		
		return (Destino) crit.uniqueResult();
	}
}
