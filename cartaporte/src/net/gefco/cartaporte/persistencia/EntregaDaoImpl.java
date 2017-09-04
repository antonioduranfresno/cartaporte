package net.gefco.cartaporte.persistencia;

import java.util.List;

import net.gefco.cartaporte.modelo.Agencia;
import net.gefco.cartaporte.modelo.Entrega;
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
public class EntregaDaoImpl implements EntregaDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void guardar(Entrega entrega) {
		getSession().save(entrega);	
	}

	@Override
	public void actualizar(Entrega entrega) {
		getSession().update(entrega);
	}

	@Override
	public void eliminar(Entrega entrega) {
		getSession().delete(entrega);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Entrega> listarEntregas(Ruta ruta) {		
		
		Query query = getSession().createQuery("from Entrega where ruta = :ruta order by entr_horaLlegada");
		
		query.setParameter("ruta", ruta);
		
		return query.list();
	}

	@Override
	public Entrega buscarEntrega(Integer id) {
		
		Criteria crit = getSession().createCriteria(Entrega.class);
		
		crit.add(Restrictions.eq("id", id));
		
		return (Entrega) crit.uniqueResult();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Entrega> listarEntregasAgencia(Agencia agencia) {		
		
		Query query = getSession().createQuery("from Entrega where ruta.agencia = :agencia order by ruta.id, entr_horaLlegada");
		
		query.setParameter("agencia", agencia);
		
		return query.list();
	}
}
