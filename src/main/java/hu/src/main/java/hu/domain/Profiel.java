package hu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Profiel {
	private int id;
	private int idPersoonsGegevens;
	private int idVaardigheid;
	private String eigenschappen;
	private String spreektalen;
	private int jarenErvaringIT;
	private PersoonsGegevens gegevens;
	private Vaardigheid vaardigheden;

	public Profiel(int ID, int IDPersoonsGegevens, int IDVaardigheid, String es, String st, int jEIT) {
		id = ID;
		idPersoonsGegevens = IDPersoonsGegevens;
		idVaardigheid = IDVaardigheid;
		eigenschappen = es;
		spreektalen = st;
		jarenErvaringIT = jEIT;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdProfiel() {
		return idPersoonsGegevens;
	}

	public void setIdProfiel(int idPersoonsGegevens) {
		this.idPersoonsGegevens = idPersoonsGegevens;
	}

	public int getIdVaardigheid() {
		return idVaardigheid;
	}

	public void setIdVaardigheid(int idVaardigheid) {
		this.idVaardigheid = idVaardigheid;
	}

	public Vaardigheid getVaardigheden() {
		return vaardigheden;
	}

	public void setVaardigheden(Vaardigheid vaardigheden) {
		this.vaardigheden = vaardigheden;
	}

	public PersoonsGegevens getGegevens() {
		return gegevens;
	}

	public void setGegevens(PersoonsGegevens gegevens) {
		this.gegevens = gegevens;
	}
	
	

	public String getEigenschappen() {
		return eigenschappen;
	}

	public String getSpreektalen() {
		return spreektalen;
	}

	public int getJarenErvaringIT() {
		return jarenErvaringIT;
	}

	public void setEigenschappen(String es) {
		eigenschappen = es;
	}

	public void setSpreektalen(String st) {
		spreektalen = st;
	}

	public void setJarenErvaringIT(int jEIT) {
		jarenErvaringIT = jEIT;
	}
}