package co.prueba.model.dao.impl;

import java.util.List;

import org.hibernate.Session;

import co.prueba.model.Oferta;
import co.prueba.model.dao.IOfertaDAO;
import co.prueba.model.persistence.baseDeDatos.SesionHibernate;

public class OfertaDaoImpl implements IOfertaDAO{

	private Session session;
	
	@Override
	public Oferta create(Oferta oferta) {
		session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		try {
			session.persist(oferta);
			session.getTransaction().commit();
			return oferta;
		} catch (Exception e) {
			session.getTransaction().commit();
			return null;
		}

	}

	@Override
	public List<Oferta> findAll() {
		session = SesionHibernate.getSf().getCurrentSession();
		String hql = "SELECT o FROM Oferta o";
		session.beginTransaction();
		List<Oferta> listaOfertas = null;
		try {
			listaOfertas = session.createQuery(hql, Oferta.class).list();
		} catch (Exception e) {

		}
		session.getTransaction().commit();
		return listaOfertas;
	}

	@Override
	public Oferta findById(Integer id) {
		session = SesionHibernate.getSf().getCurrentSession();
		String hql = "SELECT o FROM Oferta o where o.id = " + id;
		session.beginTransaction();
		Oferta ofertaEncontrada = null;
		try {
			ofertaEncontrada = session.createQuery(hql, Oferta.class).getSingleResult();

		} catch (Exception e) {

		}
		session.getTransaction().commit();
		return ofertaEncontrada;
	}
		
}
