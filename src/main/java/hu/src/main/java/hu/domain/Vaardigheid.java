package hu.domain;

public class Vaardigheid {
	private int id;
	private String technischeVaardigheden;
	private String functioneleVaardigheden;
	private String werkervaring;
	private String computertalen;
	private String platform;
	private String pakketten;

	public Vaardigheid(int id,String tv, String fv, String we, String ct, String pf, String pk) {
		this.id = id;
		technischeVaardigheden = tv;
		functioneleVaardigheden = fv;
		werkervaring = we;
		computertalen = ct;
		platform = pf;
		pakketten = pk;
	}
	
	public int getId() {
		return id;
	}

	public String GetTechnischeVaardigheden() {
		return technischeVaardigheden;
	}

	public String GetFunctioneleVaardigheden() {
		return functioneleVaardigheden;
	}

	public String GetWerkervaring() {
		return werkervaring;
	}

	public String GetComputertalen() {
		return computertalen;
	}

	public String GetPlatform() {
		return platform;
	}

	public String GetPakketen() {
		return pakketten;
	}
	
	public void setId(int ID) {
		id = ID;
	}

	public void setTechnischeVaardigheden(String tv) {
		technischeVaardigheden = tv;
	}

	public void setFunctioneleVaardigheden(String fv) {
		functioneleVaardigheden = fv;
	}

	public void setWerkervaring(String we) {
		werkervaring = we;
	}

	public void setComputertalen(String ct) {
		computertalen = ct;
	}

	public void setPlatform(String pf) {
		platform = pf;
	}

	public void setPakketen(String pk) {
		pakketten = pk;
	}
}
