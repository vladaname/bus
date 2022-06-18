package com.example.bus.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the voznja database table.
 * 
 */
@Entity
@NamedQuery(name="Voznja.findAll", query="SELECT v FROM Voznja v")
public class Voznja implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_voznja")
	private int idVoznja;

	//bi-directional many-to-one association to Autobus
	@ManyToOne
	private Autobus autobus;

	//bi-directional many-to-one association to RedVoznje
	@ManyToOne
	@JoinColumn(name="red_voznje_id_red_voznje")
	private RedVoznje redVoznje;

	//bi-directional many-to-one association to Osoba
	@ManyToOne
	private Osoba osoba;

	public Voznja() {
	}

	public int getIdVoznja() {
		return this.idVoznja;
	}

	public void setIdVoznja(int idVoznja) {
		this.idVoznja = idVoznja;
	}

	public Autobus getAutobus() {
		return this.autobus;
	}

	public void setAutobus(Autobus autobus) {
		this.autobus = autobus;
	}

	public RedVoznje getRedVoznje() {
		return this.redVoznje;
	}

	public void setRedVoznje(RedVoznje redVoznje) {
		this.redVoznje = redVoznje;
	}

	public Osoba getOsoba() {
		return this.osoba;
	}

	public void setOsoba(Osoba osoba) {
		this.osoba = osoba;
	}

}