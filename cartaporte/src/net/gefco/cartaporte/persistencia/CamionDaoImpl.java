package net.gefco.cartaporte.persistencia;

import java.util.List;

import net.gefco.cartaporte.modelo.Agencia;
import net.gefco.cartaporte.modelo.Camion;
import net.gefco.cartaporte.modelo.CompaniaTransporte;

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
public class CamionDaoImpl implements CamionDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void guardar(Camion camion) {
		getSession().save(camion);	
	}

	@Override
	public void actualizar(Camion camion) {
		getSession().update(camion);
	}

	@Override
	public void eliminar(Camion camion) {
		getSession().delete(camion);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Camion> listarCamiones(CompaniaTransporte companiaTransporte) {		
		
		Query query = getSession().createQuery("from Camion where companiaTransporte = :companiaTransporte");
		
		query.setParameter("companiaTransporte", companiaTransporte);
		
		return query.list();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Camion> listarCamionesTractores(CompaniaTransporte companiaTransporte) {		
		
		Query query = getSession().createQuery("from Camion where companiaTransporte = :companiaTransporte and cami_tractora = true");
		
		query.setParameter("companiaTransporte", companiaTransporte);
		
		return query.list();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Camion> listarCamionesNoTractores(CompaniaTransporte companiaTransporte) {		
		
		Query query = getSession().createQuery("from Camion where companiaTransporte = :companiaTransporte and cami_tractora = false");
		
		query.setParameter("companiaTransporte", companiaTransporte);
		
		return query.list();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Camion> listarCamionesAgencia(Agencia agencia) {		
		
		Query query = getSession().createQuery("from Camion where companiaTransporte.agencia = :agencia");
		
		query.setParameter("agencia", agencia);
		
		return query.list();
	}
	
	@Override
	public Camion buscarCamion(Integer id) {
		
		Criteria crit = getSession().createCriteria(Camion.class);
		
		crit.add(Restrictions.eq("id", id));
		
		return (Camion) crit.uniqueResult();
	}
}
