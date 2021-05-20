package co.prueba.model;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_Aspirante")
public class Aspirante implements Serializable {

	@Id
	@Column(name = "IdAspirante")	
	public Integer id;
	
	@Column(name = "AS_Nombre",nullable = false)
	private String nombre;
	
	@Column(name = "AS_Edad", nullable = false)
	private String edad;
	
	@Column(name = "As_Genero",length = 1,nullable = false)
	private String genero;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Profesion profesion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Agencia agencia;

	
	public Aspirante(Integer id,String nombre, String edad, String genero, Profesion profesion, Agencia agencia) {
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.genero = genero;
		this.profesion = profesion;
		this.agencia = agencia;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Profesion getProfesion() {
		return profesion;
	}

	public void setProfesion(Profesion profesion) {
		this.profesion = profesion;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	
}
