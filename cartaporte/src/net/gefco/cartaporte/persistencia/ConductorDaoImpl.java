package net.gefco.cartaporte.persistencia;

import java.util.List;

import net.gefco.cartaporte.modelo.Agencia;
import net.gefco.cartaporte.modelo.CompaniaTransporte;
import net.gefco.cartaporte.modelo.Conductor;
import net.gefco.cartaporte.modelo.TipoTransporte;

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
public class ConductorDaoImpl implements ConductorDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void guardar(Conductor conductor) {
		getSession().save(conductor);	
	}

	@Override
	public void actualizar(Conductor conductor) {
		getSession().update(conductor);
	}

	@Override
	public void eliminar(Conductor conductor) {
		getSession().delete(conductor);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Conductor> listarConductores(CompaniaTransporte companiaTransporte) {		
		
		Query query = getSession().createQuery("from Conductor where companiaTransporte = :companiaTransporte");
		
		query.setParameter("companiaTransporte", companiaTransporte);
		
		return query.list();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Conductor> listarConductoresAgencia(Agencia agencia) {		
		
		Query query = getSession().createQuery("from Conductor c where companiaTransporte.agencia = :agencia");
		
		query.setParameter("agencia", agencia);
		
		return query.list();
	}
	

	@Override
	public Conductor buscarConductor(Integer id) {
		
		Criteria crit = getSession().createCriteria(Conductor.class);
		
		crit.add(Restrictions.eq("id", id));
		
		return (Conductor) crit.uniqueResult();
	}
}
