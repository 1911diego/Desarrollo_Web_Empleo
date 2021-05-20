package co.prueba.model.dao;

import java.util.List;

import co.prueba.model.Agencia;

public interface IAgenciaDAO {

	Agencia create(Agencia agencia);
	
	List<Agencia> findAll();
	
	Agencia findById(Integer id);
	
}
