package co.prueba.model.dao;

import java.util.List;

import co.prueba.model.Profesion;

public interface IProfesionDAO {

	Profesion create(Profesion profession); 
	
	List<Profesion> findAll();
	
	Profesion findById(Integer id);
}
