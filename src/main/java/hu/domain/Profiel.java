package hu.domain;

public class Profiel {
	private String eigenschappen;
	private String spreektalen;
	private int jarenErvaringIT;
	private PersoonsGegevens gegevens;
	private Vaardigheid vaardigheden;
	
	public Profiel(String es, String st, int jEIT) {
		eigenschappen = es;
		spreektalen = st;
		jarenErvaringIT = jEIT;
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