package co.prueba.model.dao;

import java.util.List;

import co.prueba.model.Empleabilidad;

public interface IEmpleabilidadDAO {

	Empleabilidad create(Empleabilidad empleabilidad);
	
	List<Empleabilidad> findAll();
	
	Empleabilidad findById(Integer empleabilidad);
	
	
}
