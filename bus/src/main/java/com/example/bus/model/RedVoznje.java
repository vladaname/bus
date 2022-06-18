package com.example.bus.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the red_voznje database table.
 * 
 */
@Entity
@Table(name="red_voznje")
@NamedQuery(name="RedVoznje.findAll", query="SELECT r FROM RedVoznje r")
public class RedVoznje implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_red_voznje")
	private int idRedVoznje;

	private String cilj;

	private int distanca;

	private String start;

	@Column(name="ukupna_cena")
	private int ukupnaCena;

	private Date vremeDolaska;

	private Date vremePolaska;

	//bi-directional many-to-one association to Voznja
	@OneToMany(mappedBy="redVoznje")
	private List<Voznja> voznjas;

	public RedVoznje() {
	}

	public int getIdRedVoznje() {
		return this.idRedVoznje;
	}

	public void setIdRedVoznje(int idRedVoznje) {
		this.idRedVoznje = idRedVoznje;
	}

	public String getCilj() {
		return this.cilj;
	}

	public void setCilj(String cilj) {
		this.cilj = cilj;
	}

	public int getDistanca() {
		return this.distanca;
	}

	public void setDistanca(int distanca) {
		this.distanca = distanca;
	}

	public String getStart() {
		return this.start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public int getUkupnaCena() {
		return this.ukupnaCena;
	}

	public void setUkupnaCena(int ukupnaCena) {
		this.ukupnaCena = ukupnaCena;
	}

	public Date  getVremeDolaska() {
		return this.vremeDolaska;
	}

	public void setVremeDolaska(Date vremeDolaska) {
		this.vremeDolaska = vremeDolaska;
	}

	public Date getVremePolaska() {
		return this.vremePolaska;
	}

	public void setVremePolaska(Date vremePolaska) {
		this.vremePolaska = vremePolaska;
	}

	public List<Voznja> getVoznjas() {
		return this.voznjas;
	}

	public void setVoznjas(List<Voznja> voznjas) {
		this.voznjas = voznjas;
	}

	public Voznja addVoznja(Voznja voznja) {
		getVoznjas().add(voznja);
		voznja.setRedVoznje(this);

		return voznja;
	}

	public Voznja removeVoznja(Voznja voznja) {
		getVoznjas().remove(voznja);
		voznja.setRedVoznje(null);

		return voznja;
	}

}