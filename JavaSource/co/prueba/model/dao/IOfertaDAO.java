package co.prueba.model.dao;

import java.util.List;

import co.prueba.model.Oferta;

public interface IOfertaDAO {

	Oferta create(Oferta oferta);
	
	List<Oferta> findAll();
	
	Oferta findById(Integer id);
	
}
