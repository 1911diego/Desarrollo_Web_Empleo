package co.prueba.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tb_Agencia")
public class Agencia implements Serializable{
	
	@Id
	@Column(name = "idProfesion")
	private Integer id;
	
	@Column(name = "ag_nombre",nullable = false)
	private String nombre;
	
	@Column(name="ag_telefono",nullable = false)
	private String telefono;
	
	@Column(name="ag_direccion",nullable = false)
	private String direccion;
	
	public Agencia() {
		
	}

	public Agencia(Integer id, String nombre, String telefono, String direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

}
