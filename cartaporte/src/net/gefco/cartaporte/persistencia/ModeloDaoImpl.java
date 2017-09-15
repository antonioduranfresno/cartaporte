package net.gefco.cartaporte.persistencia;

import java.util.List;

import net.gefco.cartaporte.modelo.Modelo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class ModeloDaoImpl implements ModeloDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void guardar(Modelo modelo) {
		getSession().save(modelo);	
	}

	@Override
	public void actualizar(Modelo modelo) {
		getSession().update(modelo);
	}

	@Override
	public void eliminar(Modelo modelo) {
		getSession().delete(modelo);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Modelo> listarModelos() {		
		
		Query query = getSession().createQuery("from Modelo");
				
		return query.list();
	}
	
}
