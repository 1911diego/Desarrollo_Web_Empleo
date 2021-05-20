package co.prueba.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_Empleabilidad")
public class Empleabilidad implements Serializable {

	@Id
	@Column(name = "id_emp")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Date eFecha; 
	
	@OneToOne(fetch = FetchType.LAZY)
	private Aspirante aspirante;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Oferta oferta;
	
	
	public Empleabilidad(Date eFecha, Aspirante aspirante, Oferta oferta) {
		this.eFecha = eFecha;
		this.aspirante = aspirante;
		this.oferta = oferta;
	}


	public Integer getId() {
		return id;
	}





	public void setId(Integer id) {
		this.id = id;
	}





	public Date geteFecha() {
		return eFecha;
	}





	public void seteFecha(Date eFecha) {
		this.eFecha = eFecha;
	}





	public Aspirante getAspirante() {
		return aspirante;
	}





	public void setAspirante(Aspirante aspirante) {
		this.aspirante = aspirante;
	}





	public Oferta getOferta() {
		return oferta;
	}





	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}





	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
}
