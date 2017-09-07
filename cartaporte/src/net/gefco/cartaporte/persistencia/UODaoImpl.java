package net.gefco.cartaporte.persistencia;

import java.util.List;

import net.gefco.cartaporte.modelo.UO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class UODaoImpl implements UODao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void guardar(UO uo) {
		getSession().save(uo);	
	}

	@Override
	public void actualizar(UO uo) {
		getSession().update(uo);
	}

	@Override
	public void eliminar(UO uo) {
		getSession().delete(uo);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<UO> listarUnidadesOperacionales() {		
		
		Query query = getSession().createQuery("from UO");
		
		return query.list();
	}
}
