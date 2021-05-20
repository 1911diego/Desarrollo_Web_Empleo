package co.prueba.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_Oferta")
public class Oferta implements Serializable{
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_oferta")
	private Integer id;
	
	@Column(name = "o_nombre")
	private String nombre;
	
	@Column(name = "o_descripcion",nullable = false)
	private String descripcion;
	
	@Column(name = "o_fecha_inicio",nullable = false)
	private Date fechaInicio;
	
	@Column(name = "o_fecha_fin",nullable = false)
	private Date fechaFin;

	
	
	public Oferta(String nombre, String descripcion, Date fechaInicio, Date fechaFin) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
}
