package net.gefco.cartaporte.persistencia;

import java.util.List;

import net.gefco.cartaporte.modelo.Agencia;

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
public class AgenciaDaoImpl implements AgenciaDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void guardar(Agencia agencia) {
		getSession().save(agencia);	
	}

	@Override
	public void actualizar(Agencia agencia) {
		getSession().update(agencia);
	}

	@Override
	public void eliminar(Agencia agencia) {
		getSession().delete(agencia);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Agencia> listarAgencias() {		
		
		Query query = getSession().createQuery("from Agencia");
		
		return query.list();
	}
	
	@Override
	public Agencia buscarAgencia(Integer id) {
		
		Criteria crit = getSession().createCriteria(Agencia.class);
		
		crit.add(Restrictions.eq("id", id));
		
		return (Agencia) crit.uniqueResult();
	}

}
