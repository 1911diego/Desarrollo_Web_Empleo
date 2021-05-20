package co.prueba.model.dao.impl;

import java.util.List;

import org.hibernate.Session;

import co.prueba.model.Empleabilidad;
import co.prueba.model.dao.IEmpleabilidadDAO;
import co.prueba.model.persistence.baseDeDatos.SesionHibernate;

public class EmpleabilidadDAOImpl implements IEmpleabilidadDAO {

	private Session session;
	
	@Override
	public Empleabilidad create(Empleabilidad empleabilidad) {
		session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		try {
			session.persist(empleabilidad);
			session.getTransaction().commit();
			return empleabilidad;
		} catch (Exception e) {
			session.getTransaction().commit();
			return null;
		}
	}

	@Override
	public List<Empleabilidad> findAll() {
		session = SesionHibernate.getSf().getCurrentSession();
		String hql = "SELECT e FROM Empleabilidad e";
		session.beginTransaction();
		List<Empleabilidad> listaEmpleabilidad = null;
		try {
			listaEmpleabilidad = session.createQuery(hql, Empleabilidad.class).list();
		} catch (Exception e) {

		}
		session.getTransaction().commit();
		return listaEmpleabilidad;
	}

	@Override
	public Empleabilidad findById(Integer id) {
		session = SesionHibernate.getSf().getCurrentSession();
		String hql = "SELECT a FROM Aspirante a where a.id = " + id;
		session.beginTransaction();
		Empleabilidad empleabilidadEncontrada = null;
		try {
			empleabilidadEncontrada = session.createQuery(hql, Empleabilidad.class).getSingleResult();

		} catch (Exception e) {

		}
		session.getTransaction().commit();
		return empleabilidadEncontrada;
	}


}
