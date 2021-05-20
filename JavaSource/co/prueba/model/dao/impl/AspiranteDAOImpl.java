package co.prueba.model.dao.impl;

import java.util.List;

import org.hibernate.Session;

import co.prueba.model.Aspirante;
import co.prueba.model.dao.IAspiranteDAO;
import co.prueba.model.persistence.baseDeDatos.SesionHibernate;

public class AspiranteDAOImpl implements IAspiranteDAO {

	private Session session;

	@Override
	public Aspirante create(Aspirante aspirante) {
		session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		try {
			session.persist(aspirante);
			session.getTransaction().commit();
			return aspirante;
		} catch (Exception e) {
			session.getTransaction().commit();
			return null;
		}

	}

	@Override
	public List<Aspirante> findAll(Aspirante aspirante) {
		session = SesionHibernate.getSf().getCurrentSession();
		String hql = "SELECT a FROM Aspirante a";
		session.beginTransaction();
		List<Aspirante> listaAspirantes = null;
		try {
			listaAspirantes = session.createQuery(hql, Aspirante.class).list();
		} catch (Exception e) {

		}
		session.getTransaction().commit();
		return listaAspirantes;

	}

	@Override
	public Aspirante findById(Integer id) {
		session = SesionHibernate.getSf().getCurrentSession();
		String hql = "SELECT a FROM Aspirante a where a.id = " + id;
		session.beginTransaction();
		Aspirante aspiranteEncontrado = null;
		try {
			aspiranteEncontrado = session.createQuery(hql, Aspirante.class).getSingleResult();

		} catch (Exception e) {

		}
		session.getTransaction().commit();
		return aspiranteEncontrado;
	}

	@Override
	public List<Aspirante> findByParameter(String s, String option) {
		String hql = "";
		switch (option) {
		case "caracter":
			hql = "SELECT a FROM Aspirante a where a.nombre like '" + s + "%'";
			break;
		case "genero":
			hql = "SELECT a FROM Aspirante a where a.genero = " + s;
			break;
		case "profesion":
			hql = "SELECT a FROM Aspirante a where a.profesion.nombre = " + s;
			break;
		}

		session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		List<Aspirante> aspiranteEncontrado = null;
		try {
			aspiranteEncontrado = session.createQuery(hql, Aspirante.class).getResultList();
		} catch (Exception e) {
		}
		session.getTransaction().commit();
		return aspiranteEncontrado;
	}

	@Override
	public Aspirante findOlder() {
		String hql = "SELECT a FROM Aspirante a order by a.edad desc limit 1";
		session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		Aspirante aspiranteEncontrado = null;
		try {
			aspiranteEncontrado = session.createQuery(hql, Aspirante.class).getSingleResult();
		} catch (Exception e) {
		}
		session.getTransaction().commit();
		return aspiranteEncontrado;
	}

}
