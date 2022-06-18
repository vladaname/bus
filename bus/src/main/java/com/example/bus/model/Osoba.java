package com.example.bus.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the osoba database table.
 * 
 */
@Entity
@NamedQuery(name="Osoba.findAll", query="SELECT o FROM Osoba o")
public class Osoba implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_osoba")
	private int idOsoba;

	private String email;

	private String ime;

	private String pass;

	private String prezime;

	private String username;

	//bi-directional many-to-one association to Uloga
	@ManyToOne
	private Uloga uloga;

	//bi-directional many-to-one association to Voznja
	@OneToMany(mappedBy="osoba")
	private List<Voznja> voznjas;

	public Osoba() {
	}

	public int getIdOsoba() {
		return this.idOsoba;
	}

	public void setIdOsoba(int idOsoba) {
		this.idOsoba = idOsoba;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Uloga getUloga() {
		return this.uloga;
	}

	public void setUloga(Uloga uloga) {
		this.uloga = uloga;
	}

	public List<Voznja> getVoznjas() {
		return this.voznjas;
	}

	public void setVoznjas(List<Voznja> voznjas) {
		this.voznjas = voznjas;
	}

	public Voznja addVoznja(Voznja voznja) {
		getVoznjas().add(voznja);
		voznja.setOsoba(this);

		return voznja;
	}

	public Voznja removeVoznja(Voznja voznja) {
		getVoznjas().remove(voznja);
		voznja.setOsoba(null);

		return voznja;
	}

}