//domain class voor het ophalen van een profiel ID bij het aanmaken van een profiel.
package hu.domain;

public class PersoonID {
	private int persoonID;
	
	public PersoonID(int ID) {
		persoonID = ID;
	}

	public int getPersoonID() {
		return persoonID;
	}

	public void setPersoonID(int persoonID) {
		this.persoonID = persoonID;
	}
	
	
}
