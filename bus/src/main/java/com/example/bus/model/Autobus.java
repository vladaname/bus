package com.example.bus.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the autobus database table.
 * 
 */
@Entity
@NamedQuery(name="Autobus.findAll", query="SELECT a FROM Autobus a")
public class Autobus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_autobus")
	private int idAutobus;

	@Column(name="broj_sedista")
	private int brojSedista;

	private String naziv;

	//bi-directional many-to-one association to Voznja
	@OneToMany(mappedBy="autobus")
	private List<Voznja> voznjas;

	public Autobus() {
	}

	public int getIdAutobus() {
		return this.idAutobus;
	}

	public void setIdAutobus(int idAutobus) {
		this.idAutobus = idAutobus;
	}

	public int getBrojSedista() {
		return this.brojSedista;
	}

	public void setBrojSedista(int brojSedista) {
		this.brojSedista = brojSedista;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Voznja> getVoznjas() {
		return this.voznjas;
	}

	public void setVoznjas(List<Voznja> voznjas) {
		this.voznjas = voznjas;
	}

	public Voznja addVoznja(Voznja voznja) {
		getVoznjas().add(voznja);
		voznja.setAutobus(this);

		return voznja;
	}

	public Voznja removeVoznja(Voznja voznja) {
		getVoznjas().remove(voznja);
		voznja.setAutobus(null);

		return voznja;
	}

}