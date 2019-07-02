package hu.persistence;

import java.util.List;

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
	
	public boolean updateAlles (Profiel p) {
		PersoonsGegevensDao persoonsGegevensDao = new PersoonsGegevensPostgresDaoImpl();
		System.out.println("in service:"+p.getGegevens());
		boolean gegevensOK = persoonsGegevensDao.update(p.getGegevens());
		VaardigheidDao vaardigheidDao = new VaardigheidPostgresDaoImpl();
		boolean vaardigheidOK = vaardigheidDao.update(p.getVaardigheden());
		ProfielDao profielDao = new ProfielPostgresDaoImpl();
		boolean profielOK = profielDao.update(p);
		return gegevensOK && vaardigheidOK && profielOK;
	}
	
	public boolean deleteAlles(Profiel p) {
		PersoonsGegevensDao persoonsGegevensDao = new PersoonsGegevensPostgresDaoImpl();
		System.out.println("in service:"+p.getGegevens());
		boolean gegevensOK = persoonsGegevensDao.delete(p.getGegevens());
		VaardigheidDao vaardigheidDao = new VaardigheidPostgresDaoImpl();
		boolean vaardigheidOK = vaardigheidDao.delete(p.getVaardigheden());
		ProfielDao profielDao = new ProfielPostgresDaoImpl();
		boolean profielOK = profielDao.delete(p);
		return gegevensOK && vaardigheidOK && profielOK;
	}
}
