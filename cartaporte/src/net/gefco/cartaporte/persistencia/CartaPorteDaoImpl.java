package net.gefco.cartaporte.persistencia;

import java.util.List;

import net.gefco.cartaporte.modelo.Agencia;
import net.gefco.cartaporte.modelo.CartaPorte;

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
public class CartaPorteDaoImpl implements CartaPorteDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void guardar(CartaPorte cartaPorte) {
		getSession().save(cartaPorte);	
	}

	@Override
	public void actualizar(CartaPorte cartaPorte) {
		getSession().update(cartaPorte);
	}

	@Override
	public void eliminar(CartaPorte cartaPorte) {
		getSession().delete(cartaPorte);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CartaPorte> listarCartasPendientes(Agencia agencia) {
		
		Query query = getSession().createQuery("from CartaPorte where agencia = :agencia and capo_emitida = false");
		
		query.setParameter("agencia", agencia);
		
		return query.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CartaPorte> listarCartasEmitidas(Agencia agencia) {

		Query query = getSession().createQuery("from CartaPorte where agencia = :agencia and capo_emitida = true");
		
		query.setParameter("agencia", agencia);
		
		return query.list();
	}

	@Override
	public CartaPorte buscarCartaPorte(Integer id) {
		
		Criteria crit = getSession().createCriteria(CartaPorte.class);
		
		crit.add(Restrictions.eq("id", id));
		
		return (CartaPorte) crit.uniqueResult();
	}

}
