package hu.persistence;

import hu.domain.PersoonsGegevens;
import hu.domain.Profiel;
import hu.domain.Vaardigheid;;

public class ProfielService {	
	public boolean saveAlles (Profiel p) {
		PersoonsGegevensDao persoonsGegevensDao = new PersoonsGegevensPostgresDaoImpl();
		System.out.println("in service:"+p.getGegevens());
		boolean gegevensOK = persoonsGegevensDao.save(p.getGegevens());
		VaardigheidDao vaardigheidDao = new VaardigheidPostgresDaoImpl();
		boolean vaardigheidOK = vaardigheidDao.save(p.getVaardigheden());
		ProfielDao profielDao = new ProfielPostgresDaoImpl();
		boolean profielOK = profielDao.save(p);
		return gegevensOK && vaardigheidOK && profielOK;
	}
}
