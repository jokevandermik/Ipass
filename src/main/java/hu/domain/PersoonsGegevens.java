package hu.domain;

import java.util.Date;

public class PersoonsGegevens {
	private int id = (Integer) null;
	private String naam;
	private String straatnaam;
	private int huisnummer;
	private String postcode;
	private String woonplaats;
	private String geboortedatum;
	private String geslacht;
	private int telefoonnummer;
	private String email;
	private String linkedin;
	
	public PersoonsGegevens(int ID, String nm, String strNm, int hn, String pc, String wp, String gb, String gs, int tfn, String mail, String ldin) {
		id = ID;
		naam = nm;
		straatnaam = strNm;
		huisnummer = hn;
		postcode = pc;
		woonplaats = wp;
		geboortedatum = gb;
		geslacht = gs;
		telefoonnummer = tfn;
		email = mail;
		linkedin = ldin;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNaam() {
		return naam;
	}
	
	public String getStraatnaam() {
		return straatnaam;
	}
	
	public int getHuisnummer() {
		return huisnummer;
	}
	
	public String getPostcode() {
		return postcode;
	}
	
	public String getWoonplaats() {
		return woonplaats;
	}
	
	public String getGeboortedatum() {
		return geboortedatum;
	}
	
	public String getGeslacht() {
		return geslacht;
	}
	
	public int getTelefoonnummer() {
		return telefoonnummer;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getLinkedin() {
		return linkedin;
	}
	
	public void setId(int ID) {
		id = ID; 
	}
	
	public void setNaam(String nm) {
		naam = nm;
	}
	
	public void setStraatnaam(String strNm) {
		straatnaam = strNm;
	}
	
	public void setHuisnummer(int hn) {
		huisnummer = hn;
	}
	
	public void setPostcode(String pc) {
		postcode = pc;
	}
	
	public void setWoonplaats(String wp) {
		woonplaats = wp;
	}
	
	public void setGeboortedatum(String gb) {
		geboortedatum = gb;
	}
	
	public void setGeslacht(String gs) {
		geslacht = gs;
	}
	
	public void setTelefoonnummer(int tfn) {
		telefoonnummer = tfn;
	}
	
	public void setEmail(String mail) {
		email = mail;
	}
	
	public void setLinkedin(String ldin) {
		linkedin = ldin;
	}
}