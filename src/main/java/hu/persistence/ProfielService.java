package hu.persistence;

import hu.domain.PersoonsGegevens;
import hu.domain.Profiel;
import hu.domain.Vaardigheid;;

public class ProfielService {
	public boolean save (Profiel p) {
		PersoonsGegevensDao persoonsGegevensDao = new PersoonsGegevensPostgresDaoImpl();
		boolean gegevensOK = persoonsGegevensDao.save(p.getGegevens());
		ProfielDao profielDao = new ProfielPostgresDaoImpl();
		boolean profielOK = profielDao.save(p);
		VaardigheidDao vaardigheidDao = new VaardigheidPostgresDaoImpl();
		boolean vaardigheidOK = vaardigheidDao.save(p.getVaardigheden());
		return gegevensOK && profielOK && vaardigheidOK;
	}
}
