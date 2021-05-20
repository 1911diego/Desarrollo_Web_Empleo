package co.prueba.model.dao.impl;

import java.util.List;

import org.hibernate.Session;

import co.prueba.model.Agencia;
import co.prueba.model.dao.IAgenciaDAO;
import co.prueba.model.persistence.baseDeDatos.SesionHibernate;

/**
 * Clase que implementa el Crud de las Agencias
 * 
 * @author Diego Torres
 *
 */
public class AgenciaDAOImpl implements IAgenciaDAO {

	private Session session;

	@Override
	public Agencia create(Agencia agencia) {
		session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		try {
			session.persist(agencia);
			session.getTransaction().commit();
			return agencia;
		} catch (Exception e) {
			session.getTransaction().commit();
			return null;
		}

	}

	@Override
	public List<Agencia> findAll() {
		session = SesionHibernate.getSf().getCurrentSession();
		String hql = "SELECT a FROM Agencia a";
		session.beginTransaction();
		List<Agencia> listaAgencias = null;
		try {
			listaAgencias = session.createQuery(hql, Agencia.class).list();
		} catch (Exception e) {

		}
		session.getTransaction().commit();
		return listaAgencias;
	}

	@Override
	public Agencia findById(Integer id) {
		session = SesionHibernate.getSf().getCurrentSession();
		String hql = "SELECT a FROM Agencia a where a.id = " + id;
		session.beginTransaction();
		Agencia agenciaEncontrada = null;
		try {
			agenciaEncontrada = session.createQuery(hql, Agencia.class).getSingleResult();

		} catch (Exception e) {

		}
		session.getTransaction().commit();
		return agenciaEncontrada;
	}

}
