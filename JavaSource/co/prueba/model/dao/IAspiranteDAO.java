package co.prueba.model.dao;

import java.util.List;

import co.prueba.model.Aspirante;

public interface IAspiranteDAO {
	
	Aspirante create(Aspirante aspirante);
	
	List<Aspirante> findAll(Aspirante aspirante);
	
	Aspirante findById(Integer id);
	
	List<Aspirante> findByParameter(String s,String option);
	
	Aspirante findOlder();
	
	
}
