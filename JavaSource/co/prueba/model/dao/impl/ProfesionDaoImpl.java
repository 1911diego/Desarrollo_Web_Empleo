package co.prueba.model.dao.impl;

import java.util.List;

import org.hibernate.Session;

import co.prueba.model.Profesion;
import co.prueba.model.dao.IProfesionDAO;
import co.prueba.model.persistence.baseDeDatos.SesionHibernate;

public class ProfesionDaoImpl implements IProfesionDAO{

	private Session session;
	
	
	@Override
	public Profesion create(Profesion profession) {
		session = SesionHibernate.getSf().getCurrentSession();
		session.beginTransaction();
		try {
			session.persist(profession);
			session.getTransaction().commit();
			return profession;
		} catch (Exception e) {
			session.getTransaction().commit();
			return null;
		}
	}

	@Override
	public List<Profesion> findAll() {
		session = SesionHibernate.getSf().getCurrentSession();
		String hql = "SELECT p FROM Profesion p";
		session.beginTransaction();
		List<Profesion> listaProfesiones = null;
		try {
			listaProfesiones = session.createQuery(hql,Profesion.class).list();
		} catch (Exception e) {

		}
		session.getTransaction().commit();
		return listaProfesiones;
	}

	@Override
	public Profesion findById(Integer id) {
		session = SesionHibernate.getSf().getCurrentSession();
		String hql = "SELECT p FROM Profesion p where p.id = " + id;
		session.beginTransaction();
		Profesion profesionEncontrada = null;
		try {
			profesionEncontrada = session.createQuery(hql, Profesion.class).getSingleResult();

		} catch (Exception e) {

		}
		session.getTransaction().commit();
		return profesionEncontrada;
	}

}
