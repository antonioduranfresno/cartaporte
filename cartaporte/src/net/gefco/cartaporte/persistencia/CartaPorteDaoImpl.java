package net.gefco.cartaporte.persistencia;

import java.util.List;

import net.gefco.cartaporte.modelo.Agencia;
import net.gefco.cartaporte.modelo.CartaPorte;
import net.gefco.cartaporte.modelo.RutaInfo;

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
	
	@Override
	@SuppressWarnings("unchecked")
	public List<RutaInfo> listarRutasPendientes(Agencia agencia) {
		
		Query query = getSession().createQuery("select new net.gefco.cartaporte.modelo.RutaInfo(c.capo_secuenciaRuta, c.capo_razonSocialCompania, "
				+ "c.capo_fechaDocumentacion, c.capo_fechaSalida) from CartaPorte as c "
				+ "where c.agencia = :agencia and c.capo_emitida = false group by c.capo_secuenciaRuta");
		
		query.setParameter("agencia", agencia);
		
		return query.list();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<CartaPorte> listarCartasPendientesRuta(String secuenciaRuta) {
		
		Query query = getSession().createQuery("from CartaPorte where capo_secuenciaRuta = :secuenciaRuta and capo_emitida = false");
		
		query.setParameter("secuenciaRuta", secuenciaRuta);
		
		return query.list();
	}

	@Override
	public Integer ultimaCartaPorte(Agencia agencia, Integer anyo){
		
		Query query = getSession().createQuery("select substring(capo_numeroCarta, 1, 5) as numero from CartaPorte "
				+ "where agencia = :agencia and year(capo_fechaDocumentacion) = :anyo and capo_emitida = true "
				+ "order by substring(capo_numeroCarta, 1, 5) desc");
		
		query.setParameter("agencia", agencia);		
		query.setParameter("anyo", anyo);
		
		if(query.list().size()==0){
			return 1;
		}else{			
			return new Integer(query.list().get(0).toString());
		}
		
	}

}
